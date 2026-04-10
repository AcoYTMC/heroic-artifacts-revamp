package silly.chemthunder.redemption.index.tag;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import silly.chemthunder.redemption.Redemption;

public interface RedemptionItemTags {
    TagKey<Item> KATANAS = of("katanas");
    TagKey<Item> SHEATHS = of("sheaths");
    TagKey<Item> SHEATHED_KATANAS = of("sheathed_katanas");

    static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Redemption.id(id));
    }
}