package glowredman.fpsp.block;

import java.util.List;

import net.minecraft.block.BlockSandStone;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import glowredman.fpsp.FPSP;

public class BlockRedSandstone extends BlockSandStone {

    private IIcon[] texturesSides;
    private IIcon textureTop;
    private IIcon textureBottom;

    public BlockRedSandstone() {
        super();
        setBlockName("redSandstone");
        setBlockTextureName(FPSP.MODID + ":red_sandstone");
        setHardness(0.8F);
        setHarvestLevel("pickaxe", 0);
        setStepSound(soundTypePiston);
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (side != 1 && (side != 0 || meta != 1 && meta != 2)) {
            if (side == 0) {
                return textureBottom;
            } else {
                if (meta < 0 || meta >= texturesSides.length) {
                    meta = 0;
                }
                return texturesSides[meta];
            }
        } else {
            return textureTop;
        }
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> variants) {
        variants.add(new ItemStack(item, 1, 0));
        variants.add(new ItemStack(item, 1, 1));
        variants.add(new ItemStack(item, 1, 2));
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        texturesSides = new IIcon[field_150156_b.length];
        for (int i = 0; i < texturesSides.length; i++) {
            texturesSides[i] = register.registerIcon(getTextureName() + "_" + field_150156_b[i]);
        }
        textureTop = register.registerIcon(getTextureName() + "_top");
        textureBottom = register.registerIcon(getTextureName() + "_bottom");
    }

}
