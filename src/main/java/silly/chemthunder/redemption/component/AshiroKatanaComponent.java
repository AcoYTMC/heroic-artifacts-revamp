package silly.chemthunder.redemption.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public record AshiroKatanaComponent(RegistryKey<World> dimension, Vec3d pos) {
    public static final Codec<AshiroKatanaComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            World.CODEC.fieldOf("dimension").forGetter(AshiroKatanaComponent::dimension),
            Vec3d.CODEC.fieldOf("pos").forGetter(AshiroKatanaComponent::pos)
    ).apply(instance, AshiroKatanaComponent::new));
}
