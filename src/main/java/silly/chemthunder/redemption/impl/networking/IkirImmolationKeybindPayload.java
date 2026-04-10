package silly.chemthunder.redemption.impl.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import silly.chemthunder.redemption.impl.Redemption;
import silly.chemthunder.redemption.impl.util.IkirPowerManager;

public record IkirImmolationKeybindPayload() implements CustomPayload {
    public static final CustomPayload.Id<IkirImmolationKeybindPayload> ID = new CustomPayload.Id<>(Redemption.id("ikir_immolation"));
    public static final PacketCodec<RegistryByteBuf, IkirImmolationKeybindPayload> CODEC = PacketCodec.unit(new IkirImmolationKeybindPayload());

    public CustomPayload.Id<? extends CustomPayload> getId() {
        return ID;
    }

    public static void send() {
        ClientPlayNetworking.send(new IkirSwitchGamemodesKeybindPayload());
    }

    public static class Receiver implements ServerPlayNetworking.PlayPayloadHandler<IkirImmolationKeybindPayload> {
        public void receive(IkirImmolationKeybindPayload payload, ServerPlayNetworking.Context context) {
            PlayerEntity player = context.player();
            if (player != null) {
                if (IkirPowerManager.isHero(player)) {
                    IkirPowerManager.useImmolation(player);
                }
            }
        }
    }
}
