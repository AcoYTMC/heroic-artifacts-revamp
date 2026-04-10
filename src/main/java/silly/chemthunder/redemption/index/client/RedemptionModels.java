package silly.chemthunder.redemption.index.client;

import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import silly.chemthunder.redemption.Redemption;

import java.util.Optional;

public interface RedemptionModels {
    Model KATANA_HANDHELD = create("katana_handheld", TextureKey.LAYER0);
    Model SHEATH_HANDHELD = create("sheath_handheld", TextureKey.LAYER0);
    Model SHEATHED_HANDHELD = create("sheathed_handheld", TextureKey.LAYER0);

    static Model create(String parent,  TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Redemption.id("item/" + parent)), Optional.empty(), requiredTextureKeys);
    }
}
