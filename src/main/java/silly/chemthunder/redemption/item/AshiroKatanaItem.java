package silly.chemthunder.redemption.item;

import com.nitron.nitrogen.util.interfaces.ColorableItem;
import net.acoyt.acornlib.api.item.CustomHitParticleItem;
import net.acoyt.acornlib.api.item.CustomKillSourceItem;
import net.acoyt.acornlib.api.item.ModelVaryingItem;
import net.acoyt.acornlib.api.util.MiscUtils;
import net.acoyt.acornlib.api.util.ParticleUtils;
import net.acoyt.acornlib.impl.client.particle.SweepParticleEffect;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import silly.chemthunder.redemption.Redemption;
import silly.chemthunder.redemption.component.AshiroKatanaComponent;
import silly.chemthunder.redemption.index.RedemptionDataComponents;
import silly.chemthunder.redemption.index.data.RedemptionDamageSources;

import java.util.Arrays;
import java.util.List;

public class AshiroKatanaItem extends Item implements ColorableItem, CustomKillSourceItem, ModelVaryingItem, CustomHitParticleItem {
    public int startColor(ItemStack itemStack) {return 0xFF450909;}
    public int endColor(ItemStack itemStack) {return 0xFF942929;}
    public int backgroundColor(ItemStack itemStack) {return 0xFF171414;}

    public static final SweepParticleEffect[] EFFECTS = new SweepParticleEffect[]{
            new SweepParticleEffect(0x402626, 0x240f0f),
            new SweepParticleEffect(0x292424, 0x171414)
    };

    public AshiroKatanaItem(Settings settings) {
        super(settings
                .component(RedemptionDataComponents.ASHIRO_KATANA, new AshiroKatanaComponent(World.OVERWORLD, Vec3d.ZERO))
        );
    }

    public DamageSource getKillSource(LivingEntity living) {
        return RedemptionDamageSources.katana(living);
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        var component = stack.get(RedemptionDataComponents.ASHIRO_KATANA);

        if (component != null) {
            tooltip.add(Text.literal( Math.round(component.pos().x) + "").withColor(endColor(stack))
                            .append(Text.literal(", ").formatted(Formatting.DARK_GRAY))
                            .append(Text.literal( Math.round(component.pos().y) + "").withColor(endColor(stack))
                            .append(Text.literal(", ")).formatted(Formatting.DARK_GRAY))
                            .append(Text.literal( Math.round(component.pos().z) + "").withColor(endColor(stack))));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        var component = stack.get(RedemptionDataComponents.ASHIRO_KATANA);

        if (component != null) {
            if (user.isSneaking()) {
                stack.set(RedemptionDataComponents.ASHIRO_KATANA, new AshiroKatanaComponent(user.getWorld().getRegistryKey(), user.getPos()));
                if (world.isClient) user.swingHand(hand);
            } else {
                if (user.getServer() != null) {
                    user.teleportTo(new TeleportTarget(user.getServer().getWorld(component.dimension()), component.pos(), user.getVelocity(), user.getYaw(), user.getPitch(), TeleportTarget.NO_OP));
                }
            }
        }

        return super.use(world, user, hand);
    }

    public Identifier getModel(ModelTransformationMode renderMode, ItemStack stack, @Nullable LivingEntity entity) {
        return MiscUtils.isGui(renderMode) ? Redemption.id("netherite_katana") : Redemption.id("netherite_katana_handheld");
    }

    public List<Identifier> getModelsToLoad() {
        return Arrays.asList(
                Redemption.id("netherite_katana"),
                Redemption.id("netherite_katana_handheld")
        );
    }

    public void spawnHitParticles(PlayerEntity player, Entity target) {
        ParticleUtils.spawnSweepParticles(EFFECTS[player.getRandom().nextInt(EFFECTS.length)], player);
    }
}
