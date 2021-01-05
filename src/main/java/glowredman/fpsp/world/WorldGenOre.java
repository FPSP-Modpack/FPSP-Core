package glowredman.fpsp.world;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGenOre extends WorldGenMinable {

	public WorldGenOre(String modID, String blockName, int clusterSize) {
		super(GameRegistry.findBlock(modID, blockName), clusterSize);
	}

	public WorldGenOre(String modID, String blockName, int clusterSize, Block replace) {
		super(GameRegistry.findBlock(modID, blockName), clusterSize, replace);
	}

	public WorldGenOre(String modID, String blockName, int meta, int clusterSize) {
		super(GameRegistry.findBlock(modID, blockName), meta, clusterSize, Blocks.stone);
	}

	public WorldGenOre(String modID, String blockName, int meta, int clusterSize, Block replace) {
		super(GameRegistry.findBlock(modID, blockName), meta, clusterSize, replace);
	}

}
