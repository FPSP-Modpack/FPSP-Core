package glowredman.fpsp.item;

import glowredman.fpsp.FPSP;
import net.minecraft.item.ItemStack;

public enum ItemDefinitions {
	MassZivicioDust(0)
	;
	
	private int meta;
	
	private ItemDefinitions(int meta) {
		this.meta = meta;
	}
	
	public String getName() {
		return this.toString();
	}
	
	public int getMeta() {
		return this.meta;
	}
	
	public ItemStack getItem() {
		return this.getItem(1);
	}
	
	public ItemStack getItem(int amount) {
		return new ItemStack(FPSP.ITEM, amount, this.getMeta());
	}

}
