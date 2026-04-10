package silly.chemthunder.redemption.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class ImmolationFlamesEntity extends ThrownEntity {
    private final int maxAge = 300;

    public ImmolationFlamesEntity(EntityType<? extends ThrownEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initDataTracker(DataTracker.Builder builder) {}

    public void tick() {

        if (getWorld() instanceof ServerWorld serverWorld) {
            for (int i = 0; i < 3; i++) {
                serverWorld.spawnParticles(ParticleTypes.FLAME,
                        this.getX(),
                        this.getY(),
                        this.getZ(),
                        5,
                        0.3,
                        0.3,
                        0.3,
                        0
                );
            }
        }

        super.tick();
    }

    public boolean hasNoGravity() {
        return true;
    }
}
