package silly.chemthunder.redemption.index;

import net.acoyt.acornlib.api.registrants.EntityTypeRegistrant;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EmptyEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import silly.chemthunder.redemption.Redemption;
import silly.chemthunder.redemption.entity.ImmolationFlamesEntity;

public interface RedemptionEntities {
    EntityTypeRegistrant ENTITIES = new EntityTypeRegistrant(Redemption.MOD_ID);

    EntityType<ImmolationFlamesEntity> IMMOLATION_FLAMES = ENTITIES.register("immolation_flames", EntityType.Builder.create(
            ImmolationFlamesEntity::new,
            SpawnGroup.MISC
    ).dimensions(0.7f, 0.7f).build());

    static void index() {
        //
    }

    static void clientIndex() {
        EntityRendererRegistry.register(IMMOLATION_FLAMES, EmptyEntityRenderer::new);
    }
}
