package glowredman.fpsp.item;

import glowredman.fpsp.FPSP;
import glowredman.fpsp.block.BlockMeta;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockMeta extends ItemBlockWithMetadata {

	public ItemBlockMeta(Block block) {
		super(block, block);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int meta = stack.getItemDamage() % BlockMeta.types.length;
		return FPSP.blockMeta.getUnlocalizedName() + "." + BlockMeta.types[meta];
	}

}
