package silly.chemthunder.redemption.cca.entity;

import net.acoyt.acornlib.api.util.MiscUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.component.tick.CommonTickingComponent;
import silly.chemthunder.redemption.Redemption;

public class ImmolationHolderComponent implements AutoSyncedComponent, CommonTickingComponent {
    public static final ComponentKey<ImmolationHolderComponent> KEY = MiscUtils.getOrCreateKey(Redemption.id("immolation_holder"), ImmolationHolderComponent.class);

    private final PlayerEntity player;
    private int delayTicks = 0;

    public ImmolationHolderComponent(PlayerEntity player) {
        this.player = player;
    }

    public void sync() {
        KEY.sync(player);
    }

    public void tick() {
        if (this.getDelayTicks() > 0) {
            this.delayTicks--;
            if (this.getDelayTicks() == 0) {
                sync();
            }
        }
    }

    public void readFromNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        this.delayTicks = nbtCompound.getInt("DelayTicks");
    }

    public void writeToNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        nbtCompound.putInt("DelayTicks", delayTicks);
    }

    public int getDelayTicks() {
        return this.delayTicks;
    }

    public void setDelayTicks(int i) {
        this.delayTicks = i;
        sync();
    }
}
