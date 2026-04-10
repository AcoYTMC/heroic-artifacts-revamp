package silly.chemthunder.redemption.impl;

import net.acoyt.acornlib.api.event.CustomRiptideEvent;
import net.fabricmc.api.ClientModInitializer;
import silly.chemthunder.redemption.impl.event.JudgementRiptideEvent;
import silly.chemthunder.redemption.impl.index.RedemptionEntities;
import silly.chemthunder.redemption.impl.index.RedemptionParticles;

public class RedemptionClient implements ClientModInitializer {
    public void onInitializeClient() {
        RedemptionParticles.clientIndex();
        RedemptionEntities.clientIndex();

        CustomRiptideEvent.EVENT.register(new JudgementRiptideEvent());
    }
}