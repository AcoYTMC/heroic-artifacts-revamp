package silly.chemthunder.redemption.impl.util;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import silly.chemthunder.redemption.impl.Redemption;
import silly.chemthunder.redemption.impl.networking.IkirImmolationKeybindPayload;
import silly.chemthunder.redemption.impl.networking.IkirSwitchGamemodesKeybindPayload;

public class RedemptionKeybindings {

    public static KeyBinding switchGamemodes;
    public static KeyBinding useImmolation;

    public static void register() {
        registerKeyBindings();
        setupPressDetection();
    }

    private static void registerKeyBindings() {
        String redemptionCategory = "category.redemption";
        switchGamemodes = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.redemption.switch_gamemodes",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_UP,
                redemptionCategory
        ));

        useImmolation = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.redemption.use_immolation",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_DOWN,
                redemptionCategory
        ));
    }

    private static void setupPressDetection() {
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            if (client.player != null && switchGamemodes.isPressed()) {
                handleSwitch(client);
            }
            if (client.player != null && useImmolation.isPressed()) {
                handleImmolation(client);
            }
        });
    }

    private static void handleSwitch(MinecraftClient client) {
        if (client.player != null) {
            try {
                IkirSwitchGamemodesKeybindPayload.send();
            } catch (Exception e) {
                Redemption.LOGGER.error("Failed to send Ikir Switch Payload");
            }
        }
    }

    private static void handleImmolation(MinecraftClient client) {
        if (client.player != null) {
            try {
                IkirImmolationKeybindPayload.send();

            } catch (Exception e) {
                Redemption.LOGGER.error("Failed to send Ikir Ability Payload");
            }
        }
    }
}
