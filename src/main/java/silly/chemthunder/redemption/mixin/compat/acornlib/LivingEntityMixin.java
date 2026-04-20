package silly.chemthunder.redemption.mixin.compat.acornlib;

import com.bawnorton.mixinsquared.TargetHandler;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = LivingEntity.class, priority = 1500)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @TargetHandler(
            mixin = "net.acoyt.acornlib.mixin.LivingEntityMixin",
            name = "acornlib$modifyDamageSource"
    )
    @ModifyExpressionValue(
            method = "@MixinSquared:Handler",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/acoyt/acornlib/api/item/CustomKillSourceItem;getKillSource(Lnet/minecraft/entity/LivingEntity;)Lnet/minecraft/entity/damage/DamageSource;"
            )
    )
    private DamageSource originalIfNull(DamageSource original, @Local(argsOnly = true) DamageSource source) {
        return original != null ? original : source;
    }
}
