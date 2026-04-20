package silly.chemthunder.redemption.data.provider.resources;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import silly.chemthunder.redemption.impl.component.KatanaComponent;
import silly.chemthunder.redemption.impl.index.RedemptionDataComponents;
import silly.chemthunder.redemption.impl.index.RedemptionItems;
import silly.chemthunder.redemption.impl.index.client.RedemptionModels;
import silly.chemthunder.redemption.impl.item.KatanaItem;

public class RedemptionModelGen extends FabricModelProvider {
    public RedemptionModelGen(FabricDataOutput output) {
        super(output);
    }

    public void generateBlockStateModels(BlockStateModelGenerator generator) {}

    public void generateItemModels(ItemModelGenerator generator) {
        for (Item item : RedemptionItems.ITEMS.toRegister) {
            if (item instanceof KatanaItem) {
                registerKatana(generator, item);
            }
        }

        generator.register(RedemptionItems.COURT_GLASS, Models.GENERATED);
        generator.register(RedemptionItems.HUNTERS_GLASS, Models.GENERATED);
    }

    private static void registerKatana(ItemModelGenerator generator, Item item) {
        KatanaComponent component = item.getDefaultStack().getOrDefault(RedemptionDataComponents.KATANA, KatanaComponent.DEFAULT);
        Identifier itemId = Registries.ITEM.getId(item).withPrefixedPath("item/");
        Identifier inHandId = itemId.withSuffixedPath("_in_hand");
        Models.GENERATED.upload(itemId, TextureMap.layer0(itemId), generator.writer);

        Model inHandModel = component.getBladeType() == KatanaComponent.BladeType.KATANA
                ? RedemptionModels.KATANA_IN_HAND
                : component.getBladeType() == KatanaComponent.BladeType.SHEATH
                ? RedemptionModels.SHEATH_IN_HAND
                : RedemptionModels.SHEATHED_KATANA_IN_HAND;

        inHandModel.upload(inHandId, TextureMap.layer0(inHandId), generator.writer);
    }
}
