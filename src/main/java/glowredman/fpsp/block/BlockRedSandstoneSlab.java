package glowredman.fpsp.block;

import java.util.Random;

import glowredman.fpsp.FPSP;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRedSandstoneSlab extends BlockSlab {

	public BlockRedSandstoneSlab(boolean isDouble) {
		super(isDouble, Material.rock);
		setBlockName("redSandstoneSlab");
		setHardness(2.0F);
		setResistance(10.0F);
		setStepSound(soundTypePiston);
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return FPSP.blockRedSandstone.getBlockTextureFromSide(side);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Item.getItemFromBlock(FPSP.blockRedSandstoneSlab);
	}

	@Override
	protected ItemStack createStackedBlock(int meta) {
		return new ItemStack(FPSP.blockRedSandstoneSlab, 2);
	}

	@Override
	public String func_150002_b(int p_150002_1_) {
		return getUnlocalizedName();
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
		if (this.field_150004_a) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			if ((blockAccess.getBlockMetadata(x, y, z) & 8) != 0) {
				this.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			} else {
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			}
		}
	}

	@Override
	public int damageDropped(int meta) {
		return 0;
	}

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
		return this.field_150004_a ? meta : (side != 0 && (side == 1 || hitY <= 0.5f) ? meta : meta | 8);
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
		if (this.field_150004_a) {
			return superShouldSideBeRendered(blockAccess, x, y, z, side);
		} else if (side != 1 && side != 0 && !superShouldSideBeRendered(blockAccess, x, y, z, side)) {
			return false;
		} else {
			int i1 = x + Facing.offsetsXForSide[Facing.oppositeSide[side]];
			int j1 = y + Facing.offsetsYForSide[Facing.oppositeSide[side]];
			int k1 = z + Facing.offsetsZForSide[Facing.oppositeSide[side]];
			boolean flag = (blockAccess.getBlockMetadata(i1, j1, k1) & 8) != 0;
			return flag
					? (side == 0 ? true
							: (side == 1 && superShouldSideBeRendered(blockAccess, x, y, z, side) ? true
									: blockAccess.getBlock(x, y, z) != FPSP.blockRedSandstoneSlab
											|| (blockAccess.getBlockMetadata(x, y, z) & 8) == 0))
					: (side == 1 ? true
							: (side == 0 && superShouldSideBeRendered(blockAccess, x, y, z, side) ? true
									: blockAccess.getBlock(x, y, z) != FPSP.blockRedSandstoneSlab
											|| (blockAccess.getBlockMetadata(x, y, z) & 8) != 0));
		}
	}

	@Override
	public int getDamageValue(World world, int x, int y, int z) {
		return 0;
	}

	@Override
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(FPSP.blockRedSandstoneSlab);
	}

	private boolean superShouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
		return side == 0 && this.minY > 0.0D ? true
				: (side == 1 && this.maxY < 1.0D ? true
						: (side == 2 && this.minZ > 0.0D ? true
								: (side == 3 && this.maxZ < 1.0D ? true
										: (side == 4 && this.minX > 0.0D ? true
												: (side == 5 && this.maxX < 1.0D ? true
														: !blockAccess.getBlock(x, y, z).isOpaqueCube())))));
	}

}
