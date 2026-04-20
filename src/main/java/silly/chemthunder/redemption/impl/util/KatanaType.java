package silly.chemthunder.redemption.impl.util;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.StringIdentifiable;

import java.util.Arrays;
import java.util.List;

import static silly.chemthunder.redemption.impl.index.RedemptionItems.*;

@SuppressWarnings("deprecation")
public enum KatanaType implements StringIdentifiable {
    AMETHYST("amethyst",
            AMETHYST_KATANA, AMETHYST_SHEATH, SHEATHED_AMETHYST_KATANA,
            StatusEffects.SPEED
    ),
    COPPER("copper",
            COPPER_KATANA, COPPER_SHEATH, SHEATHED_COPPER_KATANA,
            StatusEffects.TRIAL_OMEN
    ),
    EMERALD("emerald",
            EMERALD_KATANA, EMERALD_SHEATH, SHEATHED_EMERALD_KATANA,
            StatusEffects.HERO_OF_THE_VILLAGE
    ),
    LAPIS("lapis",
            LAPIS_KATANA, LAPIS_SHEATH, SHEATHED_LAPIS_KATANA,
            StatusEffects.HASTE
    ),
    NETHERITE("netherite",
            NETHERITE_KATANA, NETHERITE_SHEATH, SHEATHED_NETHERITE_KATANA,
            StatusEffects.STRENGTH, StatusEffects.RESISTANCE
    ),
    QUARTZ("quartz",
            QUARTZ_KATANA, QUARTZ_SHEATH, SHEATHED_QUARTZ_KATANA,
            StatusEffects.FIRE_RESISTANCE
    ),
    REDSTONE("redstone",
            REDSTONE_KATANA, REDSTONE_SHEATH, SHEATHED_REDSTONE_KATANA,
            StatusEffects.STRENGTH
    ),
    SCULK("sculk",
            SCULK_KATANA, SCULK_SHEATH, SHEATHED_SCULK_KATANA
    ), // No effects
    ASHIRO("ashiro",
            ASHIRO_KATANA, ASHIRO_SHEATH, SHEATHED_ASHIRO_KATANA
    ); // No effects

    public static final StringIdentifiable.EnumCodec<KatanaType> CODEC = StringIdentifiable.createCodec(KatanaType::values);

    public final String id;
    public final Item katana;
    public final Item sheath;
    public final Item sheathed;
    private final List<Item> items;
    public final List<StatusEffectInstance> effectInstances;

    KatanaType(String id, Item katana, Item sheath, Item sheathed, RegistryEntry<StatusEffect>... effects) {
        this.id = id;
        this.katana = katana;
        this.sheath = sheath;
        this.sheathed = sheathed;
        this.items = Arrays.asList(katana, sheath, sheathed);
        this.effectInstances = Arrays.stream(effects).map(entry -> new StatusEffectInstance(entry, 400)).toList();
    }

    public static KatanaType getForItem(Item item) {
        for (KatanaType type : values()) {
            if (type.items.contains(item)) {
                return type;
            }
        }

        return AMETHYST;
    }

    public String asString() {
        return this.id;
    }
}
