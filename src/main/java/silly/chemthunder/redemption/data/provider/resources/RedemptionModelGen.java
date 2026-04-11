package silly.chemthunder.redemption.data.provider.resources;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import silly.chemthunder.redemption.impl.index.RedemptionItems;
import silly.chemthunder.redemption.impl.index.client.RedemptionModels;
import silly.chemthunder.redemption.impl.item.katana.KatanaItem;
import silly.chemthunder.redemption.impl.item.katana.SheathItem;
import silly.chemthunder.redemption.impl.item.katana.SheathedKatanaItem;

public class RedemptionModelGen extends FabricModelProvider {
    public RedemptionModelGen(FabricDataOutput output) {
        super(output);
    }

    public void generateBlockStateModels(BlockStateModelGenerator generator) {}

    public void generateItemModels(ItemModelGenerator generator) {
        for (Item item : RedemptionItems.ITEMS.toRegister) {
            if (item instanceof KatanaItem) {
                generator.register(item, Models.GENERATED);
                generator.register(item, "_in_hand", RedemptionModels.KATANA_IN_HAND);
            }

            if (item instanceof SheathItem) {
                generator.register(item, Models.GENERATED);
                generator.register(item, "_in_hand", RedemptionModels.SHEATH_IN_HAND);
            }

            if (item instanceof SheathedKatanaItem) {
                generator.register(item, Models.GENERATED);
                generator.register(item, "_in_hand", RedemptionModels.SHEATHED_IN_HAND);
            }
        }

        generator.register(RedemptionItems.COURT_GLASS, Models.GENERATED);
        generator.register(RedemptionItems.HUNTERS_GLASS, Models.GENERATED);
    }
}
