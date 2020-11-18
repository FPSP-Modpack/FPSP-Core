package glowredman.fpsp;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab extends CreativeTabs {

	public CreativeTab() {
		super("fpsp");
	}

	@Override
	public Item getTabIconItem() {
		return FPSP.ITEM;
	}

}
