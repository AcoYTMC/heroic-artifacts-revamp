package silly.chemthunder.redemption.impl.cca.entity;

import net.acoyt.acornlib.api.util.MiscUtils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.component.tick.CommonTickingComponent;
import silly.chemthunder.redemption.impl.Redemption;
import silly.chemthunder.redemption.impl.index.data.RedemptionDamageSources;

public class ImmolationComponent implements AutoSyncedComponent, CommonTickingComponent {
    public static final ComponentKey<ImmolationComponent> KEY = MiscUtils.getOrCreateKey(Redemption.id("immolation"), ImmolationComponent.class);

    private final LivingEntity living;
    private boolean burning = false;

    public void sync() {
        KEY.sync(living);
    }

    public ImmolationComponent(LivingEntity living) {
        this.living = living;
    }

    public void tick() {
        if (this.isBurning()) {
            living.damage(RedemptionDamageSources.immolation(living), 1.0f);

            if (living.getWorld() instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(ParticleTypes.FLAME,
                        living.getX() + 0.5f,
                        living.getY() + 0.5f,
                        living.getZ() + 0.5f,
                        6,
                        1,
                        2,
                        1,
                        0.1f
                );
            }
        }
    }

    public void readFromNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        this.burning = nbtCompound.getBoolean("Burning");
    }

    public void writeToNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        nbtCompound.putBoolean("Burning", burning);
    }

    public boolean isBurning() {
        return this.burning;
    }

    public void setBurning(boolean bl) {
        this.burning = bl;
        sync();
    }
}
