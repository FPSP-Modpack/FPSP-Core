package glowredman.fpsp.handler;

import static glowredman.fpsp.item.ItemDefinitions.*;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.crafting.CompressOreRecipe;
import fox.spiteful.avaritia.crafting.CompressorManager;
import fox.spiteful.avaritia.crafting.CompressorRecipe;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import fox.spiteful.avaritia.crafting.Grinder;
import fox.spiteful.avaritia.items.LudicrousItems;
import galaxyspace.core.register.GSItems;
import glowredman.fpsp.FPSP;
import glowredman.fpsp.Utils;
import glowredman.fpsp.block.BlockMeta;
import glowredman.fpsp.item.ItemFPSPSingularity;
import glowredman.fpsp.item.SingularityDefinitions;
import ic2.api.item.IC2Items;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.RecipeInputOreDict;
import ic2.api.recipe.Recipes;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import mods.railcraft.common.items.firestone.ItemFirestoneRefined;
import reborncore.common.util.OreUtil;
import techreborn.api.reactor.FusionReactorRecipe;
import techreborn.api.reactor.FusionReactorRecipeHelper;
import techreborn.api.recipe.RecipeHandler;
import techreborn.api.recipe.machines.BlastFurnaceRecipe;
import techreborn.api.recipe.machines.CentrifugeRecipe;
import techreborn.api.recipe.machines.ImplosionCompressorRecipe;
import techreborn.blocks.BlockStorage;
import techreborn.items.ItemCells;
import techreborn.items.ItemDusts;
import techreborn.items.ItemDustsSmall;

public class RecipesHandler {

    public static void init() {
        // REMOVE
        removeOreWasherRecipes();
        removeThermalCentrifugeRecipes();

        // ADD
        addShapedRecipes();
        addShapelessRecipes();
        addSmeltingRecipes();

        addNeutroniumCompressor();
        addInfinityCatalystIngredients();
        addExtremeShapelessRecipes();

        addMaceratorRecipes();
        addCompressorRecipes();
        addOreWasherRecipes();
        addThermalCentrifugeRecipes();
        addMetalFormerRecipes();

        addCentrifugeRecipes();
        addFusionRecipes();
        addImplosionCompressorRecipes();
        addBlastFurnaceRecipes();
    }

    private static void addShapedRecipes() {
        craftShaped(new ItemStack(FPSP.blockRedSandstone, 1, 0), "SS", "SS", 'S', new ItemStack(Blocks.sand, 1, 1));
        craftShaped(
            new ItemStack(FPSP.blockRedSandstone, 1, 1),
            "S",
            "S",
            'S',
            new ItemStack(FPSP.blockRedSandstoneSlab));
        craftShaped(
            new ItemStack(FPSP.blockRedSandstone, 4, 2),
            "SS",
            "SS",
            'S',
            new ItemStack(FPSP.blockRedSandstone, 1, OreDictionary.WILDCARD_VALUE));
        craftShaped(
            new ItemStack(FPSP.blockRedSandstoneSlab, 6),
            "SSS",
            'S',
            new ItemStack(FPSP.blockRedSandstone, 1, OreDictionary.WILDCARD_VALUE));
        craftShaped(
            new ItemStack(FPSP.blockRedSandstoneSlabDouble),
            "SS",
            'S',
            new ItemStack(FPSP.blockRedSandstoneSlab));
        craftShaped(
            new ItemStack(FPSP.blockRedSandstoneStairs, 4),
            "S  ",
            "SS ",
            "SSS",
            'S',
            new ItemStack(FPSP.blockRedSandstone, 1, OreDictionary.WILDCARD_VALUE));
        craftShaped(
            MassZivicioDust.getItem(),
            " E ",
            "ESE",
            " E ",
            'E',
            Utils.getItem("magicalcrops", "5ZivicioEssence"),
            'S',
            Utils.getItem("magicalcrops", "InfusionStoneMaster"));
        craftShaped(IngotCast.getItem(), "TT", "TT", 'T', "ingotTungsten");
        craftShaped(
            QuantumMainframe.getItem(4),
            "CSC",
            "LQL",
            "CSC",
            'C',
            "circuitMaster",
            'S',
            "craftingSuperconductor",
            'L',
            "battery100M",
            'Q',
            Utils.getItem("supersolarpanel", "enderquantumcomponent"));
        craftShaped(
            Scanner.getItem(),
            "PDP",
            "PSP",
            "PCP",
            'P',
            "plateAluminium",
            'D',
            Utils.getItem("flansmod", "dwDisplayUnit"),
            'S',
            Utils.getItem("ExtraUtilities", "scanner"),
            'C',
            "circuitData");
        block(0, "gem");
        block(1, "gem");
        block(2, "pearl");
        block(3, "item");
        block(4, "ingot");
        block(5, "item");
        block(6, "gem");
        block(7, "gem");
        block(8, "dust");
        block(9, "ingot");
        block(10, "dust");
        block(11, "gem");
    }

    private static void addShapelessRecipes() {
        craftShapeless(MassZivicioDust.getItem(9), Utils.getItem("magicalcrops", "essence_storage", 5));
        craftShapeless(
            IronEnderCompound.getItem(2),
            "dustIron",
            Utils.getItem("HardcoreEnderExpansion", "end_powder"),
            "dustSmallOsmium");
        craftShapeless(
            UnknownCrystalSeeds.getItem(2),
            "dustQuartz",
            "cropBarnardaCDandelion",
            Utils.getItem("MorePlanet", "frozen_water_bucket"));
        craftShapeless(
            UnknownCrystalSeeds.getItem(2),
            "dustQuartz",
            "cropTCetiESeaweed",
            Utils.getItem("MorePlanet", "frozen_water_bucket"));
    }

    private static void addNeutroniumCompressor() {
        for (SingularityDefinitions s : ItemFPSPSingularity.TYPES) {
            if (s.getAmount() <= 0) {
                continue;
            }
            Object input = s.getInput();
            if (input instanceof String) {
                neutroniumCompress(s.getItem(), s.getAmount(), (String) input, true);
                continue;
            }
            if (input instanceof ItemStack) {
                neutroniumCompress(s.getItem(), s.getAmount(), (ItemStack) input, true);
                continue;
            }
        }
    }

    private static void addInfinityCatalystIngredients() {
        Grinder.catalyst.getRecipeOutput().stackSize = 4;
        inert(new ItemStack(Blocks.emerald_block));
        inert(new ItemStack(LudicrousItems.cosmic_meatballs));
        inert(new ItemStack(GameRegistry.findBlock("ExtraUtilities", "decorativeBlock1"), 1, 5));
        inert(GameRegistry.findItemStack("DraconicEvolution", "draconicBlock", 1));
        inert(GameRegistry.findItemStack("TwilightForest", "item.ironwoodIngot", 1));
        inert(OreDictionary.getOres("blockEnderium"));
        inert(OreDictionary.getOres("blockSteel"));
        inert(OreDictionary.getOres("blockDarkSteel"));
        catalyse(new ItemStack(GameRegistry.findItem("AdvancedSolarPanel", "asp_crafting_items"), 1, 13));
        catalyse(new ItemStack(GameRegistry.findItem("DraconicEvolution", "chaosFragment"), 1, 2));
        catalyse(GameRegistry.findItemStack("DraconicEvolution", "dezilsMarshmallow", 1));
        catalyse(new ItemStack(GameRegistry.findItem("amunra", "item.baseItem"), 1, 26));
        catalyse(new ItemStack(GSItems.Plates, 1, 129));
        catalyse(GameRegistry.findItemStack("MorePlanet", "alphere", 1));
        catalyse(ItemFirestoneRefined.getItemCharged());
        catalyse(GameRegistry.findItemStack("TwilightForest", "tile.FieryBlock", 1));
        catalyse(GameRegistry.findItemStack("TwilightForest", "tile.SteeleafBlock", 1));
        catalyse(GameRegistry.findItemStack("galaxymod", "galaxymod_purgotoasistablet", 1));
        catalyse(new ItemStack(GameRegistry.findItem("magicalcrops", "essence_storage"), 1, 5));
        catalyse(GameRegistry.findItemStack("supersolarpanel", "enderquantumcomponent", 1));
        catalyse(BlockStorage.getStorageBlockByName("chromium"));
        for (SingularityDefinitions s : ItemFPSPSingularity.TYPES) {
            if (s.getAmount() > 0) {
                catalyse(s.getItem());
            }
        }
    }

