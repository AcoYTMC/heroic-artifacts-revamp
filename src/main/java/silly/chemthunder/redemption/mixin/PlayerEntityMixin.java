package silly.chemthunder.redemption.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import silly.chemthunder.redemption.impl.cca.entity.EnshroudedComponent;
import silly.chemthunder.redemption.impl.cca.entity.JudgementComponent;
import silly.chemthunder.redemption.impl.index.RedemptionParticles;
import silly.chemthunder.redemption.impl.index.tag.RedemptionItemTags;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "playStepSound", at = @At("RETURN"), cancellable = true)
    private void cancelStepSounds(BlockPos pos, BlockState state, CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        if (EnshroudedComponent.KEY.get(player).isShrouded) {
            ci.cancel();
        }
    }

    @Inject(method = "attack", at = @At("TAIL"))
    private void disableShroudUponAttack(Entity target, CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        disableCloak(player);
    }

    @Inject(method = "damage", at = @At("TAIL"))
    private void disableShroudUponDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        disableCloak(player);
    }

    @Unique public void disableCloak(PlayerEntity player) {
        EnshroudedComponent comp = EnshroudedComponent.KEY.get(player);
        double x = player.getX();
        double y = player.getY();
        double z = player.getZ();

        if (comp.isShrouded) {
            comp.isShrouded = false;
            comp.sync();
            player.setInvisible(false);
            if (getWorld() instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(RedemptionParticles.HUNTER_OMEN, x, y + 0.5f, z, 15, 0, 0, 0, 0.03f);
                serverWorld.spawnParticles(ParticleTypes.SQUID_INK, x, y + 0.5f, z, 15, 0, 0, 0, 0.03f);
            }
        }
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void playerTicker(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (player.getStackInHand(player.getActiveHand()).isIn(RedemptionItemTags.KATANAS) && player.isUsingItem() && JudgementComponent.KEY.get(player).isJudgement) {
            getWorld().addParticle(ParticleTypes.SCULK_SOUL, true, player.getX(), player.getY(), player.getZ(), 0, 0, 0);
        }
    }
}