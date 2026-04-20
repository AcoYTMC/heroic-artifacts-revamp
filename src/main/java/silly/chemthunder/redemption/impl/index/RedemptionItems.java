package silly.chemthunder.redemption.impl.index;

import net.acoyt.acornlib.api.registrants.ItemRegistrant;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvents;
import silly.chemthunder.redemption.impl.Redemption;
import silly.chemthunder.redemption.impl.component.KatanaComponent;
import silly.chemthunder.redemption.impl.item.CourtGlassItem;
import silly.chemthunder.redemption.impl.item.HuntersCourtGlassItem;
import silly.chemthunder.redemption.impl.item.KatanaItem;
import silly.chemthunder.redemption.impl.util.RedemptionItemSettings;
import silly.chemthunder.redemption.impl.util.KatanaType;

import static net.acoyt.acornlib.api.util.ItemUtils.modifyItemNameColor;

public interface RedemptionItems {
    ItemRegistrant ITEMS = new ItemRegistrant(Redemption.MOD_ID);

    Item QUARTZ_KATANA = ITEMS.register("quartz_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.QUARTZ)
            .sweepParticle(0xFFc1c1d2, 0xFF535373)
            .hitSound(SoundEvents.BLOCK_NETHERRACK_BREAK)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));

    Item REDSTONE_KATANA = ITEMS.register("redstone_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.REDSTONE)
            .sweepParticle(0xFFe95050, 0xFF63374a)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));

    Item AMETHYST_KATANA = ITEMS.register("amethyst_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.AMETHYST)
            .sweepParticle(0xFFffffff, 0xFFc1c2c2)
            .hitSound(SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));

    Item COPPER_KATANA = ITEMS.register("copper_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.COPPER)
            .sweepParticle(0xFFea8770, 0xFF904931)
            .hitSound(SoundEvents.BLOCK_COPPER_BULB_BREAK)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));

    Item LAPIS_KATANA = ITEMS.register("lapis_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.LAPIS)
            .sweepParticle(0xFFc9edf9, 0xFF8bcadd)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));

    Item NETHERITE_KATANA = ITEMS.register("netherite_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.NETHERITE)
            .sweepParticle(0xFF1a1a1a, 0xFF0e0e0e)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));

    Item EMERALD_KATANA = ITEMS.register("emerald_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.EMERALD)
            .sweepParticle(0xFF20d64b, 0xFF096a31)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));

    Item SCULK_KATANA = ITEMS.register("sculk_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.SCULK)
            .sweepParticle(0xFF111b21, 0xFF034150)
            .hitSound(SoundEvents.BLOCK_SCULK_PLACE)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));

    // Sheaths
//    Item QUARTZ_SHEATH = ITEMS.register("quartz_sheath", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATH, KatanaType.QUARTZ)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATH)));
//
//    Item REDSTONE_SHEATH = ITEMS.register("redstone_sheath", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATH, KatanaType.REDSTONE)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATH)));
//
//    Item EMERALD_SHEATH = ITEMS.register("emerald_sheath", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATH, KatanaType.EMERALD)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATH)));
//
//    Item COPPER_SHEATH = ITEMS.register("copper_sheath", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATH, KatanaType.COPPER)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATH)));
//
//    Item NETHERITE_SHEATH = ITEMS.register("netherite_sheath", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATH, KatanaType.NETHERITE)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATH)));
//
//    Item AMETHYST_SHEATH = ITEMS.register("amethyst_sheath", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATH, KatanaType.AMETHYST)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATH)));
//
//    Item SCULK_SHEATH = ITEMS.register("sculk_sheath", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATH, KatanaType.SCULK)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATH)));
//
//    Item LAPIS_SHEATH = ITEMS.register("lapis_sheath", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATH, KatanaType.LAPIS)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATH)));


    // Sheathed Katanas
