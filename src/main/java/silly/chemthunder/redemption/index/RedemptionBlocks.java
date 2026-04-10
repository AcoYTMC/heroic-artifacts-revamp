package silly.chemthunder.redemption.index;

import net.acoyt.acornlib.impl.item.TranslationBlockItem;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import silly.chemthunder.redemption.Redemption;

import java.util.function.Function;

public interface RedemptionBlocks {
    // BlockRegistrant BLOCKS = new BlockRegistrant(Redemption.MOD_ID);

    static Block create(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = factory.apply(settings);
        return Registry.register(Registries.BLOCK, Redemption.id(name), block);
    }

    static Block createWithItem(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = create(name, factory, settings);
        RedemptionItems.create(name, itemSettings -> new TranslationBlockItem(block, itemSettings), new Item.Settings().maxCount(1));
        return block;
    }

    static void index() {}

    static void clientIndex() {}
}