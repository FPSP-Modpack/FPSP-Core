package glowredman.fpsp.block;

import glowredman.fpsp.FPSP;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockMeta extends Block {

	public static String[] types = new String[] { "UnknownCrystal", "Ironwood", "Fiery", "Steeleaf", "Netherstar", "Flonium",
			"Ender", "Charcoal", "DarkSoularium", "BacterialFossil", "Mineral", "Xeonium" };
	private IIcon[] textures;

	public BlockMeta() {
		super(Material.iron);
		setBlockName("block");
		setHardness(5);
		setHarvestLevel("pickaxe", 2);
		setResistance(10);
		setStepSound(soundTypeMetal);
	}

	@Override
	public int damageDropped(int meta) {
		return meta % types.length;
	}

	@Override
	public void registerBlockIcons(IIconRegister register) {
		textures = new IIcon[types.length];
		for (int i = 0; i < types.length; i++) {
			textures[i] = register.registerIcon(FPSP.MODID + ":" + types[i]);
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return textures[meta % types.length];
	}

}
