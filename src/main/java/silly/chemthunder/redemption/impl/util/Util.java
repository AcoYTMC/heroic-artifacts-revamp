package silly.chemthunder.redemption.impl.util;

import net.minecraft.component.ComponentType;
import net.minecraft.item.ItemStack;

/**
 * @author AcoYT
 */
public class Util {
    public static <T> ItemStack copy(ItemStack stack, ComponentType<T> type, T value) {
        ItemStack itemStack = stack.copy();
        itemStack.set(type, value);
        return itemStack;
    }
}
