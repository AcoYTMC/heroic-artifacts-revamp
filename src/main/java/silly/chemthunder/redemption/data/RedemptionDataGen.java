package silly.chemthunder.redemption.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import silly.chemthunder.redemption.data.provider.*;
import silly.chemthunder.redemption.impl.index.data.RedemptionDamageSources;

public class RedemptionDataGen implements DataGeneratorEntrypoint {
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(RedemptionDynamicRegistryGen::new);
        pack.addProvider(RedemptionLangGen::new);
        pack.addProvider(RedemptionModelGen::new);
        pack.addProvider(RedemptionDamageTypeTagGen::new);
        pack.addProvider(RedemptionItemTagGen::new);
	}

    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.DAMAGE_TYPE, RedemptionDamageSources::bootstrap);
    }
}