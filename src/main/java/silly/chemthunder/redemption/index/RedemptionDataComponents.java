package silly.chemthunder.redemption.index;

import net.acoyt.acornlib.api.registrants.ComponentTypeRegistrant;
import net.minecraft.component.ComponentType;
import silly.chemthunder.redemption.Redemption;
import silly.chemthunder.redemption.component.AshiroKatanaComponent;

public interface RedemptionDataComponents {
    ComponentTypeRegistrant DATA_COMPONENTS = new ComponentTypeRegistrant(Redemption.MOD_ID);

    ComponentType<AshiroKatanaComponent> ASHIRO_KATANA = DATA_COMPONENTS.register("ashiro_katana", builder -> builder.codec(AshiroKatanaComponent.CODEC));

    static void index() {}
}
