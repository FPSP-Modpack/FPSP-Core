package glowredman.fpsp;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class Utils {

	public static ItemStack getItem(String modID, String itemName) {
		return GameRegistry.findItemStack(modID, itemName, 1);
	}

	public static ItemStack getItem(String modID, String itemName, int meta) {
		ItemStack stack = GameRegistry.findItemStack(modID, itemName, 1);
		Items.apple.setDamage(stack, meta);
		return stack;
	}

	public static ItemStack getItems(String modID, String itemName, int amount) {
		return GameRegistry.findItemStack(modID, itemName, amount);
	}

	public static ItemStack getItems(String modID, String itemName, int meta, int amount) {
		ItemStack stack = GameRegistry.findItemStack(modID, itemName, amount);
		Items.apple.setDamage(stack, meta);
		return stack;
	}

	public static Block getBlock(ItemStack blockStack) {
		Item item = blockStack.getItem();
		if (item instanceof ItemBlock) {
			return ((ItemBlock) item).field_150939_a;
		} else {
			return null;
		}
	}

	private Utils() {}

}
