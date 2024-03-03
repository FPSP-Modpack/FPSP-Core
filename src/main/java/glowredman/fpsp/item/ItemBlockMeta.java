package glowredman.fpsp.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

import glowredman.fpsp.FPSP;
import glowredman.fpsp.block.BlockMeta;

public class ItemBlockMeta extends ItemBlockWithMetadata {

    public ItemBlockMeta(Block block) {
        super(block, block);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getItemDamage() % BlockMeta.TYPES.length;
        return FPSP.blockMeta.getUnlocalizedName() + "." + BlockMeta.TYPES[meta];
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (int meta = 0; meta < BlockMeta.TYPES.length; meta++) {
            list.add(new ItemStack(item, 1, meta));
        }
    }

    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List<String> tooltip, boolean f3_h) {
        if (item.getItemDamage() == 4) {
            tooltip.add("Can be used as beacon base");
            tooltip.add("Enchantment Power: 16.0");
        }
    }

}
