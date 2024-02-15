package glowredman.fpsp.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

import glowredman.fpsp.block.BlockRedSandstoneSlab;

public class ItemBlockRedSandstoneSlab extends ItemSlab {

    public ItemBlockRedSandstoneSlab(Block block, BlockRedSandstoneSlab slabSingle, BlockRedSandstoneSlab slabDouble) {
        super(block, slabSingle, slabDouble, block == slabDouble);
    }

}
