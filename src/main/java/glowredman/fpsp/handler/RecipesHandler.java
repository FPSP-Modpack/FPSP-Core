package glowredman.fpsp.handler;

import static glowredman.fpsp.item.ItemDefinitions.*;

import cpw.mods.fml.common.registry.GameRegistry;
import galaxyspace.core.register.GSItems;
import glowredman.fpsp.FPSP;
import glowredman.fpsp.Utils;
import ic2.api.item.IC2Items;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.RecipeInputOreDict;
import ic2.api.recipe.Recipes;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.item.ItemStack;
import reborncore.common.util.OreUtil;
import techreborn.api.reactor.FusionReactorRecipe;
import techreborn.api.reactor.FusionReactorRecipeHelper;
import techreborn.api.recipe.RecipeHandler;
import techreborn.api.recipe.machines.CentrifugeRecipe;
import techreborn.api.recipe.machines.ImplosionCompressorRecipe;
import techreborn.items.ItemCells;
import techreborn.items.ItemDusts;

public class RecipesHandler {

	public static void init() {
		addCentrifugeRecipes();
		addFusionRecipes();
		addMaceratorRecipes();
		addSmeltingRecipes();
		addImplosionCompressorRecipes();
	}

	static void addFusionRecipes() {
		fusion(ItemDusts.getDustByName("silver"), ItemCells.getCellByName("helium3"),
				new ItemStack(FPSP.ITEM_CELL, 1, 0), 280000000, 49152, 16);
		fusion(ItemCells.getCellByName("deuterium"), ItemCells.getCellByName("beryllium"),
				new ItemStack(FPSP.ITEM_CELL, 1, 1), 180000000, 16384, 16);
		fusion(ItemDusts.getDustByName("copper"), ItemCells.getCellByName("tritium"),
				new ItemStack(FPSP.ITEM_CELL, 1, 2), 180000000, 49152, 16);
		fusion(IC2Items.getItem("airCell"), ItemDusts.getDustByName("magnesium"), new ItemStack(FPSP.ITEM_CELL, 1, 3),
				120000000, 7680, 128);
		fusion(ItemCells.getCellByName("lithium"), ItemDusts.getDustByName("aluminium"),
				new ItemStack(FPSP.ITEM_CELL, 1, 4), 240000000, 10240, 32);
		fusion(ItemDusts.getDustByName("magnesium"), ItemCells.getCellByName("silicon"),
				new ItemStack(FPSP.ITEM_CELL, 1, 5), 360000000, 7680, 32);
	}

