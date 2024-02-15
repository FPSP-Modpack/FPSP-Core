package glowredman.fpsp.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

import glowredman.fpsp.block.BlockRedSandstone;

public class ItemBlockRedSandstone extends ItemBlockWithMetadata {

    public ItemBlockRedSandstone(Block block) {
        super(block, block);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getItemDamage();
        if (meta > 2) meta = 0;
        return this.getUnlocalizedName() + "_" + BlockRedSandstone.field_150157_a[meta];
    }
}