//    Item SHEATHED_AMETHYST_KATANA = ITEMS.register("sheathed_amethyst_katana", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATHED, KatanaType.AMETHYST)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATHED)));
//
//    Item SHEATHED_NETHERITE_KATANA = ITEMS.register("sheathed_netherite_katana", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATHED, KatanaType.NETHERITE)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATHED)));
//
//    Item SHEATHED_LAPIS_KATANA = ITEMS.register("sheathed_lapis_katana", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATHED, KatanaType.LAPIS)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATHED)));
//
//    Item SHEATHED_REDSTONE_KATANA = ITEMS.register("sheathed_redstone_katana", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATHED, KatanaType.REDSTONE)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATHED)));
//
//    Item SHEATHED_EMERALD_KATANA = ITEMS.register("sheathed_emerald_katana", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATHED, KatanaType.EMERALD)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATHED)));
//
//    Item SHEATHED_SCULK_KATANA = ITEMS.register("sheathed_sculk_katana", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATHED, KatanaType.SCULK)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATHED)));
//
//    Item SHEATHED_QUARTZ_KATANA = ITEMS.register("sheathed_quartz_katana", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATHED, KatanaType.QUARTZ)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATHED)));
//
//    Item SHEATHED_COPPER_KATANA = ITEMS.register("sheathed_copper_katana", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATHED, KatanaType.COPPER)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATHED)));


    // Ashiro
    Item ASHIRO_KATANA = ITEMS.register("ashiro_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.ASHIRO)
            .maxCount(1)
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));

//    Item ASHIRO_SHEATH = ITEMS.register("ashiro_sheath", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATH, KatanaType.ASHIRO)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATH)));
//
//    Item SHEATHED_ASHIRO_KATANA = ITEMS.register("sheathed_ashiro_katana", KatanaItem::new, new KatanaSettings()
//            .katana(KatanaComponent.BladeType.SHEATHED, KatanaType.ASHIRO)
//            .maxCount(1)
//            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.SHEATHED)));


    // Misc
    Item COURT_GLASS = ITEMS.register("court_glass", CourtGlassItem::new, new RedemptionItemSettings()
            .maxCount(1));

    Item HUNTERS_GLASS = ITEMS.register("hunters_glass", HuntersCourtGlassItem::new, new RedemptionItemSettings()
            .maxCount(1));

    static void init() {
        // Colors
        modifyItemNameColor(QUARTZ_KATANA, 0xFFc1c1d2);
//        modifyItemNameColor(QUARTZ_SHEATH, 0xFFc1c1d2);
//        modifyItemNameColor(SHEATHED_QUARTZ_KATANA, 0xFFc1c1d2);

        modifyItemNameColor(REDSTONE_KATANA, 0xFFe95050);
//        modifyItemNameColor(REDSTONE_SHEATH, 0xFFe95050);
//        modifyItemNameColor(SHEATHED_REDSTONE_KATANA, 0xFFe95050);

        modifyItemNameColor(AMETHYST_KATANA, 0xFFe28aff);
//        modifyItemNameColor(AMETHYST_SHEATH, 0xFFe28aff);
//        modifyItemNameColor(SHEATHED_AMETHYST_KATANA, 0xFFe28aff);

        modifyItemNameColor(SCULK_KATANA, 0xFF041716);
//        modifyItemNameColor(SCULK_SHEATH, 0xFF041716);
//        modifyItemNameColor(SHEATHED_SCULK_KATANA, 0xFF041716);

        modifyItemNameColor(COPPER_KATANA, 0xFF904931);
//        modifyItemNameColor(COPPER_SHEATH, 0xFF904931);
//        modifyItemNameColor(SHEATHED_COPPER_KATANA, 0xFF904931);

        modifyItemNameColor(LAPIS_KATANA, 0xFF8bcadd);
//        modifyItemNameColor(LAPIS_SHEATH, 0xFF8bcadd);
//        modifyItemNameColor(SHEATHED_LAPIS_KATANA, 0xFF8bcadd);

        modifyItemNameColor(EMERALD_KATANA, 0xFF096a31);
//        modifyItemNameColor(EMERALD_SHEATH, 0xFF096a31);
//        modifyItemNameColor(SHEATHED_EMERALD_KATANA, 0xFF096a31);

        modifyItemNameColor(NETHERITE_KATANA, 0xFFe4d971);
//        modifyItemNameColor(NETHERITE_SHEATH, 0xFFe4d971);
//        modifyItemNameColor(SHEATHED_NETHERITE_KATANA, 0xFFe4d971);

        modifyItemNameColor(ASHIRO_KATANA, 0xFF942929);
//        modifyItemNameColor(ASHIRO_SHEATH, 0xFF942929);
//        modifyItemNameColor(SHEATHED_ASHIRO_KATANA, 0xFF942929);

        modifyItemNameColor(HUNTERS_GLASS, 0xFFb629eb);
        modifyItemNameColor(COURT_GLASS, 0xFF59ffff);
    }
}
