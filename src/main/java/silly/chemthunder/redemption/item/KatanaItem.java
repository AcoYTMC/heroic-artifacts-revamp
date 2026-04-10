package silly.chemthunder.redemption.item;

import com.nitron.nitrogen.util.interfaces.ColorableItem;
import net.acoyt.acornlib.api.item.CustomKillSourceItem;
import net.acoyt.acornlib.api.item.ModelVaryingItem;
import net.acoyt.acornlib.api.util.MiscUtils;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import silly.chemthunder.redemption.Redemption;
import silly.chemthunder.redemption.cca.JudgementPlayerComponent;
import silly.chemthunder.redemption.index.RedemptionDamageSources;
import silly.chemthunder.redemption.index.RedemptionItems;

import java.util.Arrays;
import java.util.List;

public class KatanaItem extends Item implements ColorableItem, CustomKillSourceItem, ModelVaryingItem {
    public KatanaItem(Settings settings) {
        super(settings);
    }

    public static KatanaItem.KatanaType getKatanaType(Item item) {
        KatanaItem.KatanaType type = KatanaType.AMETHYST;
        if (item == RedemptionItems.AMETHYST_KATANA) {
            type = KatanaItem.KatanaType.AMETHYST;
        } else if (item == RedemptionItems.REDSTONE_KATANA) {
            type = KatanaItem.KatanaType.REDSTONE;
        } else if (item == RedemptionItems.SCULK_KATANA) {
            type = KatanaItem.KatanaType.SCULK;
        } else if (item == RedemptionItems.QUARTZ_KATANA) {
            type = KatanaItem.KatanaType.QUARTZ;
        } else if (item == RedemptionItems.EMERALD_KATANA) {
            type = KatanaItem.KatanaType.EMERALD;
        } else if (item == RedemptionItems.COPPER_KATANA) {
            type = KatanaItem.KatanaType.COPPER;
        } else if (item == RedemptionItems.NETHERITE_KATANA) {
            type = KatanaItem.KatanaType.NETHERITE;
        } else if (item == RedemptionItems.LAPIS_KATANA) {
            type = KatanaItem.KatanaType.LAPIS;
        }

        return type;
    }
    public static AttributeModifiersComponent createAttributeModifiers() {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 6.5f, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ATTACK_SPEED,
                        new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, -2.3f, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                        new EntityAttributeModifier(Identifier.ofVanilla("base_entity_interaction_range"), 1.5f, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .build();
    }

    @Override
    public int startColor(ItemStack itemStack) {
        return 0xFF6e5353;
    }

    @Override
    public int endColor(ItemStack itemStack) {
        return 0xFF271e1e;
    }

    @Override
    public int backgroundColor(ItemStack itemStack) {
        return 0xF01d1212;
    }

    @Override
    public DamageSource getKillSource(LivingEntity livingEntity) {
        return RedemptionDamageSources.katana(livingEntity);
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        JudgementPlayerComponent judge = JudgementPlayerComponent.KEY.get(user);

        if (judge.isJudgement) {
            if (user instanceof PlayerEntity player) {
                player.setVelocity(user.getRotationVec(0).multiply(3));
                player.useRiptide(10, 7f, user.getStackInHand(user.getActiveHand()));
                player.getItemCooldownManager().set(this, 400);
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public Identifier getModel(ModelTransformationMode renderMode, ItemStack stack, @Nullable LivingEntity entity) {

        return switch(getKatanaType(this)) {
            case AMETHYST -> MiscUtils.isGui(renderMode) ? Redemption.id("amethyst_katana") : Redemption.id("amethyst_katana_handheld");
            case REDSTONE -> MiscUtils.isGui(renderMode) ? Redemption.id("redstone_katana") : Redemption.id("redstone_katana_handheld");
            case SCULK -> MiscUtils.isGui(renderMode) ? Redemption.id("sculk_katana") : Redemption.id("sculk_katana_handheld");
            case QUARTZ -> MiscUtils.isGui(renderMode) ? Redemption.id("quartz_katana") : Redemption.id("quartz_katana_handheld");
            case EMERALD -> MiscUtils.isGui(renderMode) ? Redemption.id("emerald_katana") : Redemption.id("emerald_katana_handheld");
            case COPPER -> MiscUtils.isGui(renderMode) ? Redemption.id("copper_katana") : Redemption.id("copper_katana_handheld");
            case NETHERITE -> MiscUtils.isGui(renderMode) ? Redemption.id("netherite_katana") : Redemption.id("netherite_katana_handheld");
            case LAPIS  -> MiscUtils.isGui(renderMode) ? Redemption.id("lapis_katana") : Redemption.id("lapis_katana_handheld");
        };
    }

    @Override
    public List<Identifier> getModelsToLoad() {
        return Arrays.asList(
                Redemption.id("amethyst_katana"),
                Redemption.id("amethyst_katana_handheld"),
                Redemption.id("redstone_katana"),
                Redemption.id("redstone_katana_handheld"),
                Redemption.id("sculk_katana"),
                Redemption.id("sculk_katana_handheld"),
                Redemption.id("quartz_katana"),
                Redemption.id("quartz_katana_handheld"),
                Redemption.id("emerald_katana"),
                Redemption.id("emerald_katana_handheld"),
                Redemption.id("copper_katana"),
                Redemption.id("copper_katana_handheld"),
                Redemption.id("netherite_katana"),
                Redemption.id("netherite_katana_handheld"),
                Redemption.id("lapis_katana"),
                Redemption.id("lapis_katana_handheld"));
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
