package glowredman.fpsp.world;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class FPSPWorldGenerator implements IWorldGenerator {

	private World world;
	private BiomeGenBase biome;
	private Random random;
	private int chunkX;
	private int chunkZ;

	private WorldGenerator copperOreGen;
	private WorldGenerator tinOreGen;
	private WorldGenerator leadOreGen;
	private WorldGenerator certusQuartzOreGen;
	private WorldGenerator minicioOreGen;
	private WorldGenerator silverOreGen;
	private WorldGenerator nickelOreGen;
	private WorldGenerator amberOreGen;
	private WorldGenerator chargedCertusQuartzOreGen;
	private WorldGenerator topazOreGen;
	private WorldGenerator tanzaniteOreGen;
	private WorldGenerator malachiteOreGen;

	public FPSPWorldGenerator() {
		final String AE2 = "appliedenergistics2";
		final String BOP = "BiomesOPlenty";
		final String IC2 = "IC2";
		final String MagC = "magicalcrops";
		final String PR_E = "ProjRed|Exploration";
		final String TF = "ThermalFoundation";

		copperOreGen = new WorldGenOre(IC2, "blockOreCopper", 10);
		tinOreGen = new WorldGenOre(IC2, "blockOreTin", 6);
		leadOreGen = new WorldGenOre(IC2, "blockOreLead", 4);
		certusQuartzOreGen = new WorldGenOre(AE2, "tile.OreQuartz", 4);
		minicioOreGen = new WorldGenOre(MagC, "MinicioOre", 4);
		silverOreGen = new WorldGenOre(PR_E, "projectred.exploration.ore", 5, 4);
		nickelOreGen = new WorldGenOre(TF, "Ore", 4, 3);
		amberOreGen = new WorldGenOre(BOP, "gemOre", 14, 0);
		chargedCertusQuartzOreGen = new WorldGenOre(AE2, "tile.OreQuartz", 1, 4);
		topazOreGen = new WorldGenOre(BOP, "gemOre", 6, 0);
		tanzaniteOreGen = new WorldGenOre(BOP, "gemOre", 8, 0);
		malachiteOreGen = new WorldGenOre(BOP, "gemOre", 10, 0);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {

		if (this.world != null)
			throw new RuntimeException("Already decorating!!");

		this.world = world;
		this.biome = world.getBiomeGenForCoords(chunkX * 16, chunkZ * 16);
		this.random = random;
		this.chunkX = chunkX;
		this.chunkZ = chunkZ;

		switch (world.provider.dimensionId) {
		case 0: // Overworld
			generateOre(17, copperOreGen, 10, 69);
			generateOre(28, tinOreGen, 0, 40);
			generateOre(9, leadOreGen, 0, 64);
			generateOre(25, certusQuartzOreGen, 12, 73);
			break;
		case 7: // Twilight Forest
			generateOre(17, copperOreGen, 10, 69);
			generateOre(28, tinOreGen, 0, 40);
			generateOre(9, leadOreGen, 0, 64);
			generateOre(25, certusQuartzOreGen, 2, 33);
			generateOre(25, minicioOreGen, 0, 45);
			generateOre(4, silverOreGen, 0, 32);
			generateOre(3, nickelOreGen, 5, 21);
			generateOre(2, chargedCertusQuartzOreGen, 2, 33);
			generateBiomeOre(15, amberOreGen, 4, 32, "twilightforest.biomes.TFBiomeDarkForest",
					"twilightforest.biomes.TFBiomeDeepMushrooms", "twilightforest.biomes.TFBiomeFireflyForest",
					"twilightforest.biomes.TFBiomeMushrooms", "twilightforest.biomes.TFBiomeOakSavanna",
					"twilightforest.biomes.TFBiomeTwilightForest",
					"twilightforest.biomes.TFBiomeTwilightForestVariant");
			generateBiomeOre(15, topazOreGen, 4, 32, "twilightforest.biomes.TFBiomeClearing",
					"twilightforest.biomes.TFBiomeTwilightLake", "twilightforest.biomes.TFBiomeStream",
					"twilightforest.biomes.TFBiomeSwamp");
			generateBiomeOre(15, tanzaniteOreGen, 4, 32, "twilightforest.biomes.TFBiomeDarkForestCenter",
					"twilightforest.biomes.TFBiomeEnchantedForest", "twilightforest.biomes.TFBiomeHighlands",
					"twilightforest.biomes.TFBiomeSnow");
			generateBiomeOre(15, malachiteOreGen, 4, 32, "twilightforest.biomes.TFBiomeFireSwamp",
					"twilightforest.biomes.TFBiomeGlacier", "twilightforest.biomes.TFBiomeFinalPlateau",
					"twilightforest.biomes.TFBiomeThornlands");

			break;
		default:
			break;
		}

		this.world = null;
		this.biome = null;
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

	private void generateBiomeOre(int attempts, WorldGenerator worldGenerator, int minY, int maxY, String... biomes) {
		if (compare(biomes))
			generateOre(attempts, worldGenerator, minY, maxY);
	}

	private boolean compare(String... biomeClasses) {
		for (String biomeClass : biomeClasses) {
			if (compare(biomeClass))
				return true;
		}
		return false;
	}

	private boolean compare(String biomeClass) {
		return this.biome.getBiomeClass().getSimpleName().equals(biomeClass);
	}

}
