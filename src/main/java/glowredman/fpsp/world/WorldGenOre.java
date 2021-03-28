package glowredman.fpsp.world;

import cpw.mods.fml.common.registry.GameRegistry;
import glowredman.fpsp.FPSP;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGenOre extends WorldGenMinable {

	public WorldGenOre(String modID, String blockName, int clusterSize) {
		super(getBlock(modID, blockName), clusterSize);
	}

	public WorldGenOre(String modID, String blockName, int blockMeta, int clusterSize) {
		super(getBlock(modID, blockName), blockMeta, clusterSize, Blocks.stone);
	}

	public WorldGenOre(String modID, String blockName, int clusterSize, Block replace) {
		super(getBlock(modID, blockName), clusterSize, replace);
	}

	public WorldGenOre(String modID, String blockName, int blockMeta, int clusterSize, Block replace) {
		super(getBlock(modID, blockName), blockMeta, clusterSize, replace);
	}

	private static Block getBlock(String modID, String blockName) {
		Block block = GameRegistry.findBlock(modID, blockName);
		if (block == null) {
			FPSP.logger.error("Could not find block " + modID + ":" + blockName + "! Substituting stone.");
			block = Blocks.stone;
		}
		return block;
	}

}
