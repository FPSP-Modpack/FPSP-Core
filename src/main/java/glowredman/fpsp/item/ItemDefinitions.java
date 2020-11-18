package glowredman.fpsp.item;

import glowredman.fpsp.FPSP;
import net.minecraft.item.ItemStack;

public enum ItemDefinitions {
	icon(0),
	mediumFuelCanister(1),
	largeFuelCanister(2),
	extraLargeFuelCanister(3),
	noseConeT4(4),
	rocketEngineT4(5),
	finsT4(6),
	boosterT3(7),
	boosterT4(8)
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
