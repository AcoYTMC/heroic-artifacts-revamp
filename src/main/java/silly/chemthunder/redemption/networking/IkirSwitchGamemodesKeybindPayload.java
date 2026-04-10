package silly.chemthunder.redemption.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import silly.chemthunder.redemption.Redemption;
import silly.chemthunder.redemption.util.IkirPowerManager;

public record IkirSwitchGamemodesKeybindPayload() implements CustomPayload {
    public static final CustomPayload.Id<IkirSwitchGamemodesKeybindPayload> ID = new CustomPayload.Id<>(Redemption.id("ikir_switch_gamemode"));
    public static final PacketCodec<RegistryByteBuf, IkirSwitchGamemodesKeybindPayload> CODEC = PacketCodec.unit(new IkirSwitchGamemodesKeybindPayload());

    public Id<? extends CustomPayload> getId() {
        return ID;
    }

    public static void send() {
        ClientPlayNetworking.send(new IkirSwitchGamemodesKeybindPayload());
    }

    public static class Receiver implements ServerPlayNetworking.PlayPayloadHandler<IkirSwitchGamemodesKeybindPayload> {
        public void receive(IkirSwitchGamemodesKeybindPayload payload, ServerPlayNetworking.Context context) {
            PlayerEntity player = context.player();
            if (player != null) {
                if (IkirPowerManager.isHero(player)) {
                    IkirPowerManager.switchGamemode(player);
                }
            }
        }
    }
}