    private static void addExtremeShapelessRecipes() {
        craftShapelessXtreme(
            CosmicFish.getItem(),
            new ItemStack(LudicrousItems.resource, 1, 2),
            new ItemStack(Items.fish),
            new ItemStack(Items.fish, 1, 1),
            new ItemStack(Items.fish, 1, 2),
            new ItemStack(Items.fish, 1, 3),
            "foodCalamariraw",
            "foodAnchovyraw",
            "foodBassraw",
            "foodCarpraw",
            "foodCatfishraw",
            "foodCharrraw",
            "foodClamraw",
            "foodCrabraw",
            "foodCrayfishraw",
            "foodEelraw",
            "foodFrograw",
            "foodGrouperraw",
            "foodHerringraw",
            "foodJellyfishraw",
            "foodMudfishraw",
            "foodOctopusraw",
            "foodPerchraw",
            "foodScallopraw",
            "foodShrimpraw",
            "foodSnailraw",
            "foodSnapperraw",
            "foodTilapiaraw",
            "foodTroutraw",
            "foodTunaraw",
            "foodTurtleraw",
            "foodWalleyraw",
            "foodGreenheartfish");
        cosmic(CosmicMushroom.getItem(), "listAllmushroom");
        craftShapelessXtreme(
            CosmicVeggie.getItem(),
            new ItemStack(LudicrousItems.resource, 1, 2),
            "cropPumpkin",
            "cropCarrot",
            "cropPotato",
            "cropAsparagus",
            "cropCorn",
            "cropBambooshoot",
            "cropCucumber",
            "cropWintersquash",
            "cropZucchini",
            "cropBeet",
            "cropOnion",
            "cropParsnip",
            "cropRadish",
            "cropRutabaga",
            "cropSweetpotato",
            "cropTurnip",
            "cropRhubarb",
            "cropCelery",
            "cropBroccoli",
            "cropCauliflower",
            "cropLeek",
            "cropLettuce",
            "cropScallion",
            "cropArtichoke",
            "cropBrusselsprout",
            "cropCabbage",
            "cropSpinach",
            "cropBean",
            "cropSoybean",
            "cropBellpepper",
            "cropChilipepper",
            "cropEggplant",
            "cropOkra",
            "cropPeas",
            "cropTomato",
            "cropSeaweed",
            "cropBloodleaf",
            "cropWildcarrots");
        craftShapelessXtreme(
            CosmicFruit.getItem(),
            new ItemStack(LudicrousItems.resource, 1, 2),
            "cropApple",
            "cropMelon",
            Utils.getItem("galaxymod", "galaxymod_fruitofeden"),
            "cropGrape",
            "cropCactusfruit",
            "cropCantaloupe",
            "cropPineapple",
            "cropKiwi",
            "cropApricot",
            "cropAvocado",
            "cropBanana",
            "cropCherry",
            "cropCoconut",
            "cropDate",
            "cropDragonfruit",
            "cropDurian",
            "cropFig",
            "cropGrapefruit",
            "cropLemon",
            "cropLime",
            "cropMango",
            "cropOlive",
            "cropOrange",
            "cropPapaya",
            "cropPeach",
            "cropPear",
            "cropPersimmon",
            "cropPlum",
            "cropPomegranate",
            "cropStarfruit",
            "cropIgnisfruit",
            "cropUnknownFruits");
        craftShapelessXtreme(
            CosmicGrain.getItem(),
            new ItemStack(LudicrousItems.resource, 1, 2),
            "cropWheat",
            "cropBarley",
            "cropOats",
            "cropRye",
            "cropRice");
        craftShapelessXtreme(
            CosmicBerry.getItem(),
            new ItemStack(LudicrousItems.resource, 1, 2),
            "cropBlackberry",
            "cropBlueberry",
            "cropRaspberry",
            "cropStrawberry",
            "cropCranberry",
            "cropGooseberry",
            "cropMarrowberry",
            "cropMaloberry",
            "cropBlightberry",
            "cropDuskberry",
            "cropSkyberry",
            "cropStingberry",
            Utils.getItem("MorePlanet", "fronos_food", 1));
        cosmic(CosmicNut.getItem(), "listAllnut");
        craftShapelessXtreme(
            CosmicSpice.getItem(),
            new ItemStack(LudicrousItems.resource, 1, 2),
            "cropGinger",
            "cropSpiceleaf",
            "cropMustard",
            "cropSesame",
            "cropCurryleaf",
            "cropCinnamon",
            "cropNutmeg",
            "cropPeppercorn",
            "cropVanillabean");
    }

    private static void addFusionRecipes() {
        fusion(
            ItemDusts.getDustByName("silver"),
            ItemCells.getCellByName("helium3"),
            new ItemStack(FPSP.itemCell, 1, 0),
            280000000,
            49152,
            16);
        fusion(
            ItemCells.getCellByName("deuterium"),
            ItemCells.getCellByName("beryllium"),
            new ItemStack(FPSP.itemCell, 1, 1),
            180000000,
            16384,
            16);
        fusion(
            ItemDusts.getDustByName("copper"),
            ItemCells.getCellByName("tritium"),
            new ItemStack(FPSP.itemCell, 1, 2),
            180000000,
            49152,
            16);
        fusion(
            IC2Items.getItem("airCell"),
            ItemDusts.getDustByName("magnesium"),
            new ItemStack(FPSP.itemCell, 1, 3),
            120000000,
            7680,
            128);
        fusion(
            ItemCells.getCellByName("lithium"),
            ItemDusts.getDustByName("aluminium"),
            new ItemStack(FPSP.itemCell, 1, 4),
            240000000,
            10240,
            32);
        fusion(
            ItemDusts.getDustByName("magnesium"),
            ItemCells.getCellByName("silicon"),
            new ItemStack(FPSP.itemCell, 1, 5),
            360000000,
            7680,
            32);
    }

