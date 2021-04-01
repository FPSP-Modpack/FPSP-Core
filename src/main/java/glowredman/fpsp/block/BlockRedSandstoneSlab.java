package glowredman.fpsp.block;

import java.util.Random;

import glowredman.fpsp.FPSP;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockRedSandstoneSlab extends BlockSlab {

	private IIcon textureSide;

	public BlockRedSandstoneSlab(boolean isDouble) {
		super(isDouble, Material.rock);
		setBlockName("redSandstoneSlab");
		setHardness(2.0F);
		setResistance(10.0F);
		setStepSound(soundTypePiston);
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return FPSP.RED_SANDSTONE.getBlockTextureFromSide(side);
	}

	@Override
	public void registerBlockIcons(IIconRegister register) {
		blockIcon = register.registerIcon(FPSP.MODID + ":red_sandstone_slab_top");
		textureSide = register.registerIcon(FPSP.MODID + ":red_sandstone_slab_side");
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Item.getItemFromBlock(FPSP.RED_SANDSTONE_SLAB);
	}

	@Override
	protected ItemStack createStackedBlock(int meta) {
		return new ItemStack(FPSP.RED_SANDSTONE_SLAB, 2);
	}

	@Override
	public String func_150002_b(int p_150002_1_) {
		return getUnlocalizedName();
	}

}
