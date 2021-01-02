package glowredman.fpsp;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import ic2.core.Ic2Items;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class FPSPWorldGenerator implements IWorldGenerator {

	private World world;
	private Random random;
	private int chunkX;
	private int chunkZ;

	private WorldGenerator copperOreGen;
	private WorldGenerator tinOreGen;
	private WorldGenerator leadOreGen;

	public FPSPWorldGenerator() {
		copperOreGen = new WorldGenMinable(Utils.getBlock(Ic2Items.copperOre), 10);
		tinOreGen = new WorldGenMinable(Utils.getBlock(Ic2Items.tinOre), 6);
		leadOreGen = new WorldGenMinable(Utils.getBlock(Ic2Items.leadOre), 4);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (this.world != null) {
			throw new RuntimeException("Already decorating!!");
		}

		this.world = world;
		this.random = random;
		this.chunkX = chunkX;
		this.chunkZ = chunkZ;

		if (world.provider.getDimensionName().equals("Overworld")) {
			generateOre(17, copperOreGen, 10, 69);
			generateOre(28, tinOreGen, 0, 40);
			generateOre(9, leadOreGen, 0, 64);
		}

		this.world = null;
		this.random = null;
	}

	private void generateOre(int attempts, WorldGenerator worldGenerator, int minY, int maxY) {
		for (int i = 0; i < attempts; i++) {
			int x = this.chunkX * 16 + this.random.nextInt(16);
			int y = this.random.nextInt(maxY - minY) + minY;
			int z = this.chunkZ * 16 + this.random.nextInt(16);
			worldGenerator.generate(this.world, this.random, x, y, z);
		}
	}

}
