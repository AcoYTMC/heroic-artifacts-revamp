package silly.chemthunder.redemption.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.DamageTypeTags;
import silly.chemthunder.redemption.impl.index.data.RedemptionDamageSources;

import java.util.concurrent.CompletableFuture;

public class RedemptionDamageTypeTagGen extends FabricTagProvider<DamageType> {
    public RedemptionDamageTypeTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.DAMAGE_TYPE, registriesFuture);
    }

    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        this.getOrCreateTagBuilder(DamageTypeTags.BYPASSES_ARMOR)
                .add(RedemptionDamageSources.DESCEND)
                .add(RedemptionDamageSources.IMMOLATION)
                .setReplace(false);

        this.getOrCreateTagBuilder(DamageTypeTags.NO_KNOCKBACK)
                .add(RedemptionDamageSources.DESCEND)
                .setReplace(false);
    }
}
