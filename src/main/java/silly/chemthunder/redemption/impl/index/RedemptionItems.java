package silly.chemthunder.redemption.impl.index;

import net.acoyt.acornlib.api.item.AcornItemSettings;
import net.acoyt.acornlib.api.registrants.ItemRegistrant;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvents;
import silly.chemthunder.redemption.impl.Redemption;
import silly.chemthunder.redemption.impl.item.AshiroKatanaItem;
import silly.chemthunder.redemption.impl.item.CourtGlassItem;
import silly.chemthunder.redemption.impl.item.HuntersCourtGlassItem;
import silly.chemthunder.redemption.impl.item.ModelVaryingTextureTester;
import silly.chemthunder.redemption.impl.item.katana.KatanaItem;
import silly.chemthunder.redemption.impl.item.katana.SheathItem;
import silly.chemthunder.redemption.impl.item.katana.SheathedKatanaItem;

import static net.acoyt.acornlib.api.util.ItemUtils.modifyItemNameColor;

public interface RedemptionItems {
    ItemRegistrant ITEMS = new ItemRegistrant(Redemption.MOD_ID);

    Item QUARTZ_KATANA = ITEMS.register("quartz_katana", new KatanaItem(new AcornItemSettings()
            .sweepParticle(0xc1c1d2, 0x535373)
            .hitSound(SoundEvents.BLOCK_NETHERRACK_BREAK)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers())
    ));

    Item REDSTONE_KATANA = ITEMS.register("redstone_katana", new KatanaItem(new AcornItemSettings()
            .sweepParticle(0xe95050, 0x63374a)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers())
    ));

    Item AMETHYST_KATANA = ITEMS.register("amethyst_katana", new KatanaItem(new AcornItemSettings()
            .sweepParticle(0xffffff, 0xc1c2c2)
            .hitSound(SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers())
    ));

    Item COPPER_KATANA = ITEMS.register("copper_katana", new KatanaItem(new AcornItemSettings()
            .sweepParticle(0xea8770, 0x904931)
            .hitSound(SoundEvents.BLOCK_COPPER_BULB_BREAK)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers())
    ));

    Item LAPIS_KATANA = ITEMS.register("lapis_katana", new KatanaItem(new AcornItemSettings()
            .sweepParticle(0xc9edf9, 0x8bcadd)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers())
    ));

    Item NETHERITE_KATANA = ITEMS.register("netherite_katana", new KatanaItem(new AcornItemSettings()
            .sweepParticle(0x1a1a1a, 0x0e0e0e)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers())
    ));

    Item EMERALD_KATANA = ITEMS.register("emerald_katana", new KatanaItem(new AcornItemSettings()
            .sweepParticle(0x20d64b, 0x096a31)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers())
    ));

    Item SCULK_KATANA = ITEMS.register("sculk_katana", new KatanaItem(new AcornItemSettings()
            .sweepParticle(0x111b21, 0x034150)
            .hitSound(SoundEvents.BLOCK_SCULK_PLACE)
            .maxCount(1)
            .fireproof()
            .attributeModifiers(KatanaItem.createAttributeModifiers())
    ));

    Item QUARTZ_SHEATH = ITEMS.register("quartz_sheath", new SheathItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(SheathItem.createAttributeModifiers())
    ));

    Item REDSTONE_SHEATH = ITEMS.register("redstone_sheath", new SheathItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(SheathItem.createAttributeModifiers())
    ));

    Item EMERALD_SHEATH = ITEMS.register("emerald_sheath", new SheathItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(SheathItem.createAttributeModifiers())
    ));

    Item COPPER_SHEATH = ITEMS.register("copper_sheath", new SheathItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(SheathItem.createAttributeModifiers())
    ));

    Item NETHERITE_SHEATH = ITEMS.register("netherite_sheath", new SheathItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(SheathItem.createAttributeModifiers())
    ));

    Item AMETHYST_SHEATH = ITEMS.register("amethyst_sheath", new SheathItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(SheathItem.createAttributeModifiers())
    ));

    Item SCULK_SHEATH = ITEMS.register("sculk_sheath", new SheathItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(SheathItem.createAttributeModifiers())
    ));

    Item LAPIS_SHEATH = ITEMS.register("lapis_sheath", new SheathItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(SheathItem.createAttributeModifiers())
    ));


    // sheathed katanas
    Item AMETHYST_SHEATHED = ITEMS.register("amethyst_sheathed", new SheathedKatanaItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(SheathedKatanaItem.createAttributeModifiers())
    ));

    Item NETHERITE_SHEATHED = ITEMS.register("netherite_sheathed", new SheathedKatanaItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(SheathedKatanaItem.createAttributeModifiers())
    ));

    Item LAPIS_SHEATHED = ITEMS.register("lapis_sheathed", new SheathedKatanaItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(SheathedKatanaItem.createAttributeModifiers())
    ));

    Item REDSTONE_SHEATHED = ITEMS.register("redstone_sheathed", new SheathedKatanaItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(SheathedKatanaItem.createAttributeModifiers())
    ));

    Item EMERALD_SHEATHED = ITEMS.register("emerald_sheathed", new SheathedKatanaItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(SheathedKatanaItem.createAttributeModifiers())
    ));

    Item SCULK_SHEATHED = ITEMS.register("sculk_sheathed", new SheathedKatanaItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(SheathedKatanaItem.createAttributeModifiers())
    ));

    Item QUARTZ_SHEATHED = ITEMS.register("quartz_sheathed", new SheathedKatanaItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(SheathedKatanaItem.createAttributeModifiers())
    ));

    Item COPPER_SHEATHED = ITEMS.register("copper_sheathed", new SheathedKatanaItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(SheathedKatanaItem.createAttributeModifiers())
    ));

    Item COURT_GLASS = ITEMS.register("court_glass", new CourtGlassItem(new AcornItemSettings()
            .maxCount(1)
    ));

    Item HUNTERS_GLASS = ITEMS.register("hunters_glass", new HuntersCourtGlassItem(new AcornItemSettings()
            .maxCount(1)
    ));

    Item ASHIRO_KATANA = ITEMS.register("ashiro_katana", new AshiroKatanaItem(new AcornItemSettings()
            .maxCount(1)
            .attributeModifiers(KatanaItem.createAttributeModifiers())
    ));

    Item TEXTURE_TESTER = ITEMS.register("texture_tester", new ModelVaryingTextureTester(new AcornItemSettings()));

    static void init() {
        // Colors
        modifyItemNameColor(QUARTZ_KATANA, 0xc1c1d2);
        modifyItemNameColor(QUARTZ_SHEATH, 0xc1c1d2);
        modifyItemNameColor(QUARTZ_SHEATHED, 0xc1c1d2);

        modifyItemNameColor(REDSTONE_KATANA, 0xe95050);
        modifyItemNameColor(REDSTONE_SHEATH, 0xe95050);
        modifyItemNameColor(REDSTONE_SHEATHED, 0xe95050);

        modifyItemNameColor(AMETHYST_KATANA, 0xe28aff);
        modifyItemNameColor(AMETHYST_SHEATH, 0xe28aff);
        modifyItemNameColor(AMETHYST_SHEATHED, 0xe28aff);

        modifyItemNameColor(SCULK_KATANA, 0x041716);
        modifyItemNameColor(SCULK_SHEATH, 0x041716);
        modifyItemNameColor(SCULK_SHEATHED, 0x041716);

        modifyItemNameColor(COPPER_KATANA, 0x904931);
        modifyItemNameColor(COPPER_SHEATH, 0x904931);
        modifyItemNameColor(COPPER_SHEATHED, 0x904931);

        modifyItemNameColor(LAPIS_KATANA, 0x8bcadd);
        modifyItemNameColor(LAPIS_SHEATH, 0x8bcadd);
        modifyItemNameColor(LAPIS_SHEATHED, 0x8bcadd);

        modifyItemNameColor(EMERALD_KATANA, 0x096a31);
        modifyItemNameColor(EMERALD_SHEATH, 0x096a31);
        modifyItemNameColor(EMERALD_SHEATHED, 0x096a31);

        modifyItemNameColor(NETHERITE_KATANA, 0xe4d971);
        modifyItemNameColor(NETHERITE_SHEATH, 0xe4d971);
        modifyItemNameColor(NETHERITE_SHEATHED, 0xe4d971);

        modifyItemNameColor(HUNTERS_GLASS, 0xb629eb);
        modifyItemNameColor(COURT_GLASS, 0x59ffff);
        modifyItemNameColor(ASHIRO_KATANA, 0x942929);
    }
}