	static void addCentrifugeRecipes() {
		// Moon Rock Dust
		centrifuge(MoonRockDust.getItem(32), null, MeteoricIronDust.getItem(), getIC2Item("copperDust", 2),
				IC2Items.getItem("tinDust"), null, 300, 25);

		// Mars Rock Dust
		centrifuge(MarsRockDust.getItem(32), null, DeshDust.getItem(), getIC2Item("copperDust", 2),
				IC2Items.getItem("tinDust"), getIC2Item("ironDust", 3), 300, 25);

		// Phobos Rock Dust
		centrifuge(PhobosRockDust.getItem(32), null, OreUtil.getStackFromName("dustCoablt", 2),
				getIC2Item("copperDust", 2), IC2Items.getItem("tinDust"), getIC2Item("ironDust", 3), 300, 25);

		// Deimos Rock Dust
		centrifuge(DeimosRockDust.getItem(32), null, OriharukonDust.getItem(), getIC2Item("copperDust", 2),
				IC2Items.getItem("tinDust"), getIC2Item("ironDust", 3), 300, 25);

		// Ceres Rock Dust
		centrifuge(CeresRockDust.getItem(32), null, ItemDusts.getDustByName("tungsten"), getIC2Item("silverDust", 2),
				MeteoricIronDust.getItem(), null, 300, 25);

		// Asteroid Rock Dust
		centrifuge(AsteroidRockDust.getItem(32), null, ItemDusts.getDustByName("aluminium", 2),
				IC2Items.getItem("ironDust"), MeteoricIronDust.getItem(2), new ItemStack(GCItems.basicItem, 1, 2), 300,
				25);

		// Callisto Rock Dust
		centrifuge(CallistoRockDust.getItem(32), null, PalladiumDust.getItem(2),
				OreUtil.getStackFromName("dustCertusQuartz", 4), null, null, 300, 25);

		// Ganymede Rock Dust
		centrifuge(GanymedeRockDust.getItem(32), null, ItemDusts.getDustByName("magnesium", 2),
				getIC2Item("ironDust", 3), ItemDusts.getDustByName("titanium"), null, 300, 25);

		// Europa Dust
		centrifuge(EuropaDust.getItem(32), null, EuropiumDust.getItem(3), null, null, null, 300, 25);

		// Europa Rock Dust
		centrifuge(EuropaRockDust.getItem(32), null, EuropiumDust.getItem(), ItemDusts.getDustByName("peridot"),
				ItemDusts.getDustByName("ruby"), ItemDusts.getDustByName("sapphire"), 300, 25);

		// Io Rock Dust
		centrifuge(IoRockDust.getItem(32), null, MetalMeteoricIronDust.getItem(2), IC2Items.getItem("copperDust"),
				getIC2Item("sulfurDust", 3), ItemDusts.getDustByName("saltpeter"), 300, 25);

		// Io Dust
		centrifuge(IoDust.getItem(32), null, MetalMeteoricIronDust.getItem(4), null, null, null, 300, 25);

		// Mercury Rock Dust
		centrifuge(MercuryRockDust.getItem(32), null, MercurianIronDust.getItem(2), MetallicDust.getItem(2),
				ItemDusts.getDustByName("nickel"), getIC2Item("leadDust", 2), 300, 25);

		// Venus Rock Dust
		centrifuge(VenusRockDust.getItem(32), null, CitrineDust.getItem(), getIC2Item("leadDust", 2),
				getIC2Item("copperDust", 2), IC2Items.getItem("tinDust"), 300, 25);

		// Enceladus Rock Dust
		centrifuge(EnceladusRockDust.getItem(32), null, FrozenIronDust.getItem(2), null, null, null, 300, 25);

		// Enceladus Dust
		centrifuge(EnceladusDust.getItem(32), null, FrozenIronDust.getItem(4), null, null, null, 300, 25);

		// Titan Rock Dust
		centrifuge(TitanRockDust.getItem(32), null, PetaliteDust.getItem(2), RhodiumDust.getItem(2),
				ItemDusts.getDustByName("osmium"), null, 300, 25);

		// Miranda Rock Dust
		centrifuge(MirandaRockDust.getItem(32), null, getIC2Item("ironDust", 3), JadeDust.getItem(2), null, null, 300,
				25);

		// Oberon Rock Dust
		centrifuge(OberonRockDust.getItem(32), null, AdamantiteDust.getItem(2), null, null, null, 300, 25);

		// Proteus Rock Dust
		centrifuge(ProteusRockDust.getItem(32), null, ItemDusts.getDustByName("tungsten", 2),
				ItemDusts.getDustByName("platinum"), null, null, 300, 25);

		// Triton Rock Dust
		centrifuge(TritonRockDust.getItem(32), null, ItemDusts.getDustByName("uranium", 2),
				OreUtil.getStackFromName("dustMithril"), null, null, 300, 25);

		// Vega B Rock Dust
		centrifuge(VegaBRockDust.getItem(32), null, WhiteCrystalDust.getItem(2),
				OreUtil.getStackFromName("dustIridium"), null, null, 300, 25);

		// Pluto Rock Dust
		centrifuge(PlutoRockDust.getItem(32), null, ItemDusts.getDustByName("plutonium", 2), MeteoricIronDust.getItem(),
				Utils.getItems("MorePlanet", "xeonium_dust", 2), FrozenIronDust.getItem(), 300, 25);

		// Pluto Dust
		centrifuge(PlutoDust.getItem(32), null, ItemDusts.getDustByName("plutonium", 3),
				Utils.getItems("MorePlanet", "xeonium_dust", 2), null, null, 300, 25);

		// Kuiper Belt
		centrifuge(DenseIceDust.getItem(32), null, IC2Items.getItem("ironDust"), null, null, null, 300, 25);

		// Haumea Rock Dust
		centrifuge(HaumeaRockDust.getItem(32), null, OnyxDust.getItem(2), AdamantiteDust.getItem(1),
				OriharukonDust.getItem(1), null, 300, 25);

		// Makemake Rock Dust
		centrifuge(MakemakeRockDust.getItem(32), null, BismuthDust.getItem(2), EuropiumDust.getItem(), null, null, 300,
				25);

		// Koentus Rock Dust
		centrifuge(KoentusRockDust.getItem(32), null, MeteoricIronDust.getItem(2), WhiteCrystalDust.getItem(),
				getIC2Item("copperDust", 2), IC2Items.getItem("tinDust"), 300, 25);

		// Koentus Dust
		centrifuge(OberonRockDust.getItem(32), null, MeteoricIronDust.getItem(4), WhiteCrystalDust.getItem(2), null,
				null, 300, 25);

		// Diona Rock Dust
		centrifuge(DionaRockDust.getItem(32), null, QuontoniumDust.getItem(2), FronisiumDust.getItem(2),
				KoentusMeteoricIronDust.getItem(), new ItemStack(GCItems.basicItem, 1, 2), 300, 25);

		// alphaCentauri Bb Rock Dust
		centrifuge(ACentauriBbRockDust.getItem(32), null, CentauriumDust.getItem(2), MetalMeteoricIronDust.getItem(),
				MetallicDust.getItem(), null, 300, 25);

		// Polongnius Rock Dust
		centrifuge(PolongniusRockDust.getItem(32), null, PolongniusMeteoricIronDust.getItem(2), FloniumDust.getItem(2),
				PalladiumDust.getItem(2), IC2Items.getItem("tinDust"), 300, 25);

		// Barnarda C Dust
		centrifuge(BarnardaCDust.getItem(32), null, PinkQuartzDust.getItem(4), IC2Items.getItem("coalDust"), null, null,
				300, 25);

		// Barnarda E Rock Dust
		centrifuge(BarnardaERockDust.getItem(32), null, CarnelianDust.getItem(2), getIC2Item("goldDust", 2),
				getIC2Item("ironDust", 2), null, 300, 25);

		// Barnarda F Rock Dust
		centrifuge(BarnardaFRockDust.getItem(32), null, ChalcedonyDust.getItem(2),
				ItemDusts.getDustByName("plutonium", 2), OreUtil.getStackFromName("dustMithril"), null, 300, 25);

		// Nibiru Rock Dust
		centrifuge(NibiruRockDust.getItem(32), null, RedGemDust.getItem(2), IchoriusDust.getItem(2),
				IC2Items.getItem("ironDust"), null, 300, 25);

		// T Ceti E Rock Dust
		centrifuge(TCetiERockDust.getItem(32), null, NoriumDust.getItem(2), EMPDust.getItem(2),
				ItemDusts.getDustByName("platinum"), IC2Items.getItem("silverDust"), 300, 25);

		// Eden Rock Dust
		centrifuge(EdenRockDust.getItem(32), null, ViriniumDust.getItem(2), DeshDust.getItem(2),
				ItemDusts.getDustByName("aluminium"), MeteoricIronDust.getItem(), 300, 25);

		// Eden Dust
		centrifuge(EdenDust.getItem(32), null, ViriniumDust.getItem(4), IC2Items.getItem("coalDust"), null, null, 300,
				25);

		// Kapteyn B Rock Dust
		centrifuge(KapteynBRockDust.getItem(32), null, NameriumDust.getItem(2), FrozenIronDust.getItem(),
				ItemDusts.getDustByName("uranium"), null, 300, 25);

		// Kapteyn B Dust
		centrifuge(KapteynBDust.getItem(32), null, NameriumDust.getItem(4), ItemDusts.getDustByName("uranium", 2), null,
				null, 300, 25);

		// Fronos Rock Dust
		centrifuge(FronosRockDust.getItem(32), null, OreUtil.getStackFromName("dustIridium"), getIC2Item("goldDust", 2),
				getIC2Item("copperDust", 4), ItemDusts.getDustByName("aluminium", 2), 300, 25);

		// Fronos Dust
		centrifuge(FronosDust.getItem(32), null, OreUtil.getStackFromName("dustIridium", 2),
				IC2Items.getItem("coalDust"), null, null, 300, 25);

		// Kriffon Rock Dust
		centrifuge(KriffonRockDust.getItem(32), null, BlackDiamondDust.getItem(1), RedGemDust.getItem(1),
				OreUtil.getStackFromName("dustCobalt"), ItemDusts.getDustByName("tungsten"), 300, 25);

		// Kriffon Dust
		centrifuge(KriffonDust.getItem(32), null, BlackDiamondDust.getItem(3), RedGemDust.getItem(1), null, null, 300,
				25);

		// Zolrock Dust
		centrifuge(ZolrockDust.getItem(32), null, HeartiumDust.getItem(2), NoriumDust.getItem(1),
				getIC2Item("tinDust", 2), getIC2Item("copperDust", 3), 300, 25);

		// Zollus Dust
		centrifuge(ZollusDust.getItem(32), null, NoriumDust.getItem(1), HeartiumDust.getItem(3), null, null, 300, 25);

		// Sirius B Rock Dust
		centrifuge(SiriusBRockDust.getItem(32), null, getIC2Item("sulfurDust", 4),
				ItemDusts.getDustByName("diamond", 2), ItemDusts.getDustByName("tungsten", 2), null, 300, 25);

		// Oasis Rock Dust
		centrifuge(OasisRockDust.getItem(32), null, getIC2Item("silverDust", 3), ItemDusts.getDustByName("titanium", 2),
				null, null, 300, 25);

		// Oasis Dust
		centrifuge(OasisDust.getItem(32), null, ItemDusts.getDustByName("titanium"), getIC2Item("silverDust", 2),
				getIC2Item("sulfurDust", 3), ItemDusts.getDustByName("saltpeter"), 300, 25);

		// Xathian Rock Dust
		centrifuge(XathianRockDust.getItem(32), null, XathianPrometheanDust.getItem(3),
				ItemDusts.getDustByName("platinum", 2), ItemDusts.getDustByName("osmium", 2), null, 300, 25);

		// Xathian Dust
		centrifuge(XathianDust.getItem(32), null, XathianPrometheanDust.getItem(5), null, null, null, 300, 25);

		// Purgot Rock Dust
		centrifuge(PurgotRockDust.getItem(32), null, EveniumDust.getItem(3), ViriniumDust.getItem(2),
				OreUtil.getStackFromName("dustCobalt"), null, 300, 25);

		// Purgot Dust
		centrifuge(PurgotDust.getItem(32), null, EveniumDust.getItem(5), null, null, null, 300, 25);

		// Neper Dust
		centrifuge(NeperDust.getItem(32), null, PurpleGemDust.getItem(4), ItemDusts.getDustByName("diamond", 2),
				ItemDusts.getDustByName("emerald", 2), null, 300, 25);

		// Maahes Dust
		centrifuge(MaahesDust.getItem(32), null, getIC2Item("coalDust", 5), ItemDusts.getDustByName("aluminium", 2),
				getIC2Item("ironDust", 4), Utils.getItems("MorePlanet", "xeonium_dust", 3), 300, 25);

		// Basalt Rock Dust Anubis
		centrifuge(BasaltRockDust.getItem(32), null, ChioniteDust.getItem(2), ItemDusts.getDustByName("uranium", 2),
				null, null, 300, 25);

		// Basalt Dust Anubis
		centrifuge(BasaltDust.getItem(32), null, ChioniteDust.getItem(4), ItemDusts.getDustByName("uranium", 4), null,
				null, 300, 25);

		// Obsidian Sand Dust Horus
		centrifuge(ObsidianSandDust.getItem(32), null, ItemDusts.getDustByName("diamond"),
				ItemDusts.getDustByName("emerald"), getIC2Item("obsidianDust", 6), null, 300, 25);

		// Coral Rock Seth
		centrifuge(CoralDust.getItem(32), null, BacterialFossilDust.getItem(6), null, null, null, 300, 25);

		// Dark Asteroid Rock Dust
		centrifuge(DarkAsteroidRockDust.getItem(32), null, AlphereDust.getItem(2),
				ItemDusts.getDustByName("diamond", 2), OreUtil.getStackFromName("dustIridium", 3),
				OreUtil.getStackFromName("dustDraconium", 2), 300, 25);

		// Dark Asteroid Dust
		centrifuge(DarkAsteroidDust.getItem(32), null, AlphereDust.getItem(4),
				OreUtil.getStackFromName("dustIridium", 4), OreUtil.getStackFromName("dustDraconium", 4), null, 300,
				25);
	}

