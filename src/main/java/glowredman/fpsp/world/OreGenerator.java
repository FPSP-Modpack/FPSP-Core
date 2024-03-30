package glowredman.fpsp.world;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.lib.world.biomes.BiomeHandler;

public class OreGenerator implements IWorldGenerator {

    private WorldGenerator copperOreGen;
    private WorldGenerator tinOreGen;
    private WorldGenerator leadOreGen;
    private WorldGenerator minicioOreGen;
    private WorldGenerator silverOreGen;
    private WorldGenerator nickelOreGen;
    private WorldGenerator amberOreGen;
    private WorldGenerator topazOreGen;
    private WorldGenerator tanzaniteOreGen;
    private WorldGenerator malachiteOreGen;
    private WorldGenerator electrotineOreGen;
    private WorldGenerator apatiteOreGen;
    private Block cinnabarOreBlock;
    private final Map<Aspect, WorldGenerator> infusedStoneGen = new HashMap<>();
    private WorldGenerator[] infusedStoneGen_;

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
        minicioOreGen = new WorldGenOre("magicalcrops", "MinicioOre", 4);
        silverOreGen = new WorldGenOre("ProjRed|Exploration", "projectred.exploration.ore", 5, 4);
        nickelOreGen = new WorldGenOre("ThermalFoundation", "Ore", 4, 3);
        amberOreGen = new WorldGenOre("BiomesOPlenty", "gemOre", 14, 4);
        topazOreGen = new WorldGenOre("BiomesOPlenty", "gemOre", 6, 4);
        tanzaniteOreGen = new WorldGenOre("BiomesOPlenty", "gemOre", 8, 4);
        malachiteOreGen = new WorldGenOre("BiomesOPlenty", "gemOre", 10, 4);
        electrotineOreGen = new WorldGenOre("ProjRed|Exploration", "projectred.exploration.ore", 6, 8);
        apatiteOreGen = new WorldGenOre("Forestry", "resources", 36);
        cinnabarOreBlock = GameRegistry.findBlock("Thaumcraft", "blockCustomOre");
        infusedStoneGen.put(Aspect.AIR, new WorldGenOre("Thaumcraft", "blockCustomOre", 1, 7));
        infusedStoneGen.put(Aspect.FIRE, new WorldGenOre("Thaumcraft", "blockCustomOre", 2, 7));
        infusedStoneGen.put(Aspect.WATER, new WorldGenOre("Thaumcraft", "blockCustomOre", 3, 7));
        infusedStoneGen.put(Aspect.EARTH, new WorldGenOre("Thaumcraft", "blockCustomOre", 4, 7));
        infusedStoneGen.put(Aspect.ORDER, new WorldGenOre("Thaumcraft", "blockCustomOre", 5, 7));
        infusedStoneGen.put(Aspect.ENTROPY, new WorldGenOre("Thaumcraft", "blockCustomOre", 6, 7));
        infusedStoneGen_ = infusedStoneGen.values()
            .toArray(new WorldGenerator[infusedStoneGen.size()]);
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
        generateOreVein(17, copperOreGen, 10, 69, chunkX, chunkZ, random, world);
        generateOreVein(28, tinOreGen, 0, 40, chunkX, chunkZ, random, world);
        generateOreVein(9, leadOreGen, 0, 64, chunkX, chunkZ, random, world);
    }

    void generateTwilightOres(Random random, int chunkX, int chunkZ, World world) {
        BiomeGenBase biome = world.getBiomeGenForCoordsBody(chunkX * 16 + 8, chunkZ * 16 + 8);
        String biomeName = biome.getBiomeClass()
            .getSimpleName();

        generateOreVein(17, copperOreGen, 10, 69, chunkX, chunkZ, random, world);
        generateOreVein(28, tinOreGen, 0, 40, chunkX, chunkZ, random, world);
        generateOreVein(9, leadOreGen, 0, 64, chunkX, chunkZ, random, world);
        generateOreVein(25, minicioOreGen, 0, 45, chunkX, chunkZ, random, world);
        generateOreVein(4, silverOreGen, 0, 32, chunkX, chunkZ, random, world);
        generateOreVein(3, nickelOreGen, 5, 21, chunkX, chunkZ, random, world);
        generateOreVein(4, electrotineOreGen, 0, 16, chunkX, chunkZ, random, world);
        generateOre(18, cinnabarOreBlock, 0, 50, chunkX, chunkZ, random, world);

        for (int i = 0; i < 3; i++) {
            WorldGenerator gen = infusedStoneGen.get(BiomeHandler.getRandomBiomeTag(biome.biomeID, random));
            if (gen == null) {
                gen = infusedStoneGen_[random.nextInt(infusedStoneGen_.length)];
            }
            generateOreVein(1, gen, 2, 32, chunkX, chunkZ, random, world);
        }

        if (random.nextDouble() < 0.8) generateOreVein(1, apatiteOreGen, 2, 32, chunkX, chunkZ, random, world);

        if (biomesAmberOre.contains(biomeName)) generateOreVein(4, amberOreGen, 4, 32, chunkX, chunkZ, random, world);
        if (biomesTopazOre.contains(biomeName)) generateOreVein(4, topazOreGen, 4, 32, chunkX, chunkZ, random, world);
        if (biomesTanzaniteOre.contains(biomeName))
            generateOreVein(4, tanzaniteOreGen, 4, 32, chunkX, chunkZ, random, world);
        if (biomesMalachiteOre.contains(biomeName))
            generateOreVein(4, malachiteOreGen, 4, 32, chunkX, chunkZ, random, world);
    }

    private void generateOreVein(int attempts, WorldGenerator worldGenerator, int minY, int maxY, int chunkX,
        int chunkZ, Random random, World world) {
        chunkX *= 16;
        chunkZ *= 16;
        int dY = maxY - minY;
        for (int i = 0; i < attempts; i++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(dY) + minY;
            int z = chunkZ + random.nextInt(16);
            worldGenerator.generate(world, random, x, y, z);
        }
    }

    private void generateOre(int attempts, Block ore, int minY, int maxY, int chunkX, int chunkZ, Random random,
        World world) {
        chunkX *= 16;
        chunkZ *= 16;
        int dY = maxY - minY;
        for (int i = 0; i < attempts; i++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(dY) + minY;
            int z = chunkZ + random.nextInt(16);
            Block block = world.getBlock(x, y, z);
            if (block != null && block.isReplaceableOreGen(world, x, y, z, Blocks.stone)) {
                world.setBlock(x, y, z, ore, 0, 0);
            }

        }
    }

}
