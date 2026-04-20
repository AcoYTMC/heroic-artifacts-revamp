package silly.chemthunder.redemption.impl;

import net.acoyt.acornlib.api.event.CustomRiptideEvent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import silly.chemthunder.redemption.impl.event.JudgementRiptideEvent;
import silly.chemthunder.redemption.impl.index.RedemptionEntities;
import silly.chemthunder.redemption.impl.index.RedemptionNetworking;
import silly.chemthunder.redemption.impl.index.RedemptionParticles;
import silly.chemthunder.redemption.impl.util.ModUtils;
import silly.chemthunder.redemption.impl.util.RedemptionKeybindings;

@Environment(EnvType.CLIENT)
public class RedemptionClient implements ClientModInitializer {
    public void onInitializeClient() {
        /* Initialization */
        RedemptionParticles.clientInit();
        RedemptionEntities.clientInit();

        RedemptionKeybindings.register();

        /* Networking */
        RedemptionNetworking.registerS2CPackets();

        /* Events */
        CustomRiptideEvent.EVENT.register(new JudgementRiptideEvent());
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;
            client.player.sendMessage(Text.translatable(Util.createTranslationKey("item", ModUtils.formatKatanaId(client.player.getOffHandStack(), false))), true);
        });
    }
}
