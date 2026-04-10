package silly.chemthunder.redemption;

import net.acoyt.acornlib.api.ALib;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import silly.chemthunder.redemption.index.*;
import silly.chemthunder.redemption.networking.IkirImmolationKeybindPayload;
import silly.chemthunder.redemption.networking.IkirSwitchGamemodesKeybindPayload;
import silly.chemthunder.redemption.util.RedemptionKeybindings;

public class Redemption implements ModInitializer {
	public static final String MOD_ID = "redemption";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
        RedemptionItems.index();
        RedemptionItemGroups.index();
        RedemptionSoundEvents.index();
        RedemptionParticles.index();
        RedemptionDataComponents.index();
        RedemptionEntities.index();

		LOGGER.info("Redemption is running!");

        /* Networking */
        PayloadTypeRegistry.playC2S().register(IkirSwitchGamemodesKeybindPayload.ID, IkirSwitchGamemodesKeybindPayload.CODEC);
        ServerPlayNetworking.registerGlobalReceiver(IkirSwitchGamemodesKeybindPayload.ID, new IkirSwitchGamemodesKeybindPayload.Receiver());

        PayloadTypeRegistry.playC2S().register(IkirImmolationKeybindPayload.ID, IkirImmolationKeybindPayload.CODEC);
        ServerPlayNetworking.registerGlobalReceiver(IkirImmolationKeybindPayload.ID, new IkirImmolationKeybindPayload.Receiver());

        RedemptionKeybindings.register();
        ALib.registerModMenu(MOD_ID, 0xe95050);
	}

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}