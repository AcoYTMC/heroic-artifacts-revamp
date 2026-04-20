package silly.chemthunder.redemption.impl.util;

import net.acoyt.acornlib.api.item.AcornItemSettings;
import silly.chemthunder.redemption.impl.component.KatanaComponent;
import silly.chemthunder.redemption.impl.index.RedemptionDataComponents;

public class KatanaSettings extends AcornItemSettings {
    public KatanaSettings katana(KatanaComponent.BladeType bladeType, KatanaType katanaType) {
        this.component(RedemptionDataComponents.KATANA, new KatanaComponent(bladeType.isSheathed(), bladeType.isSheath(), katanaType));
        return this;
    }
}
