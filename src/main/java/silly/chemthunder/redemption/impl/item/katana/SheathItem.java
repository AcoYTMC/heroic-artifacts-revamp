package silly.chemthunder.redemption.impl.item.katana;

import com.nitron.nitrogen.util.interfaces.ColorableItem;
import net.acoyt.acornlib.api.item.ModelVaryingItem;
import net.acoyt.acornlib.api.util.MiscUtils;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import silly.chemthunder.redemption.impl.Redemption;
import silly.chemthunder.redemption.impl.index.RedemptionItems;

import java.util.Arrays;
import java.util.List;

public class SheathItem extends Item implements ColorableItem, ModelVaryingItem {
    public int startColor(ItemStack itemStack) {return 0xFF6e5353;}
    public int endColor(ItemStack itemStack) {return 0xFF271e1e;}
    public int backgroundColor(ItemStack itemStack) {return 0xFF1d1212;}

    public SheathItem(Settings settings) {
        super(settings);
    }

    public static SheathItem.KatanaType getKatanaType(Item item) {
        SheathItem.KatanaType type = SheathItem.KatanaType.AMETHYST;
        if (item == RedemptionItems.AMETHYST_SHEATH) {
            type = SheathItem.KatanaType.AMETHYST;
        } else if (item == RedemptionItems.REDSTONE_SHEATH) {
            type = SheathItem.KatanaType.REDSTONE;
        } else if (item == RedemptionItems.SCULK_SHEATH) {
            type = SheathItem.KatanaType.SCULK;
        } else if (item == RedemptionItems.QUARTZ_SHEATH) {
            type = SheathItem.KatanaType.QUARTZ;
        } else if (item == RedemptionItems.EMERALD_SHEATH) {
            type = SheathItem.KatanaType.EMERALD;
        } else if (item == RedemptionItems.COPPER_SHEATH) {
            type = SheathItem.KatanaType.COPPER;
        } else if (item == RedemptionItems.NETHERITE_SHEATH) {
            type = SheathItem.KatanaType.NETHERITE;
        } else if (item == RedemptionItems.LAPIS_SHEATH) {
            type = SheathItem.KatanaType.LAPIS;
        }

        return type;
    }

    public static AttributeModifiersComponent createAttributeModifiers() {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.GENERIC_ARMOR,
                        new EntityAttributeModifier(Identifier.ofVanilla("generic_armor"), 2.5f, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.OFFHAND
                )
                .add(
                        EntityAttributes.GENERIC_MOVEMENT_SPEED,
                        new EntityAttributeModifier(Identifier.ofVanilla("generic_movement_speed"), 0.1f, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.OFFHAND
                )
                .build();
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }

    public Identifier getModel(ModelTransformationMode renderMode, ItemStack stack, @Nullable LivingEntity entity) {
        String texture = "";
        
        switch (getKatanaType(this)) {
            case AMETHYST -> texture = "amethyst";
            case REDSTONE -> texture = "redstone";
            case SCULK -> texture = "sculk";
            case QUARTZ -> texture = "quartz";
            case EMERALD -> texture = "emerald";
            case COPPER -> texture = "copper";
            case NETHERITE -> texture = "netherite";
            case LAPIS -> texture = "lapis";
        }

        Identifier textureId = Redemption.id(texture + "_sheath");
        Identifier altId = Redemption.id(texture + "_sheath_handheld");

        return MiscUtils.isGui(renderMode) ? textureId : altId;
    }

    public List<Identifier> getModelsToLoad() {
        return Arrays.asList(
                Redemption.id("amethyst_sheath"), 
                Redemption.id("amethyst_sheath_handheld"),
                Redemption.id("redstone_sheath"),
                Redemption.id("redstone_sheath_handheld"),
                Redemption.id("sculk_sheath"),
                Redemption.id("sculk_sheath_handheld"),
                Redemption.id("quartz_sheath"),
                Redemption.id("quartz_sheath_handheld"),
                Redemption.id("emerald_sheath"),
                Redemption.id("emerald_sheath_handheld"),
                Redemption.id("copper_sheath"),
                Redemption.id("copper_sheath_handheld"),
                Redemption.id("netherite_sheath"),
                Redemption.id("netherite_sheath_handheld"),
                Redemption.id("lapis_sheath"),
                Redemption.id("lapis_sheath_handheld"));
    }

    public enum KatanaType {
        REDSTONE,
        EMERALD,
        QUARTZ,
        NETHERITE,
        COPPER,
        AMETHYST,
        LAPIS,
        SCULK
    }
}