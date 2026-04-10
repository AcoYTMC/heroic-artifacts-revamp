package silly.chemthunder.redemption.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.nitron.nitrogen.util.interfaces.ScreenShaker;
import net.minecraft.entity.Attackable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import silly.chemthunder.redemption.cca.FlashComponent;
import silly.chemthunder.redemption.cca.JudgementPlayerComponent;
import silly.chemthunder.redemption.index.RedemptionDamageSources;
import silly.chemthunder.redemption.index.RedemptionEntities;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements Attackable {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "tryUseTotem", at = @At("HEAD"), cancellable = true)
    private void deathEffect(DamageSource deathSource, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity living = (LivingEntity) (Object) this;

        if (living instanceof PlayerEntity player) {
            JudgementPlayerComponent judge = JudgementPlayerComponent.KEY.get(player);

            if (judge.isJudgement) {
                if (!deathSource.isOf(RedemptionDamageSources.DESCEND)) {
                    player.setHealth(player.getMaxHealth());
                    player.setVelocity(0, 0.3, 0);
                    player.velocityModified = true;
                    player.setNoGravity(true);
                    player.setInvulnerable(true);
                    player.noClip = true;

                    judge.monologueTicks = 200;
                    judge.sync();
                    cir.setReturnValue(true);
                }
            }
        }
    }

    @ModifyReturnValue(method = "getMaxHealth", at = @At("RETURN"))
    private float judge$maxHealth(float original) {
        LivingEntity living = (LivingEntity) (Object) this;

        if (living instanceof PlayerEntity player && JudgementPlayerComponent.KEY.get(player).isJudgement) {
            return 40.0f;
        }
        return original;
    }

    @WrapMethod(method = "heal")
    private void judge$boostedHeal(float amount, Operation<Void> original) {
        LivingEntity living = (LivingEntity) (Object) this;

        if (living instanceof PlayerEntity player) {
            original.call(JudgementPlayerComponent.KEY.get(player).isJudgement ? amount * 2 : amount);
        } else {
            original.call(amount);
        }
    }
}