    private static void addCentrifugeRecipes() {
        // Moon Rock Dust
        centrifuge(
            MoonRockDust.getItem(32),
            null,
            MeteoricIronDust.getItem(),
            ic2("copperDust", 2),
            IC2Items.getItem("tinDust"),
            null,
            300,
            25);

        // Moon Dust
        centrifuge(
            MoonDust.getItem(32),
            null,
            MeteoricIronDust.getItem(),
            ic2("copperDust", 2),
            IC2Items.getItem("tinDust"),
            null,
            300,
            25);

        // Mars Rock Dust
        centrifuge(
            MarsRockDust.getItem(32),
            null,
            DeshDust.getItem(),
            ic2("copperDust", 2),
            IC2Items.getItem("tinDust"),
            ic2("ironDust", 3),
            300,
            25);

        // Phobos Rock Dust
        centrifuge(
            PhobosRockDust.getItem(32),
            null,
            OreUtil.getStackFromName("dustCoablt", 2),
            ic2("copperDust", 2),
            IC2Items.getItem("tinDust"),
            ic2("ironDust", 3),
            300,
            25);

        // Deimos Rock Dust
        centrifuge(
            DeimosRockDust.getItem(32),
            null,
            OriharukonDust.getItem(),
            ic2("copperDust", 2),
            IC2Items.getItem("tinDust"),
            ic2("ironDust", 3),
            300,
            25);

        // Ceres Rock Dust
        centrifuge(
            CeresRockDust.getItem(32),
            null,
            ItemDusts.getDustByName("tungsten"),
            ic2("silverDust", 2),
            MeteoricIronDust.getItem(),
            null,
            300,
            25);

        // Asteroid Rock Dust
        centrifuge(
            AsteroidRockDust.getItem(32),
            IC2Items.getItem("cell"),
            ItemDusts.getDustByName("aluminium", 2),
            IC2Items.getItem("ironDust"),
            MeteoricIronDust.getItem(2),
            ItemCells.getCellByName("silicon"),
            300,
            25);

        // Callisto Rock Dust
        centrifuge(
            CallistoRockDust.getItem(32),
            null,
            PalladiumDust.getItem(2),
            OreUtil.getStackFromName("dustCertusQuartz", 4),
            null,
            null,
            300,
            25);

        // Ganymede Rock Dust
        centrifuge(
            GanymedeRockDust.getItem(32),
            null,
            ItemDusts.getDustByName("magnesium", 2),
            ic2("ironDust", 3),
            ItemDusts.getDustByName("titanium"),
            null,
            300,
            25);

        // Europa Dust
        centrifuge(EuropaDust.getItem(32), null, EuropiumDust.getItem(3), null, null, null, 300, 25);

        // Europa Rock Dust
        centrifuge(
            EuropaRockDust.getItem(32),
            null,
            EuropiumDust.getItem(),
            ItemDusts.getDustByName("peridot"),
            ItemDusts.getDustByName("ruby"),
            ItemDusts.getDustByName("sapphire"),
            300,
            25);

        // Io Rock Dust
        centrifuge(
            IoRockDust.getItem(32),
            null,
            MetalMeteoricIronDust.getItem(2),
            IC2Items.getItem("copperDust"),
            ic2("sulfurDust", 3),
            ItemDusts.getDustByName("saltpeter"),
            300,
            25);

        // Io Dust
        centrifuge(IoDust.getItem(32), null, MetalMeteoricIronDust.getItem(4), null, null, null, 300, 25);

        // Mercury Rock Dust
        centrifuge(
            MercuryRockDust.getItem(32),
            null,
            MercurianIronDust.getItem(2),
            MetallicDust.getItem(2),
            ItemDusts.getDustByName("nickel"),
            ic2("leadDust", 2),
            300,
            25);

        // Venus Rock Dust
        centrifuge(
            VenusRockDust.getItem(32),
            null,
            CitrineDust.getItem(),
            ic2("leadDust", 2),
            ic2("copperDust", 2),
            IC2Items.getItem("tinDust"),
            300,
            25);

        // Enceladus Rock Dust
        centrifuge(EnceladusRockDust.getItem(32), null, FrozenIronDust.getItem(2), null, null, null, 300, 25);

        // Enceladus Dust
        centrifuge(EnceladusDust.getItem(32), null, FrozenIronDust.getItem(4), null, null, null, 300, 25);

        // Titan Rock Dust
        centrifuge(
            TitanRockDust.getItem(32),
            null,
            PetaliteDust.getItem(2),
            RhodiumDust.getItem(2),
            ItemDusts.getDustByName("osmium"),
            null,
            300,
            25);

        // Miranda Rock Dust
        centrifuge(MirandaRockDust.getItem(32), null, ic2("ironDust", 3), JadeDust.getItem(2), null, null, 300, 25);

        // Oberon Rock Dust
        centrifuge(OberonRockDust.getItem(32), null, AdamantiteDust.getItem(2), null, null, null, 300, 25);

        // Proteus Rock Dust
        centrifuge(
            ProteusRockDust.getItem(32),
            null,
            ItemDusts.getDustByName("tungsten", 2),
            ItemDusts.getDustByName("platinum"),
            null,
            null,
            300,
            25);

        // Triton Rock Dust
        centrifuge(
            TritonRockDust.getItem(32),
            null,
            ItemDusts.getDustByName("uranium", 2),
            OreUtil.getStackFromName("dustMithril"),
            null,
            null,
            300,
            25);

        // Vega B Rock Dust
        centrifuge(
            VegaBRockDust.getItem(32),
            null,
            WhiteCrystalDust.getItem(2),
            OreUtil.getStackFromName("dustIridium"),
            null,
            null,
            300,
            25);

        // Pluto Rock Dust
        centrifuge(
            PlutoRockDust.getItem(32),
            null,
            ItemDusts.getDustByName("plutonium", 2),
            MeteoricIronDust.getItem(),
            Utils.getItems("MorePlanet", "xeonium_dust", 2),
            FrozenIronDust.getItem(),
            300,
            25);

        // Pluto Dust
        centrifuge(
            PlutoDust.getItem(32),
            null,
            ItemDusts.getDustByName("plutonium", 3),
            Utils.getItems("MorePlanet", "xeonium_dust", 2),
            null,
            null,
            300,
            25);

        // Kuiper Belt
        centrifuge(DenseIceDust.getItem(32), null, IC2Items.getItem("ironDust"), null, null, null, 300, 25);

        // Haumea Rock Dust
        centrifuge(
            HaumeaRockDust.getItem(32),
            null,
            OnyxDust.getItem(2),
            AdamantiteDust.getItem(1),
            OriharukonDust.getItem(1),
            null,
            300,
            25);

        // Makemake Rock Dust
        centrifuge(
            MakemakeRockDust.getItem(32),
            null,
            BismuthDust.getItem(2),
            EuropiumDust.getItem(),
            null,
            null,
            300,
            25);

        // Koentus Rock Dust
        centrifuge(
            KoentusRockDust.getItem(32),
            null,
            MeteoricIronDust.getItem(2),
            WhiteCrystalDust.getItem(),
            ic2("copperDust", 2),
            IC2Items.getItem("tinDust"),
            300,
            25);

        // Koentus Dust
        centrifuge(
            KoentusDust.getItem(32),
            null,
            MeteoricIronDust.getItem(4),
            WhiteCrystalDust.getItem(2),
            null,
            null,
            300,
            25);

        // Diona Rock Dust
        centrifuge(
            DionaRockDust.getItem(32),
            IC2Items.getItem("cell"),
            QuontoniumDust.getItem(2),
            FronisiumDust.getItem(2),
            KoentusMeteoricIronDust.getItem(),
            ItemCells.getCellByName("silicon"),
            300,
            25);

        // alphaCentauri Bb Rock Dust
        centrifuge(
            ACentauriBbRockDust.getItem(32),
            null,
            CentauriumDust.getItem(2),
            MetalMeteoricIronDust.getItem(),
            MetallicDust.getItem(),
            null,
            300,
            25);

        // Polongnius Rock Dust
        centrifuge(
            PolongniusRockDust.getItem(32),
            null,
            PolongniusMeteoricIronDust.getItem(2),
            FloniumDust.getItem(2),
            PalladiumDust.getItem(2),
            IC2Items.getItem("tinDust"),
            300,
            25);

        // Barnarda C Dust
        centrifuge(
            BarnardaCDust.getItem(32),
            null,
            PinkQuartzDust.getItem(4),
            IC2Items.getItem("coalDust"),
            null,
            null,
            300,
            25);

        // Barnarda E Rock Dust
        centrifuge(
            BarnardaERockDust.getItem(32),
            null,
            CarnelianDust.getItem(2),
            ic2("goldDust", 2),
            ic2("ironDust", 2),
            null,
            300,
            25);

        // Barnarda F Rock Dust
        centrifuge(
            BarnardaFRockDust.getItem(32),
            null,
            ChalcedonyDust.getItem(2),
            ItemDusts.getDustByName("plutonium", 2),
            OreUtil.getStackFromName("dustMithril"),
            null,
            300,
            25);

        // Nibiru Rock Dust
        centrifuge(
            NibiruRockDust.getItem(32),
            null,
            RedGemDust.getItem(2),
            IchoriusDust.getItem(2),
            IC2Items.getItem("ironDust"),
            null,
            300,
            25);

        // T Ceti E Rock Dust
        centrifuge(
            TCetiERockDust.getItem(32),
            null,
            NoriumDust.getItem(2),
            EMPDust.getItem(2),
            ItemDusts.getDustByName("platinum"),
            IC2Items.getItem("silverDust"),
            300,
            25);

        // Eden Rock Dust
        centrifuge(
            EdenRockDust.getItem(32),
            null,
            ViriniumDust.getItem(2),
            DeshDust.getItem(2),
            ItemDusts.getDustByName("aluminium"),
            MeteoricIronDust.getItem(),
            300,
            25);

        // Eden Dust
        centrifuge(
            EdenDust.getItem(32),
            null,
            ViriniumDust.getItem(4),
            IC2Items.getItem("coalDust"),
            null,
            null,
            300,
            25);

        // Kapteyn B Rock Dust
        centrifuge(
            KapteynBRockDust.getItem(32),
            null,
            NameriumDust.getItem(2),
            FrozenIronDust.getItem(),
            ItemDusts.getDustByName("uranium"),
            null,
            300,
            25);

        // Kapteyn B Dust
        centrifuge(
            KapteynBDust.getItem(32),
            null,
            NameriumDust.getItem(4),
            ItemDusts.getDustByName("uranium", 2),
            IceCrystalDust.getItem(),
            null,
            300,
            25);

        // Fronos Rock Dust
        centrifuge(
            FronosRockDust.getItem(32),
            null,
            OreUtil.getStackFromName("dustIridium"),
            ic2("goldDust", 2),
            ic2("copperDust", 4),
            ItemDusts.getDustByName("aluminium", 2),
            300,
            25);

        // Fronos Dust
        centrifuge(
            FronosDust.getItem(32),
            null,
            OreUtil.getStackFromName("dustIridium", 2),
            IC2Items.getItem("coalDust"),
            null,
            null,
            300,
            25);

        // Kriffon Rock Dust
        centrifuge(
            KriffonRockDust.getItem(32),
            null,
            BlackDiamondDust.getItem(1),
            RedGemDust.getItem(1),
            OreUtil.getStackFromName("dustCobalt"),
            ItemDusts.getDustByName("tungsten"),
            300,
            25);

        // Kriffon Dust
        centrifuge(
            KriffonDust.getItem(32),
            null,
            BlackDiamondDust.getItem(3),
            RedGemDust.getItem(1),
            null,
            null,
            300,
            25);

        // Zolrock Dust
        centrifuge(
            ZolrockDust.getItem(32),
            null,
            HeartiumDust.getItem(2),
            NoriumDust.getItem(1),
            ic2("tinDust", 2),
            ic2("copperDust", 3),
            300,
            25);

        // Zollus Dust
        centrifuge(ZollusDust.getItem(32), null, NoriumDust.getItem(1), HeartiumDust.getItem(3), null, null, 300, 25);

        // Sirius B Rock Dust
        centrifuge(
            SiriusBRockDust.getItem(32),
            null,
            ic2("sulfurDust", 4),
            ItemDusts.getDustByName("diamond", 2),
            ItemDusts.getDustByName("tungsten", 2),
            null,
            300,
            25);

        // Oasis Rock Dust
        centrifuge(
            OasisRockDust.getItem(32),
            null,
            ic2("silverDust", 3),
            ItemDusts.getDustByName("titanium", 2),
            null,
            null,
            300,
            25);

        // Oasis Dust
        centrifuge(
            OasisDust.getItem(32),
            null,
            ItemDusts.getDustByName("titanium"),
            ic2("silverDust", 2),
            ic2("sulfurDust", 3),
            ItemDusts.getDustByName("saltpeter"),
            300,
            25);

        // Xathian Rock Dust
        centrifuge(
            XathianRockDust.getItem(32),
            null,
            XathianPrometheanDust.getItem(3),
            ItemDusts.getDustByName("platinum", 2),
            ItemDusts.getDustByName("osmium", 2),
            null,
            300,
            25);

        // Xathian Dust
        centrifuge(XathianDust.getItem(32), null, XathianPrometheanDust.getItem(5), null, null, null, 300, 25);

        // Purgot Rock Dust
        centrifuge(
            PurgotRockDust.getItem(32),
            null,
            Utils.getItems("galaxymod", "galaxymod_eveniumdust", 3),
            ViriniumDust.getItem(2),
            OreUtil.getStackFromName("dustCobalt"),
            null,
            300,
            25);

        // Purgot Dust
        centrifuge(
            PurgotDust.getItem(32),
            null,
            Utils.getItems("galaxymod", "galaxymod_eveniumdust", 5),
            null,
            null,
            null,
            300,
            25);

        // Neper Dust
        centrifuge(
            NeperDust.getItem(32),
            null,
            PurpleGemDust.getItem(4),
            ItemDusts.getDustByName("diamond", 2),
            ItemDusts.getDustByName("emerald", 2),
            null,
            300,
            25);

        // Maahes Dust
        centrifuge(
            MaahesDust.getItem(32),
            null,
            ic2("coalDust", 5),
            ItemDusts.getDustByName("aluminium", 2),
            ic2("ironDust", 4),
            Utils.getItems("MorePlanet", "xeonium_dust", 3),
            300,
            25);

        // Basalt Rock Dust Anubis
        centrifuge(
            BasaltRockDust.getItem(32),
            null,
            ChioniteDust.getItem(2),
            ItemDusts.getDustByName("uranium", 2),
            null,
            null,
            300,
            25);

        // Basalt Dust Anubis
        centrifuge(
            BasaltDust.getItem(32),
            null,
            ChioniteDust.getItem(4),
            ItemDusts.getDustByName("uranium", 4),
            null,
            null,
            300,
            25);

        // Dust
        centrifuge(
            Utils.getItems("amunra", "item.baseItem", 2, 8),
            null,
            ChioniteDust.getItem(4),
            ItemDusts.getDustByName("uranium", 4),
            null,
            null,
            300,
            25);

        // Obsidian Sand Dust Horus
        centrifuge(
            ObsidianSandDust.getItem(32),
            null,
            ItemDusts.getDustByName("diamond"),
            ItemDusts.getDustByName("emerald"),
            ic2("obsidianDust", 6),
            null,
            300,
            25);

        // Coral Rock Seth
        centrifuge(CoralDust.getItem(32), null, BacterialFossilDust.getItem(6), null, null, null, 300, 25);

        // Dark Asteroid Rock Dust
        centrifuge(
            DarkAsteroidRockDust.getItem(32),
            null,
            AlphereDust.getItem(2),
            ItemDusts.getDustByName("diamond", 2),
            OreUtil.getStackFromName("dustIridium", 3),
            OreUtil.getStackFromName("dustDraconium", 2),
            300,
            25);

        // Dark Asteroid Dust
        centrifuge(
            DarkAsteroidDust.getItem(32),
            null,
            AlphereDust.getItem(4),
            OreUtil.getStackFromName("dustIridium", 4),
            OreUtil.getStackFromName("dustDraconium", 4),
            null,
            300,
            25);
    }

