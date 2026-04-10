package silly.chemthunder.redemption.impl.cca.entity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import silly.chemthunder.redemption.impl.Redemption;

public class EnshroudedComponent implements AutoSyncedComponent {
    public static final ComponentKey<EnshroudedComponent> KEY = ComponentRegistry.getOrCreate(Redemption.id("shrouded"), EnshroudedComponent.class);

    private final PlayerEntity player;
    public boolean isShrouded = false;

    public EnshroudedComponent(PlayerEntity player) {
        this.player = player;
    }

    public void sync() {
        KEY.sync(this.player);
    }

    public void readFromNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        this.isShrouded = nbtCompound.getBoolean("IsShrouded");
    }

    public void writeToNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        nbtCompound.putBoolean("IsShrouded", isShrouded);
    }
}