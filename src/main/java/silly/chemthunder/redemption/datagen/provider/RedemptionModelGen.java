package silly.chemthunder.redemption.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import silly.chemthunder.redemption.index.RedemptionItems;
import silly.chemthunder.redemption.index.client.RedemptionModels;
import silly.chemthunder.redemption.item.katana.KatanaItem;
import silly.chemthunder.redemption.item.katana.SheathItem;
import silly.chemthunder.redemption.item.katana.SheathedKatanaItem;

public class RedemptionModelGen extends FabricModelProvider {
    public RedemptionModelGen(FabricDataOutput output) {
        super(output);
    }

    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {}

    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for (Item item : RedemptionItems.ITEMS.toRegister) {
            if (item instanceof KatanaItem) {
                itemModelGenerator.register(item, Models.GENERATED);
                itemModelGenerator.register(item, "_handheld", RedemptionModels.KATANA_HANDHELD);
            }

            if (item instanceof SheathItem) {
                itemModelGenerator.register(item, Models.GENERATED);
                itemModelGenerator.register(item, "_handheld", RedemptionModels.SHEATH_HANDHELD);
            }

            if (item instanceof SheathedKatanaItem) {
                itemModelGenerator.register(item, Models.GENERATED);
                itemModelGenerator.register(item, "_handheld", RedemptionModels.SHEATHED_HANDHELD);
            }
        }

        itemModelGenerator.register(RedemptionItems.COURT_GLASS, Models.GENERATED);
        itemModelGenerator.register(RedemptionItems.HUNTERS_GLASS, Models.GENERATED);
    }
}