    private static void addMaceratorRecipes() {
        macerate("oreDesh", DeshDust.getItem(2));
        // Moon
        macerate(Utils.getItems("GalacticraftCore", "tile.moonBlock", 3, 4), MoonDust.getItem());
        macerate(Utils.getItems("GalacticraftCore", "tile.moonBlock", 4, 4), MoonRockDust.getItem());
        macerate(Utils.getItems("GalacticraftCore", "tile.moonBlock", 5, 4), MoonDust.getItem());
        macerate(Utils.getItems("GalacticraftCore", "tile.moonBlock", 14, 2), MoonRockDust.getItem());

        // Mars
        macerate(Utils.getItems("GalacticraftMars", "tile.mars", 4, 4), MarsRockDust.getItem());
        macerate(Utils.getItems("GalacticraftMars", "tile.mars", 5, 4), MarsRockDust.getItem());
        macerate(Utils.getItems("GalacticraftMars", "tile.mars", 6, 4), MarsRockDust.getItem());
        macerate(Utils.getItems("GalacticraftMars", "tile.mars", 7, 2), MarsRockDust.getItem());
        macerate(Utils.getItems("GalacticraftMars", "tile.mars", 9, 4), MarsRockDust.getItem());

        // Phobos
        macerate(Utils.getItems("GalaxySpace", "phobosblocks", 4), PhobosRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "phobosblocks", 1, 4), PhobosRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "phobosblocks", 2, 4), PhobosRockDust.getItem());

        // Phobos
        macerate(Utils.getItems("GalaxySpace", "deimosblocks", 4), DeimosRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "deimosblocks", 1, 4), DeimosRockDust.getItem());

        // Ceres
        macerate(Utils.getItems("GalaxySpace", "ceresblocks", 4), CeresRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "ceresblocks", 1, 4), CeresRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "ceresblocks", 2, 2), CeresRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "ceresblocks", 4, 2), CeresRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "ceresblocks", 5, 2), CeresRockDust.getItem());

        // Asteroids
        macerate(Utils.getItems("GalacticraftMars", "tile.asteroidsBlock", 4), AsteroidRockDust.getItem());
        macerate(Utils.getItems("GalacticraftMars", "tile.asteroidsBlock", 1, 4), AsteroidRockDust.getItem());
        macerate(Utils.getItems("GalacticraftMars", "tile.asteroidsBlock", 2, 4), AsteroidRockDust.getItem());

        // Callisto
        macerate(Utils.getItems("GalaxySpace", "callistoblocks", 4), CallistoRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "callistoblocks", 1, 4), CallistoRockDust.getItem());

        // Ganymede
        macerate(Utils.getItems("GalaxySpace", "ganymedeblocks", 4), GanymedeRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "ganymedeblocks", 1, 4), GanymedeRockDust.getItem());

        // Europa
        macerate(Utils.getItems("GalaxySpace", "europagrunt", 4), EuropaRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "europagrunt", 1, 4), EuropaDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "europageyser", 2), EuropaRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "europaunderwatergeyser", 2), EuropaDust.getItem());

        // Io
        macerate(Utils.getItems("GalaxySpace", "ioblocks", 4), IoRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "ioblocks", 1, 4), IoDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "ioblocks", 2, 4), IoRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "ioblocks", 3, 2), IoRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "ioblocks", 7, 2), IoRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "ioblocks", 8, 2), IoRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "iodualstone", 2), IoRockDust.getItem());

        // Mercury
        macerate(Utils.getItems("GalaxySpace", "mercuryblocks", 4), MercuryRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "mercuryblocks", 1, 4), MercuryRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "mercuryblocks", 2, 4), MercuryRockDust.getItem());

        // Venus
        macerate(Utils.getItems("GalaxySpace", "venusblocks", 4), VenusRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "venusblocks", 1, 4), VenusRockDust.getItem());

        // Enceladus
        macerate(Utils.getItems("GalaxySpace", "enceladusblocks", 4), EnceladusDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "enceladusblocks", 1, 4), EnceladusRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "enceladusblocks", 2, 2), EnceladusRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "enceladusblocks", 3, 4), EnceladusDust.getItem());

        // Titan
        macerate(Utils.getItems("GalaxySpace", "titanblocks", 4), TitanRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "titanblocks", 1, 4), TitanRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "titanblocks", 2, 4), TitanRockDust.getItem());

        // Miranda
        macerate(Utils.getItems("GalaxySpace", "mirandablocks", 4), MirandaRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "mirandablocks", 1, 4), MirandaRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "mirandablocks", 2, 4), MirandaRockDust.getItem());

        // Oberon
        macerate(Utils.getItems("GalaxySpace", "oberonblocks", 4), OberonRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "oberonblocks", 1, 4), OberonRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "oberonblocks", 2, 4), OberonRockDust.getItem());

        // Proteus
        macerate(Utils.getItems("GalaxySpace", "proteusblocks", 4), ProteusRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "proteusblocks", 1, 4), ProteusRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "proteusblocks", 2, 4), ProteusRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "proteusblocks", 3, 2), ProteusRockDust.getItem());

        // Triton
        macerate(Utils.getItems("GalaxySpace", "tritonblocks", 4), TritonRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "tritonblocks", 1, 4), TritonRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "tritonblocks", 2, 4), TritonRockDust.getItem());

        // Vega B
        macerate(Utils.getItems("GalaxySpace", "vegabgrunt", 4), VegaBRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "vegabsubgrunt", 4), VegaBRockDust.getItem());

        // Pluto
        macerate(Utils.getItems("GalaxySpace", "plutoblocks", 4), PlutoDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "plutoblocks", 1, 4), PlutoDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "plutoblocks", 2, 4), PlutoDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "plutoblocks", 3, 4), PlutoDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "plutoblocks", 4, 4), PlutoDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "plutoblocks", 5, 4), PlutoRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "plutoblocks", 6, 2), PlutoRockDust.getItem());

        // Kuiper Belt
        macerate(Utils.getItems("GalacticraftMars", "tile.denseIce", 4), DenseIceDust.getItem());

        // Haumea
        macerate(Utils.getItems("GalaxySpace", "haumeablocks", 4), HaumeaRockDust.getItem());

        // Haumea
        macerate(Utils.getItems("GalaxySpace", "makemakegrunt", 4), MakemakeRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "makemakegrunt", 1, 4), MakemakeRockDust.getItem());

        // Koentus
        macerate(Utils.getItems("MorePlanet", "koentus_ice", 4), KoentusDust.getItem());
        macerate(Utils.getItems("MorePlanet", "koentus_ice", 1, 2), KoentusDust.getItem());
        macerate(Utils.getItems("MorePlanet", "space_mossy_cobblestone", 3, 4), KoentusRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "koentus_block", 4), KoentusRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "koentus_block", 1, 4), KoentusRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "koentus_block", 2, 4), KoentusRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "koentus_block", 3, 4), KoentusRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "koentus_block", 11, 2), KoentusRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "koentus_block", 12, 2), KoentusRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "koentus_block", 13, 2), KoentusRockDust.getItem());

        // Diona
        macerate(Utils.getItems("MorePlanet", "space_mossy_cobblestone", 4), DionaRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "diona_block", 4), DionaRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "diona_block", 1, 4), DionaRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "diona_block", 2, 4), DionaRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "diona_block", 3, 4), DionaRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "diona_block", 14, 2), DionaRockDust.getItem());

        // aCentauri Bb
        macerate(Utils.getItems("GalaxySpace", "acentauribbgrunt", 4), ACentauriBbRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "acentauribbsubgrunt", 4), ACentauriBbRockDust.getItem());

        // Polongnius
        macerate(Utils.getItems("MorePlanet", "space_mossy_cobblestone", 1, 4), PolongniusRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "polongnius_block", 2, 4), PolongniusRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "polongnius_block", 3, 4), PolongniusRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "polongnius_block", 13, 2), PolongniusRockDust.getItem());
        macerate(Utils.getItem("MorePlanet", "polongnius_block", 14), PolongniusRockDust.getItem());

        // Barnarda C
        macerate(Utils.getItems("GalaxySpace", "barnardaCgrass", 4), BarnardaCDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "barnardaCdirt", 4), BarnardaCDust.getItem());

        // Barnarda E
        macerate(Utils.getItems("GalaxySpace", "barnardaEgrunt", 4), BarnardaERockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "barnardaEsubgrunt", 4), BarnardaERockDust.getItem());

        // Barnarda F
        macerate(Utils.getItems("GalaxySpace", "barnardaFgrunt", 4), BarnardaFRockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "barnardaFsubgrunt", 4), BarnardaFRockDust.getItem());

        // Nibiru
        macerate(Utils.getItems("MorePlanet", "space_mossy_cobblestone", 2, 4), NibiruRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "nibiru_block", 4), NibiruRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "nibiru_block", 1, 4), NibiruRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "nibiru_block", 2, 4), NibiruRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "nibiru_block", 3, 4), NibiruRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "nibiru_block", 12, 2), NibiruRockDust.getItem());

        // T Ceti E
        macerate(Utils.getItems("GalaxySpace", "tcetieblocks", 4), TCetiERockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "tcetieblocks", 1, 4), TCetiERockDust.getItem());
        macerate(Utils.getItems("GalaxySpace", "tcetieblocks", 2, 4), TCetiERockDust.getItem());

        // Eden
        macerate(Utils.getItems("galaxymod", "galaxymod_edencobblerock", 4), EdenRockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_edenrock", 4), EdenRockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_edenrockbricks", 4), EdenRockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_edensurfaceblock", 2), EdenRockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_edensoil", 4), EdenDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_edengrass", 4), EdenDust.getItem());
        macerate(Utils.getItem("galaxymod", "galaxymod_edengoldengrass"), EdenDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_bloodsand", 4), EdenDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_edenwinterrock", 4), EdenRockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_bonestone", 2), EdenRockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_edengravel", 2), EdenDust.getItem());
        macerate(Utils.getItem("galaxymod", "galaxymod_bloodstone"), EdenRockDust.getItem());
        macerate(Utils.getItem("galaxymod", "galaxymod_edensacredstone"), EdenRockDust.getItem());

        // Kapteyn B
        macerate(Utils.getItems("MorePlanet", "space_mossy_cobblestone", 4, 4), KapteynBRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "kapteyn-b_block", 4), KapteynBDust.getItem());
        macerate(Utils.getItems("MorePlanet", "kapteyn-b_block", 1, 4), KapteynBDust.getItem());
        macerate(Utils.getItems("MorePlanet", "kapteyn-b_block", 2, 4), KapteynBRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "kapteyn-b_block", 3, 4), KapteynBRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "kapteyn-b_block", 14, 2), KapteynBRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "kapteyn-b_ice", 4), KapteynBDust.getItem());
        macerate(Utils.getItems("MorePlanet", "kapteyn-b_ice", 1, 4), KapteynBDust.getItem());

        // Fronos
        macerate(Utils.getItems("MorePlanet", "fronos_dirt", 4), FronosDust.getItem());
        macerate(Utils.getItems("MorePlanet", "fronos_dirt", 1, 4), FronosDust.getItem());
        macerate(Utils.getItems("MorePlanet", "fronos_grass", 4), FronosDust.getItem());
        macerate(Utils.getItems("MorePlanet", "fronos_sand", 4), FronosDust.getItem());
        macerate(Utils.getItems("MorePlanet", "fronos_sandstone", 4), FronosDust.getItem());
        macerate(Utils.getItems("MorePlanet", "fronos_sandstone", 1, 4), FronosDust.getItem());
        macerate(Utils.getItems("MorePlanet", "fronos_sandstone", 2, 2), FronosDust.getItem());
        macerate(Utils.getItems("MorePlanet", "fronos_block", 4), FronosRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "fronos_block", 1, 4), FronosRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "fronos_block", 11, 4), FronosRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "fronos_block", 12, 4), FronosRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "fronos_block", 13, 4), FronosRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "fronos_block", 14, 2), FronosRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "mossy_fronos_cobblestone", 4), FronosRockDust.getItem());

        // Kriffon
        macerate(Utils.getItems("galaxymod", "galaxymod_kriffrock", 4), KriffonRockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_kriffcobblerock", 4), KriffonRockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_kriffstone", 4), KriffonDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_kriffdirt", 4), KriffonDust.getItem());

        // Eden
        macerate(Utils.getItems("galaxymod", "galaxymod_zoldirt", 4), ZollusDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_zolrockbricks", 4), ZolrockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_solarblock", 2), ZolrockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_zolcobblerock", 4), ZolrockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_zolstone", 4), ZolrockDust.getItem());

        // Sirius B
        macerate(Utils.getItems("MorePlanet", "space_mossy_cobblestone", 5, 4), SiriusBRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "sirius_block", 4), SiriusBRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "sirius_block", 1, 4), SiriusBRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "sirius_block", 2, 4), SiriusBRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "sirius_block", 3, 4), SiriusBRockDust.getItem());
        macerate(Utils.getItem("MorePlanet", "sirius_block", 7), SiriusBRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "sirius_block", 9, 2), SiriusBRockDust.getItem());

        // Oasis
        macerate(Utils.getItems("galaxymod", "galaxymod_oasisgrass", 4), OasisDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_oasisdirt", 4), OasisDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_oasiscobblerock", 4), OasisRockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_oasisrock", 4), OasisRockDust.getItem());

        // Xathius
        macerate(Utils.getItems("galaxymod", "galaxymod_xathgrass", 4), XathianDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_xathdirt", 4), XathianDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_xathstone", 4), XathianRockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_xathrock", 4), XathianRockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_xathcobblerock", 4), XathianRockDust.getItem());

        // Purgot
        macerate(Utils.getItems("galaxymod", "galaxymod_purgdirt", 4), PurgotDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_purgcobblerock", 4), PurgotRockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_purgstone", 4), PurgotRockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_purgrock", 4), PurgotRockDust.getItem());
        macerate(Utils.getItems("galaxymod", "galaxymod_purgrockbricks", 4), PurgotRockDust.getItem());

        // Neper
        macerate(Utils.getItems("amunra", "tile.baseBlockRock", 10, 4), NeperDust.getItem());

        // Maahes
        macerate(Utils.getItems("amunra", "tile.wood1", 1, 4), MaahesDust.getItem());

        // Anubis
        macerate(Utils.getItems("amunra", "tile.baseBlockRock", 4), BasaltRockDust.getItem());
        macerate(Utils.getItems("amunra", "tile.baseBlockRock", 1, 4), BasaltRockDust.getItem());
        macerate(Utils.getItems("amunra", "tile.baseBlockGround", 1, 4), BasaltDust.getItem());
        macerate(Utils.getItems("amunra", "tile.baseFalling", 2, 4), BasaltDust.getItem());

        // Horus
        macerate(Utils.getItems("amunra", "tile.baseFalling", 4), ObsidianSandDust.getItem());
        macerate(Utils.getItems("amunra", "tile.baseFalling", 1, 4), ObsidianSandDust.getItem());

        // Seth
        macerate(Utils.getItems("amunra", "tile.baseBlockCrystal", 2), CoralDust.getItem());

        // Dark Asteroids
        macerate(Utils.getItems("MorePlanet", "dark_asteroid_block", 4), DarkAsteroidRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "dark_asteroid_block", 1, 4), DarkAsteroidRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "dark_asteroid_block", 2, 4), DarkAsteroidRockDust.getItem());
        macerate(Utils.getItems("MorePlanet", "dark_asteroid_quicksand", 4), DarkAsteroidDust.getItem());
    }

    private static void addMetalFormerRecipes() {
        press(SiliconCarbideIngot.getItem(), SiliconCarbidePlate.getItem());
        press(TungstenCarbideIngot.getItem(), TungstenCarbidePlate.getItem());
    }

    private static void addCompressorRecipes() {
        compress(new ItemStack(Blocks.sand, 4, 1), new ItemStack(FPSP.blockRedSandstone));
    }

    private static void addSmeltingRecipes() {
        smelt(MeteoricIronDust.getItem(), new ItemStack(GCItems.meteoricIronIngot));
        smelt(DeshDust.getItem(), new ItemStack(MarsItems.marsItemBasic, 1, 2));
        smelt(AdamantiteDust.getItem(), new ItemStack(GSItems.Ingots));
        smelt(OriharukonDust.getItem(), new ItemStack(GSItems.Ingots, 1, 7));
        smelt(MercurianIronDust.getItem(), Utils.getItem("galacticores", "itemIngots"));
        smelt(BismuthDust.getItem(), Utils.getItem("galacticores", "itemIngots", 2));
        smelt(CentauriumDust.getItem(), Utils.getItem("galacticores", "itemIngots", 3));
        smelt(EuropiumDust.getItem(), Utils.getItem("galacticores", "itemIngots", 5));
        smelt(PalladiumDust.getItem(), Utils.getItem("galacticores", "itemIngots", 6));
        smelt(RhodiumDust.getItem(), Utils.getItem("galacticores", "itemIngots", 7));
        smelt(MetallicDust.getItem(), Utils.getItem("MorePlanet", "mercury_item", 2));
        smelt(MetalMeteoricIronDust.getItem(), Utils.getItem("MorePlanet", "mercury_item", 3));
        smelt(FrozenIronDust.getItem(), Utils.getItem("MorePlanet", "kapteyn-b_item"));
        smelt(KoentusMeteoricIronDust.getItem(), Utils.getItem("MorePlanet", "koentus_item", 4));
        smelt(QuontoniumDust.getItem(), Utils.getItem("MorePlanet", "diona_item"));
        smelt(FronisiumDust.getItem(), Utils.getItem("MorePlanet", "diona_item", 1));
        smelt(NoriumDust.getItem(), Utils.getItem("MorePlanet", "nibiru_item", 1));
        smelt(PolongniusMeteoricIronDust.getItem(), Utils.getItem("MorePlanet", "polongnius_item", 4));
        smelt(ViriniumDust.getItem(), Utils.getItem("galaxymod", "galaxymod_ingotviri"));
    }

    private static void addImplosionCompressorRecipes() {
        compressGem(CitrineDust.getItem(), Utils.getItem("galacticores", "itemDrops"));
        compressGem(OnyxDust.getItem(), Utils.getItem("galacticores", "itemDrops", 1));
        compressGem(PinkQuartzDust.getItem(), Utils.getItem("galacticores", "itemDrops", 2));
        compressGem(CarnelianDust.getItem(), Utils.getItem("galacticores", "itemDrops", 3));
        compressGem(ChalcedonyDust.getItem(), Utils.getItem("galacticores", "itemDrops", 4));
        compressGem(JadeDust.getItem(), Utils.getItem("galacticores", "itemDrops", 6));
        compressGem(PetaliteDust.getItem(), Utils.getItem("galacticores", "itemDrops", 7));
        compressGem(WhiteCrystalDust.getItem(), Utils.getItem("MorePlanet", "koentus_item"));
        compressGem(BacterialFossilDust.getItem(), Utils.getItem("MorePlanet", "koentus_item", 2));
        compressGem(EMPDust.getItem(), Utils.getItem("MorePlanet", "koentus_item", 1));
        compressGem(FloniumDust.getItem(), Utils.getItem("MorePlanet", "polongnius_item"));
        compressGem(PurpleGemDust.getItem(), Utils.getItem("MorePlanet", "polongnius_item", 1));
        compressGem(IchoriusDust.getItem(), Utils.getItem("MorePlanet", "power_crystal"));
        compressGem(RedGemDust.getItem(), Utils.getItem("MorePlanet", "nibiru_item"));
        compressGem(NameriumDust.getItem(), Utils.getItem("MorePlanet", "namerium_crystal"));
        compressGem(BlackDiamondDust.getItem(), Utils.getItem("MorePlanet", "fronos_item", 2));
        compressGem(HeartiumDust.getItem(), Utils.getItem("galaxymod", "galaxymod_heartofzol"));
        compressGem(XathianPrometheanDust.getItem(), Utils.getItem("galaxymod", "galaxymod_prometheancrystal"));
        compressGem(ChioniteDust.getItem(), Utils.getItem("amunra", "item.baseItem", 3));
        compressGem(AlphereDust.getItem(), Utils.getItem("MorePlanet", "alphere"));
        compressGem(Utils.getItems("MorePlanet", "xeonium_dust", 16), Utils.getItems("MorePlanet", "pluto_item", 3));
        compressGem(
            Utils.getItem("appliedenergistics2", "item.ItemMultiMaterial", 2),
            Utils.getItem("appliedenergistics2", "item.ItemMultiMaterial"));
        compressGem(Utils.getItem("appliedenergistics2", "item.ItemMultiMaterial", 3), new ItemStack(Items.quartz));
        compressGem(ic2("lithiumDust", 3), Utils.getItems("amunra", "item.baseItem", 7, 3));
        implosionCompress(
            IceCrystalDust.getItem(16),
            ic2("industrialTnt", 24),
            Utils.getItem("MorePlanet", "kapteyn-b_item", 5),
            ItemDusts.getDustByName("darkAshes", 12),
            20,
            32);
    }

    private static void removeOreWasherRecipes() {
        unwash(aobd("crushedQuartz"));
        unwash(aobd("crushedMithril"));
        unwash(aobd("crushedMagnesium"));
        unwash(aobd("crushedMeteoricIron"));
    }

    private static void addOreWasherRecipes() {
        washOre("Quartz", ItemDustsSmall.getSmallDustByName("netherrack", 2));
        washOre("Aluminium", ItemDustsSmall.getSmallDustByName("bauxite", 2));
        washOre("Titanium", ItemDustsSmall.getSmallDustByName("almandine", 2));
        washOre("Nickel", aobd("dustTinyCobalt", 2));
        washOre("Mithril", ItemDustsSmall.getSmallDustByName("platinum", 2));
        washOre("Magnesium", ItemDustsSmall.getSmallDustByName("olivine", 2));
        washOre("Plutonium", ItemDustsSmall.getSmallDustByName("uranium", 2));
        washOre("Zinc", ic2("smallTinDust", 2));
        washOre("MeteoricIron", ic2("smallIronDust", 2));
    }

    private static void removeThermalCentrifugeRecipes() {
        unThermalCentrifuge(aobd("crushedQuartz"));
        unThermalCentrifuge(aobd("crushedPurifiedQuartz"));
        unThermalCentrifuge(aobd("crushedMithril"));
        unThermalCentrifuge(aobd("crushedPurifiedMithril"));
        unThermalCentrifuge(aobd("crushedSulfur"));
        unThermalCentrifuge(aobd("crushedPurifiedSulfur"));
        unThermalCentrifuge(aobd("crushedDraconium"));
        unThermalCentrifuge(aobd("crushedPurifiedDraconium"));
        unThermalCentrifuge(aobd("crushedCobalt"));
        unThermalCentrifuge(aobd("crushedPurifiedCobalt"));
        unThermalCentrifuge(aobd("crushedOriharukon"));
        unThermalCentrifuge(aobd("crushedPurifiedOriharukon"));
        unThermalCentrifuge(aobd("crushedMagnesium"));
        unThermalCentrifuge(aobd("crushedPurifiedMagnesium"));
        unThermalCentrifuge(aobd("crushedAdamantite"));
        unThermalCentrifuge(aobd("crushedPurifiedAdamantite"));
        unThermalCentrifuge(aobd("crushedHeeEndium"));
        unThermalCentrifuge(aobd("crushedPurifiedHeeEndium"));
        unThermalCentrifuge(aobd("crushedPalladium"));
        unThermalCentrifuge(aobd("crushedPurifiedPalladium"));
        unThermalCentrifuge(aobd("crushedEuropium"));
        unThermalCentrifuge(aobd("crushedPurifiedEuropium"));
        unThermalCentrifuge(aobd("crushedBismuth"));
        unThermalCentrifuge(aobd("crushedPurifiedBismuth"));
        unThermalCentrifuge(aobd("crushedMeteoricIron"));
        unThermalCentrifuge(aobd("crushedPurifiedMeteoricIron"));
    }

    private static void addThermalCentrifugeRecipes() {
        ItemStack stoneDust = IC2Items.getItem("stoneDust");
        thermalCentrifuge(
            "crushedQuartz",
            1960,
            Utils.getItem("appliedenergistics2", "item.ItemMultiMaterial", 3),
            ItemDustsSmall.getSmallDustByName("netherrack"),
            stoneDust);
        thermalCentrifuge(
            "crushedPurifiedQuartz",
            1960,
            Utils.getItem("appliedenergistics2", "item.ItemMultiMaterial", 3),
            ItemDustsSmall.getSmallDustByName("netherrack"));
        thermalCentrifuge(
            "crushedAluminium",
            520,
            ItemDusts.getDustByName("aluminium"),
            ItemDustsSmall.getSmallDustByName("bauxite"),
            stoneDust);
        thermalCentrifuge(
            "crushedPurifiedAluminium",
            520,
            ItemDusts.getDustByName("aluminium"),
            ItemDustsSmall.getSmallDustByName("bauxite"));
        thermalCentrifuge(
            "crushedTitanium",
            960,
            ItemDusts.getDustByName("titanium"),
            ItemDustsSmall.getSmallDustByName("almandine"),
            stoneDust);
        thermalCentrifuge(
            "crushedPurifiedTitanium",
            960,
            ItemDusts.getDustByName("titanium"),
            ItemDustsSmall.getSmallDustByName("almandine"));
        thermalCentrifuge(
            "crushedNickel",
            1160,
            ItemDusts.getDustByName("nickel"),
            ItemDustsSmall.getSmallDustByName("platinum"),
            stoneDust);
        thermalCentrifuge(
            "crushedPurifiedNickel",
            1160,
            ItemDusts.getDustByName("nickel"),
            ItemDustsSmall.getSmallDustByName("platinum"));
        thermalCentrifuge(
            "crushedMithril",
            5000,
            Utils.getItem("ThermalFoundation", "material", 38),
            ItemDustsSmall.getSmallDustByName("platinum"),
            stoneDust);
        thermalCentrifuge(
            "crushedPurifiedMithril",
            5000,
            Utils.getItem("ThermalFoundation", "material", 38),
            ItemDustsSmall.getSmallDustByName("platinum"));
        thermalCentrifuge(
            "crushedSulfur",
            640,
            IC2Items.getItem("sulfurDust"),
            IC2Items.getItem("smallSulfurDust"),
            stoneDust);
        thermalCentrifuge(
            "crushedPurifiedSulfur",
            640,
            IC2Items.getItem("sulfurDust"),
            IC2Items.getItem("smallSulfurDust"));
        thermalCentrifuge(
            "crushedDraconium",
            1960,
            Utils.getItem("DraconicEvolution", "draconiumDust"),
            aobd("dustTinyDraconium"),
            stoneDust);
        thermalCentrifuge(
            "crushedPurifiedDraconium",
            1960,
            Utils.getItem("DraconicEvolution", "draconiumDust"),
            aobd("dustTinyDraconium"));
        thermalCentrifuge(
            "crushedCobalt",
            1180,
            Utils.getItem("galaxymod", "galaxymod_pulverizedcobalt"),
            aobd("dustTinyCobalt"),
            stoneDust);
        thermalCentrifuge(
            "crushedPurifiedCobalt",
            1180,
            Utils.getItem("galaxymod", "galaxymod_pulverizedcobalt"),
            aobd("dustTinyCobalt"));
        thermalCentrifuge("crushedOriharukon", 4020, OriharukonDust.getItem(), aobd("dustTinyOriharukon"), stoneDust);
        thermalCentrifuge("crushedPurifiedOriharukon", 4020, OriharukonDust.getItem(), aobd("dustTinyOriharukon"));
        thermalCentrifuge(
            "crushedMagnesium",
            480,
            ItemDusts.getDustByName("magnesium"),
            ItemDustsSmall.getSmallDustByName("olivine"),
            stoneDust);
        thermalCentrifuge(
            "crushedPurifiedMagnesium",
            480,
            ItemDusts.getDustByName("magnesium"),
            ItemDustsSmall.getSmallDustByName("olivine"));
        thermalCentrifuge("crushedAdamantite", 1960, AdamantiteDust.getItem(), aobd("dustTinyAdamantite"), stoneDust);
        thermalCentrifuge("crushedPurifiedAdamantite", 1960, AdamantiteDust.getItem(), aobd("dustTinyAdamantite"));
        thermalCentrifuge("crushedHeeEndium", 1960, aobd("dustHeeEndium"), aobd("dustTinyHeeEndium"), stoneDust);
        thermalCentrifuge("crushedPurifiedHeeEndium", 1960, aobd("dustHeeEndium"), aobd("dustTinyHeeEndium"));
        thermalCentrifuge("crushedPalladium", 2120, PalladiumDust.getItem(), aobd("dustTinyPalladium"), stoneDust);
        thermalCentrifuge("crushedPurifiedPalladium", 2120, PalladiumDust.getItem(), aobd("dustTinyPalladium"));
        thermalCentrifuge("crushedEuropium", 2120, EuropiumDust.getItem(), aobd("dustTinyEuropium"), stoneDust);
        thermalCentrifuge("crushedPurifiedEuropium", 2120, EuropiumDust.getItem(), aobd("dustTinyEuropium"));
        thermalCentrifuge(
            "crushedPlutonium",
            4920,
            ItemDusts.getDustByName("plutonium"),
            IC2Items.getItem("smallLeadDust"),
            stoneDust);
        thermalCentrifuge(
            "crushedPurifiedPlutonium",
            4920,
            ItemDusts.getDustByName("plutonium"),
            IC2Items.getItem("smallLeadDust"));
        thermalCentrifuge("crushedBismuth", 4160, BismuthDust.getItem(), aobd("dustTinyBismuth"), stoneDust);
        thermalCentrifuge("crushedPurifiedBismuth", 4160, BismuthDust.getItem(), aobd("dustTinyBismuth"));
        thermalCentrifuge(
            "crushedZinc",
            4160,
            Utils.getItem("voltzengine", "veDust", 9),
            IC2Items.getItem("smallTinDust"),
            stoneDust);
        thermalCentrifuge(
            "crushedPurifiedZinc",
            4160,
            Utils.getItem("voltzengine", "veDust", 9),
            IC2Items.getItem("smallTinDust"));
        thermalCentrifuge(
            "crushedMeteoricIron",
            1360,
            MeteoricIronDust.getItem(),
            ItemDustsSmall.getSmallDustByName("nickel"),
            stoneDust);
        thermalCentrifuge(
            "crushedPurifiedMeteoricIron",
            1360,
            MeteoricIronDust.getItem(),
            ItemDustsSmall.getSmallDustByName("nickel"));
    }

    private static void addBlastFurnaceRecipes() {
        hotSmelt(
            ItemCells.getCellByName("silicon"),
            ItemCells.getCellByName("carbon"),
            SiliconCarbideIngot.getItem(),
            null,
            200,
            128,
            2000);
        hotSmelt(
            ItemCells.getCellByName("tungsten"),
            ItemCells.getCellByName("carbon"),
            TungstenCarbideIngot.getItem(),
            null,
            200,
            128,
            1700);
    }

    /******************
     * HELPER METHODS *
     ******************/

    private static void craftShaped(ItemStack output, Object... inputs) {
        GameRegistry.addRecipe(new ShapedOreRecipe(output, inputs));
    }

    private static void craftShapeless(ItemStack output, Object... inputs) {
        GameRegistry.addRecipe(new ShapelessOreRecipe(output, inputs));
    }

    private static void centrifuge(ItemStack input1, ItemStack input2, ItemStack output1, ItemStack output2,
        ItemStack output3, ItemStack output4, int tickTime, int euPerTick) {
        RecipeHandler
            .addRecipe(new CentrifugeRecipe(input1, input2, output1, output2, output3, output4, tickTime, euPerTick));
    }

    private static void fusion(ItemStack topInput, ItemStack bottomInput, ItemStack output, int startEU, int euTick,
        int tickTime) {
        FusionReactorRecipeHelper
            .registerRecipe(new FusionReactorRecipe(topInput, bottomInput, output, startEU, euTick, tickTime));
    }

    private static void macerate(ItemStack input, ItemStack outputs) {
        Recipes.macerator.addRecipe(new RecipeInputItemStack(input), null, outputs);
    }

    private static void macerate(String input, ItemStack output) {
        Recipes.macerator.addRecipe(new RecipeInputOreDict(input), null, output);
    }

    private static void press(ItemStack input, ItemStack outputs) {
        Recipes.metalformerRolling.addRecipe(new RecipeInputItemStack(input), null, outputs);
    }

    private static void compress(ItemStack input, ItemStack output) {
        Recipes.compressor.addRecipe(new RecipeInputItemStack(input), null, output);
    }

    private static void smelt(ItemStack input, ItemStack output) {
        smelt(input, output, 0);
    }

    private static void smelt(ItemStack input, ItemStack output, float xp) {
        GameRegistry.addSmelting(input, output, xp);
    }

    private static void neutroniumCompress(ItemStack output, int amount, String ore, boolean exact) {
        CompressorManager.getRecipes()
            .add(new CompressOreRecipe(output, amount, ore, exact));
    }

    private static void neutroniumCompress(ItemStack output, int amount, ItemStack input, boolean exact) {
        CompressorManager.getRecipes()
            .add(new CompressorRecipe(output, amount, input, exact));
    }

    private static void catalyse(Object ingredient) {
        Grinder.catalyst.getInput()
            .add(ingredient);
    }

    private static void inert(Object ingredient) {
        if (ingredient instanceof ItemStack targetStack) {
            Grinder.catalyst.getInput()
                .removeIf(t -> {
                    if (t instanceof ItemStack trialStack) {
                        return OreDictionary.itemMatches(targetStack, trialStack, false);
                    }
                    return false;
                });
            return;
        }
        Grinder.catalyst.getInput()
            .remove(ingredient);
    }

    private static void craftShapelessXtreme(ItemStack output, Object... ingredients) {
        ExtremeCraftingManager.getInstance()
            .addShapelessOreRecipe(output, ingredients);
    }

    private static void cosmic(ItemStack output, String oreDict) {
        List<ItemStack> input = new ArrayList<>();
        input.add(0, new ItemStack(LudicrousItems.resource, 1, 2));
        input.addAll(1, OreDictionary.getOres(oreDict));
        craftShapelessXtreme(output, input.toArray());
    }

    private static void compressGem(ItemStack dust, ItemStack gem) {
        dust.stackSize = 4;
        gem.stackSize = 3;
        implosionCompress(dust, ic2("industrialTnt", 24), gem, ItemDusts.getDustByName("darkAshes", 12), 20, 32);
    }

    private static void implosionCompress(ItemStack input1, ItemStack input2, ItemStack output1, ItemStack output2,
        int tickTime, int euPerTick) {
        RecipeHandler.addRecipe(new ImplosionCompressorRecipe(input1, input2, output1, output2, tickTime, euPerTick));
    }

    private static void thermalCentrifuge(String input, int heat, ItemStack... outputs) {
        NBTTagCompound metadata = new NBTTagCompound();
        metadata.setInteger("minHeat", heat);
        Recipes.centrifuge.addRecipe(new RecipeInputOreDict(input), metadata, outputs);
    }

    private static void unThermalCentrifuge(ItemStack input) {
        if (input == null) return;
        Recipes.centrifuge.getRecipes()
            .keySet()
            .removeIf(recipeInput -> recipeInput.matches(input));
    }

    private static void block(int meta, String prefix) {
        String suffix = BlockMeta.TYPES[meta];
        craftShaped(new ItemStack(FPSP.blockMeta, 1, meta), "XXX", "XXX", "XXX", 'X', prefix + suffix);
        craftShapeless(OreUtil.getStackFromName(prefix + suffix, 9), "block" + suffix);
    }

    private static void wash(String input, int liquidAmount, ItemStack... outputs) {
        NBTTagCompound metadata = new NBTTagCompound();
        metadata.setInteger("amount", liquidAmount);
        Recipes.oreWashing.addRecipe(new RecipeInputOreDict(input), metadata, outputs);
    }

    private static void washOre(String ore, ItemStack secondary) {
        wash("crushed" + ore, 1000, aobd("crushedPurified" + ore), secondary, IC2Items.getItem("stoneDust"));
    }

    private static void unwash(ItemStack input) {
        if (input == null) return;
        Recipes.oreWashing.getRecipes()
            .keySet()
            .removeIf(recipeInput -> recipeInput.matches(input));
    }

    private static void hotSmelt(ItemStack input1, ItemStack input2, ItemStack output1, ItemStack output2, int tickTime,
        int euPerTick, int neededHeat) {
        RecipeHandler
            .addRecipe(new BlastFurnaceRecipe(input1, input2, output1, output2, tickTime, euPerTick, neededHeat));
    }

    private static ItemStack ic2(String name, int amount) {
        ItemStack stack = IC2Items.getItem(name)
            .copy();
        stack.stackSize = amount;
        return stack;
    }

    private static ItemStack aobd(String name) {
        return aobd(name, 1);
    }

    private static ItemStack aobd(String name, int amount) {
        return GameRegistry.findItemStack("aobd", name, amount);
    }

}
