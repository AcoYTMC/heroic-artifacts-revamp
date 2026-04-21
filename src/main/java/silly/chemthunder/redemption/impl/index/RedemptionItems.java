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
            .colors(0xFFc1c1d2)
            .sweepParticle(0xFFc1c1d2, 0xFF535373)
            .hitSound(SoundEvents.BLOCK_NETHERRACK_BREAK)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));

    Item REDSTONE_KATANA = ITEMS.register("redstone_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.REDSTONE)
            .colors(0xFFe95050)
            .sweepParticle(0xFFe95050, 0xFF63374a)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));

    Item AMETHYST_KATANA = ITEMS.register("amethyst_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.AMETHYST)
            .colors(0xFFe28aff)
            .sweepParticle(0xFFffffff, 0xFFc1c2c2)
            .hitSound(SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));

    Item COPPER_KATANA = ITEMS.register("copper_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.COPPER)
            .colors(0xFF904931)
            .sweepParticle(0xFFea8770, 0xFF904931)
            .hitSound(SoundEvents.BLOCK_COPPER_BULB_BREAK)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));

    Item LAPIS_KATANA = ITEMS.register("lapis_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.LAPIS)
            .colors(0xFF8bcadd)
            .sweepParticle(0xFFc9edf9, 0xFF8bcadd)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));

    Item NETHERITE_KATANA = ITEMS.register("netherite_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.NETHERITE)
            .colors(0xFFe4d971)
            .sweepParticle(0xFF1a1a1a, 0xFF0e0e0e)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));

    Item EMERALD_KATANA = ITEMS.register("emerald_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.EMERALD)
            .colors(0xFF096a31)
            .sweepParticle(0xFF20d64b, 0xFF096a31)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));

    Item SCULK_KATANA = ITEMS.register("sculk_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.SCULK)
            .colors(0xFF041716)
            .sweepParticle(0xFF111b21, 0xFF034150)
            .hitSound(SoundEvents.BLOCK_SCULK_PLACE)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));


    // Ashiro
    Item ASHIRO_KATANA = ITEMS.register("ashiro_katana", KatanaItem::new, new RedemptionItemSettings()
            .katana(KatanaComponent.BladeType.KATANA, KatanaType.ASHIRO)
            .colors(0xFF942929, 0xFF450909, 0xFF942929, 0xFF171414)
            .maxCount(1)
            .attributeModifiers(KatanaItem.createAttributeModifiers(KatanaComponent.BladeType.KATANA)));


    // Misc
    Item COURT_GLASS = ITEMS.register("court_glass", CourtGlassItem::new, new RedemptionItemSettings()
            .maxCount(1));

    Item HUNTERS_GLASS = ITEMS.register("hunters_glass", HuntersCourtGlassItem::new, new RedemptionItemSettings()
            .maxCount(1));

    static void init() {
        // Colors
        modifyItemNameColor(HUNTERS_GLASS, 0xFFb629eb);
        modifyItemNameColor(COURT_GLASS, 0xFF59ffff);
    }
}
