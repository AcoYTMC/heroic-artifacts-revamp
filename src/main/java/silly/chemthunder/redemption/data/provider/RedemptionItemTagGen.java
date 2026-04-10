package silly.chemthunder.redemption.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import silly.chemthunder.redemption.impl.index.RedemptionItems;
import silly.chemthunder.redemption.impl.index.tag.RedemptionItemTags;
import silly.chemthunder.redemption.impl.item.katana.KatanaItem;
import silly.chemthunder.redemption.impl.item.katana.SheathItem;
import silly.chemthunder.redemption.impl.item.katana.SheathedKatanaItem;

import java.util.concurrent.CompletableFuture;

public class RedemptionItemTagGen extends FabricTagProvider.ItemTagProvider {
    public RedemptionItemTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        for (Item item : RedemptionItems.ITEMS.toRegister) {
            if (item instanceof KatanaItem) {
                this.getOrCreateTagBuilder(RedemptionItemTags.KATANAS)
                        .add(item)
                        .setReplace(false);
            }

            if (item instanceof SheathItem) {
                this.getOrCreateTagBuilder(RedemptionItemTags.SHEATHS)
                        .add(item)
                        .setReplace(false);
            }

            if (item instanceof SheathedKatanaItem) {
                this.getOrCreateTagBuilder(RedemptionItemTags.SHEATHED_KATANAS)
                        .add(item)
                        .setReplace(false);
            }
        }
    }
}
