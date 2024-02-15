package glowredman.fpsp.world;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import cpw.mods.fml.common.IWorldGenerator;

public class OreGenerator implements IWorldGenerator {

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
    private WorldGenerator electrotineOreGen;

    private static List<String> biomesAmberOre = Arrays.asList(
        "twilightforest.biomes.TFBiomeDarkForest",
        "twilightforest.biomes.TFBiomeDeepMushrooms",
        "twilightforest.biomes.TFBiomeFireflyForest",
        "twilightforest.biomes.TFBiomeMushrooms",
        "twilightforest.biomes.TFBiomeOakSavanna",
        "twilightforest.biomes.TFBiomeTwilightForest",
        "twilightforest.biomes.TFBiomeTwilightForestVariant");
    private static List<String> biomesTopazOre = Arrays.asList(
        "twilightforest.biomes.TFBiomeClearing",
        "twilightforest.biomes.TFBiomeTwilightLake",
        "twilightforest.biomes.TFBiomeStream",
        "twilightforest.biomes.TFBiomeSwamp");
    private static List<String> biomesTanzaniteOre = Arrays.asList(
        "twilightforest.biomes.TFBiomeDarkForestCenter",
        "twilightforest.biomes.TFBiomeEnchantedForest",
        "twilightforest.biomes.TFBiomeHighlands",
        "twilightforest.biomes.TFBiomeSnow");
    private static List<String> biomesMalachiteOre = Arrays.asList(
        "twilightforest.biomes.TFBiomeFireSwamp",
        "twilightforest.biomes.TFBiomeGlacier",
        "twilightforest.biomes.TFBiomeFinalPlateau",
        "twilightforest.biomes.TFBiomeThornlands");

    public OreGenerator() {
        copperOreGen = new WorldGenOre("IC2", "blockOreCopper", 10);
        tinOreGen = new WorldGenOre("IC2", "blockOreTin", 6);
        leadOreGen = new WorldGenOre("IC2", "blockOreLead", 4);
        certusQuartzOreGen = new WorldGenOre("appliedenergistics2", "tile.OreQuartz", 4);
        minicioOreGen = new WorldGenOre("magicalcrops", "MinicioOre", 4);
        silverOreGen = new WorldGenOre("ProjRed|Exploration", "projectred.exploration.ore", 5, 4);
        nickelOreGen = new WorldGenOre("ThermalFoundation", "Ore", 4, 3);
        amberOreGen = new WorldGenOre("BiomesOPlenty", "gemOre", 14, 4);
        chargedCertusQuartzOreGen = new WorldGenOre("appliedenergistics2", "tile.OreQuartzCharged", 4);
        topazOreGen = new WorldGenOre("BiomesOPlenty", "gemOre", 6, 4);
        tanzaniteOreGen = new WorldGenOre("BiomesOPlenty", "gemOre", 8, 4);
        malachiteOreGen = new WorldGenOre("BiomesOPlenty", "gemOre", 10, 4);
        electrotineOreGen = new WorldGenOre("ProjRed|Exploration", "projectred.exploration.ore", 6, 8);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
        IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case 0:
                generateOverworldOres(random, chunkX, chunkZ, world);
                break;
            case 7:
                generateTwilightOres(random, chunkX, chunkZ, world);
                break;
            default:
                break;
        }
    }

    void generateOverworldOres(Random random, int chunkX, int chunkZ, World world) {
        generateOre(17, copperOreGen, 10, 69, chunkX, chunkZ, random, world);
        generateOre(28, tinOreGen, 0, 40, chunkX, chunkZ, random, world);
        generateOre(9, leadOreGen, 0, 64, chunkX, chunkZ, random, world);
        generateOre(25, certusQuartzOreGen, 12, 73, chunkX, chunkZ, random, world);
    }

    void generateTwilightOres(Random random, int chunkX, int chunkZ, World world) {
        String biome = world.getBiomeGenForCoordsBody(chunkX * 16, chunkZ * 16)
            .getBiomeClass()
            .getSimpleName();

        generateOre(17, copperOreGen, 10, 69, chunkX, chunkZ, random, world);
        generateOre(28, tinOreGen, 0, 40, chunkX, chunkZ, random, world);
        generateOre(9, leadOreGen, 0, 64, chunkX, chunkZ, random, world);
        generateOre(25, certusQuartzOreGen, 2, 33, chunkX, chunkZ, random, world);
        generateOre(25, minicioOreGen, 0, 45, chunkX, chunkZ, random, world);
        generateOre(4, silverOreGen, 0, 32, chunkX, chunkZ, random, world);
        generateOre(3, nickelOreGen, 5, 21, chunkX, chunkZ, random, world);
        generateOre(2, chargedCertusQuartzOreGen, 2, 33, chunkX, chunkZ, random, world);
        generateOre(4, electrotineOreGen, 0, 16, chunkX, chunkZ, random, world);

        if (biomesAmberOre.contains(biome)) generateOre(4, amberOreGen, 4, 32, chunkX, chunkZ, random, world);
        if (biomesTopazOre.contains(biome)) generateOre(4, topazOreGen, 4, 32, chunkX, chunkZ, random, world);
        if (biomesTanzaniteOre.contains(biome)) generateOre(4, tanzaniteOreGen, 4, 32, chunkX, chunkZ, random, world);
        if (biomesMalachiteOre.contains(biome)) generateOre(4, malachiteOreGen, 4, 32, chunkX, chunkZ, random, world);
    }

    private void generateOre(int attempts, WorldGenerator worldGenerator, int minY, int maxY, int chunkX, int chunkZ,
        Random random, World world) {
        for (int i = 0; i < attempts; i++) {
            int x = chunkX * 16 + random.nextInt(16);
            int y = random.nextInt(maxY - minY) + minY;
            int z = chunkZ * 16 + random.nextInt(16);
            worldGenerator.generate(world, random, x, y, z);
        }
    }

}