	static void addMaceratorRecipes() {
		// Moon
		macerate(Utils.getItem("GalacticraftCore", "tile.moonBlock", 3), MoonDust.getItem());
		macerate(Utils.getItem("GalacticraftCore", "tile.moonBlock", 4), MoonRockDust.getItem());
		macerate(Utils.getItem("GalacticraftCore", "tile.moonBlock", 5), MoonDust.getItem());
		macerate(Utils.getItem("GalacticraftCore", "tile.moonBlock", 14), MoonRockDust.getItem(2));

		// Mars
		macerate(Utils.getItem("GalacticraftMars", "tile.mars", 4), MarsRockDust.getItem());
		macerate(Utils.getItem("GalacticraftMars", "tile.mars", 5), MarsRockDust.getItem());
		macerate(Utils.getItem("GalacticraftMars", "tile.mars", 6), MarsRockDust.getItem());
		macerate(Utils.getItem("GalacticraftMars", "tile.mars", 7), MarsRockDust.getItem(2));
		macerate(Utils.getItem("GalacticraftMars", "tile.mars", 9), MarsRockDust.getItem());

		// Phobos
		macerate(Utils.getItem("GalaxySpace", "phobosblocks"), PhobosRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "phobosblocks", 1), PhobosRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "phobosblocks", 2), PhobosRockDust.getItem());

		// Phobos
		macerate(Utils.getItem("GalaxySpace", "deimosblocks"), DeimosRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "deimosblocks", 1), DeimosRockDust.getItem());

		// Ceres
		macerate(Utils.getItem("GalaxySpace", "ceresblocks"), CeresRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "ceresblocks", 1), CeresRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "ceresblocks", 2), CeresRockDust.getItem(2));
		macerate(Utils.getItem("GalaxySpace", "ceresblocks", 4), CeresRockDust.getItem(2));
		macerate(Utils.getItem("GalaxySpace", "ceresblocks", 5), CeresRockDust.getItem(2));

		// Asteroids
		macerate(Utils.getItem("GalacticraftMars", "tile.asteroidsBlock"), AsteroidRockDust.getItem());
		macerate(Utils.getItem("GalacticraftMars", "tile.asteroidsBlock", 1), AsteroidRockDust.getItem());
		macerate(Utils.getItem("GalacticraftMars", "tile.asteroidsBlock", 2), AsteroidRockDust.getItem());

		// Callisto
		macerate(Utils.getItem("GalaxySpace", "callistoblocks"), CallistoRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "callistoblocks", 1), CallistoRockDust.getItem());

		// Europa
		macerate(Utils.getItem("GalaxySpace", "europagrunt"), EuropaRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "europagrunt", 1), EuropaDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "europageyser"), EuropaRockDust.getItem(8));
		macerate(Utils.getItem("GalaxySpace", "europaunderwatergeyser"), EuropaDust.getItem(8));

		// Io
		macerate(Utils.getItem("GalaxySpace", "ioblocks"), IoRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "ioblocks", 1), IoDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "ioblocks", 2), IoRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "ioblocks", 3), IoRockDust.getItem(2));
		macerate(Utils.getItem("GalaxySpace", "ioblocks", 7), IoRockDust.getItem(2));
		macerate(Utils.getItem("GalaxySpace", "ioblocks", 8), IoRockDust.getItem(2));
		macerate(Utils.getItem("GalaxySpace", "iodualstone"), IoRockDust.getItem(2));

		// Mercury
		macerate(Utils.getItem("GalaxySpace", "mercuryblocks"), MercuryRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "mercuryblocks", 1), MercuryRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "mercuryblocks", 2), MercuryRockDust.getItem());

		// Venus
		macerate(Utils.getItem("GalaxySpace", "venusblocks"), VenusRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "venusblocks", 1), VenusRockDust.getItem());

		// Enceladus
		macerate(Utils.getItem("GalaxySpace", "enceladusblocks"), EnceladusDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "enceladusblocks", 1), EnceladusRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "enceladusblocks", 2), EnceladusRockDust.getItem(2));
		macerate(Utils.getItem("GalaxySpace", "enceladusblocks", 3), EnceladusDust.getItem());

		// Titan
		macerate(Utils.getItem("GalaxySpace", "titanblocks"), TitanRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "titanblocks", 1), TitanRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "titanblocks", 2), TitanRockDust.getItem());

		// Miranda
		macerate(Utils.getItem("GalaxySpace", "mirandablocks"), MirandaRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "mirandablocks", 1), MirandaRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "mirandablocks", 2), MirandaRockDust.getItem());

		// Oberon
		macerate(Utils.getItem("GalaxySpace", "oberonblocks"), OberonRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "oberonblocks", 1), OberonRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "oberonblocks", 2), OberonRockDust.getItem());

		// Proteus
		macerate(Utils.getItem("GalaxySpace", "proteusblocks"), ProteusRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "proteusblocks", 1), ProteusRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "proteusblocks", 2), ProteusRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "proteusblocks", 3), ProteusRockDust.getItem(2));

		// Triton
		macerate(Utils.getItem("GalaxySpace", "tritonblocks"), TritonRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "tritonblocks", 1), TritonRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "tritonblocks", 2), TritonRockDust.getItem());

		// Vega B
		macerate(Utils.getItem("GalaxySpace", "vegabgrunt"), VegaBRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "vegabsubgrunt"), VegaBRockDust.getItem());

		// Pluto
		macerate(Utils.getItem("GalaxySpace", "plutoblocks"), PlutoDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "plutoblocks", 1), PlutoDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "plutoblocks", 2), PlutoDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "plutoblocks", 3), PlutoDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "plutoblocks", 4), PlutoDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "plutoblocks", 5), PlutoRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "plutoblocks", 6), PlutoRockDust.getItem(2));

		// Kuiper Belt
		macerate(Utils.getItem("GalacticraftMars", "tile.denseIce"), DenseIceDust.getItem());

		// Haumea
		macerate(Utils.getItem("GalaxySpace", "haumeablocks"), HaumeaRockDust.getItem());

		// Haumea
		macerate(Utils.getItem("GalaxySpace", "makemakegrunt"), MakemakeRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "makemakegrunt", 1), MakemakeRockDust.getItem());

		// Koentus
		macerate(Utils.getItem("MorePlanet", "koentus_ice"), KoentusDust.getItem());
		macerate(Utils.getItem("MorePlanet", "koentus_ice", 1), KoentusDust.getItem(2));
		macerate(Utils.getItem("MorePlanet", "space_mossy_cobblestone", 3), KoentusRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "koentus_block"), KoentusRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "koentus_block", 1), KoentusRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "koentus_block", 2), KoentusRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "koentus_block", 3), KoentusRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "koentus_block", 11), KoentusRockDust.getItem(2));
		macerate(Utils.getItem("MorePlanet", "koentus_block", 12), KoentusRockDust.getItem(2));
		macerate(Utils.getItem("MorePlanet", "koentus_block", 13), KoentusRockDust.getItem(2));

		// Diona
		macerate(Utils.getItem("MorePlanet", "space_mossy_cobblestone"), DionaRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "diona_block"), DionaRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "diona_block", 1), DionaRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "diona_block", 2), DionaRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "diona_block", 3), DionaRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "diona_block", 14), DionaRockDust.getItem(2));

		// aCentauri Bb
		macerate(Utils.getItem("GalaxySpace", "acentauribbgrunt"), ACentauriBbRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "acentauribbsubgrunt"), ACentauriBbRockDust.getItem());

		// Polongnius
		macerate(Utils.getItem("MorePlanet", "space_mossy_cobblestone", 1), PolongniusRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "polongnius_block", 2), PolongniusRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "polongnius_block", 3), PolongniusRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "polongnius_block", 13), PolongniusRockDust.getItem(2));
		macerate(Utils.getItem("MorePlanet", "polongnius_block", 14), PolongniusRockDust.getItem(4));

		// Barnarda C
		macerate(Utils.getItem("GalaxySpace", "barnardaCgrass"), BarnardaCDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "barnardaCdirt"), BarnardaCDust.getItem());

		// Barnarda E
		macerate(Utils.getItem("GalaxySpace", "barnardaEgrunt"), BarnardaERockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "barnardaEsubgrunt"), BarnardaERockDust.getItem());

		// Barnarda F
		macerate(Utils.getItem("GalaxySpace", "barnardaFgrunt"), BarnardaFRockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "barnardaFsubgrunt"), BarnardaFRockDust.getItem());

		// Nibiru
		macerate(Utils.getItem("MorePlanet", "space_mossy_cobblestone", 2), NibiruRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "nibiru_block"), NibiruRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "nibiru_block", 1), NibiruRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "nibiru_block", 2), NibiruRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "nibiru_block", 3), NibiruRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "nibiru_block", 12), NibiruRockDust.getItem(2));

		// T Ceti E
		macerate(Utils.getItem("GalaxySpace", "tcetieblocks"), TCetiERockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "tcetieblocks", 1), TCetiERockDust.getItem());
		macerate(Utils.getItem("GalaxySpace", "tcetieblocks", 2), TCetiERockDust.getItem());

		// Eden
		macerate(Utils.getItem("galaxymod", "galaxymod_edencobblerock"), EdenRockDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_edenrock"), EdenRockDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_edenrockbricks"), EdenRockDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_edensurfaceblock"), EdenRockDust.getItem(2));
		macerate(Utils.getItem("galaxymod", "galaxymod_edensoil"), EdenDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_edengrass"), EdenDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_edengoldengrass"), EdenDust.getItem(4));
		macerate(Utils.getItem("galaxymod", "galaxymod_bloodsand"), EdenDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_edenwinterrock"), EdenRockDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_bonestone"), EdenRockDust.getItem(2));
		macerate(Utils.getItem("galaxymod", "galaxymod_edengravel"), EdenDust.getItem(2));
		macerate(Utils.getItem("galaxymod", "galaxymod_bloodstone"), EdenRockDust.getItem(4));
		macerate(Utils.getItem("galaxymod", "galaxymod_edensacredstone"), EdenRockDust.getItem(4));

		// Kapteyn B
		macerate(Utils.getItem("MorePlanet", "space_mossy_cobblestone", 4), KapteynBRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "kapteyn-b_block"), KapteynBDust.getItem());
		macerate(Utils.getItem("MorePlanet", "kapteyn-b_block", 1), KapteynBDust.getItem());
		macerate(Utils.getItem("MorePlanet", "kapteyn-b_block", 2), KapteynBRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "kapteyn-b_block", 3), KapteynBRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "kapteyn-b_block", 14), KapteynBRockDust.getItem(2));
		macerate(Utils.getItem("MorePlanet", "kapteyn-b_ice"), KapteynBDust.getItem());
		macerate(Utils.getItem("MorePlanet", "kapteyn-b_ice", 1), KapteynBDust.getItem());

		// Fronos
		macerate(Utils.getItem("MorePlanet", "fronos_dirt"), FronosDust.getItem());
		macerate(Utils.getItem("MorePlanet", "fronos_dirt", 1), FronosDust.getItem());
		macerate(Utils.getItem("MorePlanet", "fronos_grass"), FronosDust.getItem());
		macerate(Utils.getItem("MorePlanet", "fronos_sand"), FronosDust.getItem());
		macerate(Utils.getItem("MorePlanet", "fronos_sandstone"), FronosDust.getItem());
		macerate(Utils.getItem("MorePlanet", "fronos_sandstone", 1), FronosDust.getItem());
		macerate(Utils.getItem("MorePlanet", "fronos_sandstone", 2), FronosDust.getItem(2));
		macerate(Utils.getItem("MorePlanet", "fronos_block"), FronosRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "fronos_block", 1), FronosRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "fronos_block", 11), FronosRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "fronos_block", 12), FronosRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "fronos_block", 13), FronosRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "fronos_block", 14), FronosRockDust.getItem(2));
		macerate(Utils.getItem("MorePlanet", "mossy_fronos_cobblestone"), FronosRockDust.getItem());

		// Eden
		macerate(Utils.getItem("galaxymod", "galaxymod_zoldirt"), ZollusDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_zolrockbricks"), ZolrockDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_solarblock"), ZolrockDust.getItem(2));
		macerate(Utils.getItem("galaxymod", "galaxymod_zolcobblerock"), ZolrockDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_zolstone"), ZolrockDust.getItem());

		// Sirius B
		macerate(Utils.getItem("MorePlanet", "space_mossy_cobblestone", 5), SiriusBRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "sirius_block"), SiriusBRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "sirius_block", 1), SiriusBRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "sirius_block", 2), SiriusBRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "sirius_block", 3), SiriusBRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "sirius_block", 7), SiriusBRockDust.getItem(4));
		macerate(Utils.getItem("MorePlanet", "sirius_block", 9), SiriusBRockDust.getItem(2));

		// Oasis
		macerate(Utils.getItem("galaxymod", "galaxymod_oasisgrass"), OasisDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_oasisdirt"), OasisDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_oasiscobblerock"), OasisRockDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_oasisrock"), OasisRockDust.getItem());

		// Xathius
		macerate(Utils.getItem("galaxymod", "galaxymod_xathgrass"), XathianDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_xathdirt"), XathianDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_xathstone"), XathianRockDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_xathrock"), XathianRockDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_xathcobblerock"), XathianRockDust.getItem());

		// Purgot
		macerate(Utils.getItem("galaxymod", "galaxymod_purgdirt"), PurgotDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_purgcobblerock"), PurgotRockDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_purgstone"), PurgotRockDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_purgrock"), PurgotRockDust.getItem());
		macerate(Utils.getItem("galaxymod", "galaxymod_purgrockbricks"), PurgotRockDust.getItem());

		// Neper
		macerate(Utils.getItem("GalacticraftAmunRa", "tile.baseBlockRock", 10), NeperDust.getItem());

		// Maahes
		macerate(Utils.getItem("GalacticraftAmunRa", "tile.wood1", 1), MaahesDust.getItem());

		// Anubis
		macerate(Utils.getItem("GalacticraftAmunRa", "tile.baseBlockRock", 1), BasaltRockDust.getItem());
		macerate(Utils.getItem("GalacticraftAmunRa", "tile.baseBlockGround", 1), BasaltDust.getItem());
		macerate(Utils.getItem("GalacticraftAmunRa", "tile.baseFalling", 2), BasaltDust.getItem());

		// Horus
		macerate(Utils.getItem("GalacticraftAmunRa", "tile.baseFalling"), ObsidianSandDust.getItem());
		macerate(Utils.getItem("GalacticraftAmunRa", "tile.baseFalling", 1), ObsidianSandDust.getItem());

		// Seth
		macerate(Utils.getItem("GalacticraftAmunRa", "tile.baseBlockCrystal"), CoralDust.getItem(2));

		// Dark Asteroids
		macerate(Utils.getItem("MorePlanet", "dark_asteroid_block"), DarkAsteroidRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "dark_asteroid_block", 1), DarkAsteroidRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "dark_asteroid_block", 2), DarkAsteroidRockDust.getItem());
		macerate(Utils.getItem("MorePlanet", "dark_asteroid_quicksand"), DarkAsteroidDust.getItem());
	}

	static void addSmeltingRecipes() {
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
		smelt(PolongniusMeteoricIronDust.getItem(), Utils.getItem("MorePlanet", "polongnius_item", 4));
		smelt(ViriniumDust.getItem(), Utils.getItem("galaxymod", "galaxymod_ingotviri"));
		smelt(EveniumDust.getItem(), Utils.getItem("galaxymod", "galaxymod_ingotevenium"));
	}

	static void addImplosionCompressorRecipes() {
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
		compressGem(NoriumDust.getItem(), Utils.getItem("MorePlanet", "nibiru_item", 1));
		compressGem(NameriumDust.getItem(), Utils.getItem("MorePlanet", "namerium_crystal"));
		compressGem(BlackDiamondDust.getItem(), Utils.getItem("MorePlanet", "fronos_item", 2));
		compressGem(HeartiumDust.getItem(), Utils.getItem("galaxymod", "galaxymod_heartofzol"));
		compressGem(XathianPrometheanDust.getItem(), Utils.getItem("galaxymod", "galaxymod_prometheancrystal"));
		compressGem(ChioniteDust.getItem(), Utils.getItem("GalacticraftAmunRa", "item.baseItem", 3));
		compressGem(AlphereDust.getItem(), Utils.getItem("MorePlanet", "alphere"));
	}

	/******************
	 * HELPER METHODS *
	 ******************/

	private static void centrifuge(ItemStack input1, ItemStack input2, ItemStack output1, ItemStack output2,
			ItemStack output3, ItemStack output4, int tickTime, int euPerTick) {
		RecipeHandler.addRecipe(
				new CentrifugeRecipe(input1, input2, output1, output2, output3, output4, tickTime, euPerTick));
	}

	private static void fusion(ItemStack topInput, ItemStack bottomInput, ItemStack output, int startEU, int euTick,
			int tickTime) {
		FusionReactorRecipeHelper
				.registerRecipe(new FusionReactorRecipe(topInput, bottomInput, output, startEU, euTick, tickTime));
	}

	private static void macerate(ItemStack input, ItemStack outputs) {
		Recipes.macerator.addRecipe(new RecipeInputItemStack(input), null, outputs);
	}

	private static void macerate(String oreDictInputnput, ItemStack outputs) {
		Recipes.macerator.addRecipe(new RecipeInputOreDict(oreDictInputnput), null, outputs);
	}

	private static void macerate(String oreDictInputnput, int inputAmount, ItemStack outputs) {
		Recipes.macerator.addRecipe(new RecipeInputOreDict(oreDictInputnput, inputAmount), null, outputs);
	}

	private static void smelt(ItemStack input, ItemStack output) {
		GameRegistry.addSmelting(input, output, 0);
	}

	private static void smelt(ItemStack input, ItemStack output, float xp) {
		GameRegistry.addSmelting(input, output, xp);
	}

	private static void compressGem(ItemStack dust, ItemStack gem) {
		dust.stackSize = 4;
		gem.stackSize = 3;
		implosionCompress(dust, getIC2Item("industrialTnt", 24), gem, ItemDusts.getDustByName("darkAsh", 12), 20, 32);
	}

	private static void implosionCompress(ItemStack input1, ItemStack input2, ItemStack output1, ItemStack output2,
			int tickTime, int euPerTick) {
		RecipeHandler.addRecipe(new ImplosionCompressorRecipe(input1, input2, output1, output2, tickTime, euPerTick));
	}

	private static ItemStack getIC2Item(String name, int amount) {
		ItemStack stack = IC2Items.getItem(name).copy();
		stack.stackSize = amount;
		return stack;
	}

}
