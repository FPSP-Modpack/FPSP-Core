package glowredman.fpsp.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import glowredman.fpsp.FPSP;

public class BlockMeta extends Block {

    public static final String[] TYPES = new String[] { "UnknownCrystal", "Flonium", "Ender", "Charcoal",
        "DarkSoularium", "BacterialFossil", "Mineral", "Xeonium", "Saltpeter", "Metallic", "Manganese", "IceCrystal" };
    private IIcon[] textures;

    public BlockMeta() {
        super(Material.rock);
        setBlockName("block");
        setHardness(5);
        setHarvestLevel("pickaxe", 2);
        setResistance(10);
        setStepSound(soundTypeMetal);
    }

    @Override
    public int damageDropped(int meta) {
        return meta % TYPES.length;
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        textures = new IIcon[TYPES.length];
        for (int i = 0; i < TYPES.length; i++) {
            textures[i] = register.registerIcon(FPSP.MODID + ":" + TYPES[i]);
        }
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return textures[meta % TYPES.length];
    }

    @Override
    public float getEnchantPowerBonus(World world, int x, int y, int z) {
        if (world.getBlockMetadata(x, y, z) == 4) {
            return 16.0f;
        }
        return super.getEnchantPowerBonus(world, x, y, z);
    }

    @Override
    public boolean isBeaconBase(IBlockAccess world, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
        if (world.getBlockMetadata(x, y, z) == 4) {
            return true;
        }
        return super.isBeaconBase(world, x, y, z, beaconX, beaconY, beaconZ);
    }

    @Override
    public MapColor getMapColor(int meta) {
        switch (meta) {
            case 0:
            case 11:
                return MapColor.foliageColor;
            case 1:
                return MapColor.woodColor;
            case 2:
            case 7:
            case 8:
                return MapColor.brownColor;
            case 3:
                return MapColor.grassColor;
            case 4:
            case 12:
            case 13:
                return MapColor.snowColor;
            case 5:
                return MapColor.redColor;
            case 6:
                return MapColor.diamondColor;
            case 9:
                return MapColor.blueColor;
            case 10:
            case 14:
                return MapColor.lightBlueColor;
            default:
                return super.getMapColor(meta);
        }
    }

}
