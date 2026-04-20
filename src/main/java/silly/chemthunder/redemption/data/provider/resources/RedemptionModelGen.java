package silly.chemthunder.redemption.data.provider.resources;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
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
        Identifier id = Registries.ITEM.getId(item).withPrefixedPath("item/");
        Identifier katanaId = id.withSuffixedPath("_katana");
        Identifier katanaInHandId = katanaId.withSuffixedPath("_in_hand");
        Identifier sheathId = id.withSuffixedPath("_sheath");
        Identifier sheathInHandId = sheathId.withSuffixedPath("_in_hand");
        Identifier sheathedId = id.withPrefixedPath("sheathed_").withSuffixedPath("_katana");
        Identifier sheathedInHandId = sheathedId.withSuffixedPath("_in_hand");

        Models.GENERATED.upload(katanaId, TextureMap.layer0(katanaId), generator.writer);
        Models.GENERATED.upload(sheathId, TextureMap.layer0(sheathId), generator.writer);
        Models.GENERATED.upload(sheathedId, TextureMap.layer0(sheathedId), generator.writer);
        RedemptionModels.KATANA_IN_HAND.upload(katanaInHandId, TextureMap.layer0(katanaInHandId), generator.writer);
        RedemptionModels.SHEATH_IN_HAND.upload(sheathInHandId, TextureMap.layer0(sheathInHandId), generator.writer);
        RedemptionModels.SHEATHED_KATANA_IN_HAND.upload(sheathedInHandId, TextureMap.layer0(sheathedInHandId), generator.writer);
    }

    private static void registerInHandVarying(ItemModelGenerator generator, Item item, Model inHandModel) {
        Identifier id = Registries.ITEM.getId(item).withPrefixedPath("item/");
        Identifier inHandId = id.withSuffixedPath("_in_hand");

        Models.GENERATED.upload(id, TextureMap.layer0(id), generator.writer);
        inHandModel.upload(inHandId, TextureMap.layer0(inHandId), generator.writer);
    }
}
