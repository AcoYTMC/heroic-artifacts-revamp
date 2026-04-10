package silly.chemthunder.redemption.impl.index;

import net.acoyt.acornlib.api.registrants.ComponentTypeRegistrant;
import net.minecraft.component.ComponentType;
import silly.chemthunder.redemption.impl.Redemption;
import silly.chemthunder.redemption.impl.component.AshiroKatanaComponent;

public interface RedemptionDataComponents {
    ComponentTypeRegistrant DATA_COMPONENTS = new ComponentTypeRegistrant(Redemption.MOD_ID);

    ComponentType<AshiroKatanaComponent> ASHIRO_KATANA = DATA_COMPONENTS.register("ashiro_katana", builder -> builder.codec(AshiroKatanaComponent.CODEC));

    static void index() {}
}
