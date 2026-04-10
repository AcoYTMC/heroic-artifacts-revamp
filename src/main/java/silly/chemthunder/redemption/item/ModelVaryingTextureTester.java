package silly.chemthunder.redemption.item;

import net.acoyt.acornlib.api.item.ModelVaryingItem;
import net.acoyt.acornlib.api.util.MiscUtils;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import silly.chemthunder.redemption.Redemption;

import java.util.Arrays;
import java.util.List;

public class ModelVaryingTextureTester extends Item implements ModelVaryingItem {
    public ModelVaryingTextureTester(Settings settings) {
        super(settings);
    }

    public Identifier getModel(ModelTransformationMode renderMode, ItemStack stack, @Nullable LivingEntity entity) {
        return MiscUtils.isGui(renderMode) ? Redemption.id("texture_tester") : Redemption.id("texture_tester_handheld");
    }

    public List<Identifier> getModelsToLoad() {
        return Arrays.asList(
                Redemption.id("texture_tester"),
                Redemption.id("texture_tester_handheld")
        );
    }
}