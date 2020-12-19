package glowredman.fpsp;

import static glowredman.fpsp.item.ItemDefinitions.*;

import galaxyspace.core.recipe.RecipeUtilGS;
import net.minecraft.item.ItemStack;
import techreborn.api.recipe.machines.CentrifugeRecipe;

public class RecipeHandler {

	public static void init() {

		// Dust Recipes

		// Moon Rock Dust
		addCentrifugeRecipe(MoonRockDust.getItem(32), null, MeteoricIronDust.getItem(),
				RecipeUtilGS.getItem("IC2", "itemDust", 3, 2), RecipeUtilGS.getItem("IC2", "itemDust", 7), null, 300,
				25);

		// Mars Rock Dust
		addCentrifugeRecipe(MarsRockDust.getItem(32), null, DeshDust.getItem(),
				RecipeUtilGS.getItem("IC2", "itemDust", 3, 2), RecipeUtilGS.getItem("IC2", "itemDust", 7),
				RecipeUtilGS.getItem("IC2", "itemDust", 5, 3), 300, 25);

		// Phobos Rock Dust
		addCentrifugeRecipe(PhobosRockDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 20, 2),
				RecipeUtilGS.getItem("IC2", "itemDust", 3, 2), RecipeUtilGS.getItem("IC2", "itemDust", 7),
				RecipeUtilGS.getItem("IC2", "itemDust", 5, 3), 300, 25);

		// Deimos Rock Dust
		addCentrifugeRecipe(DeimosRockDust.getItem(32), null, OriharukonDust.getItem(),
				RecipeUtilGS.getItem("IC2", "itemDust", 3, 2), RecipeUtilGS.getItem("IC2", "itemDust", 7),
				RecipeUtilGS.getItem("IC2", "itemDust", 5, 3), 300, 25);

		// Ceres Rock Dust
		addCentrifugeRecipe(CeresRockDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 81),
				RecipeUtilGS.getItem("IC2", "itemDust", 6, 2), MeteoricIronDust.getItem(), null, 300, 25);

		// Asteroid Rock Dust
		addCentrifugeRecipe(AsteroidRockDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 2, 2),
				RecipeUtilGS.getItem("IC2", "itemDust", 5), MeteoricIronDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 69), 300, 25);

		// Callisto Rock Dust
		addCentrifugeRecipe(CallistoRockDust.getItem(32), null, PalladiumDust.getItem(2), null, null, null, 300, 25);

		// Ganymede Rock Dust
		addCentrifugeRecipe(GanymedeRockDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 46, 2),
				RecipeUtilGS.getItem("IC2", "itemDust", 5, 3), RecipeUtilGS.getItem("techreborn", "dust", 80), null,
				300, 25);

		// Europa Dust
		addCentrifugeRecipe(EuropaDust.getItem(32), null, EuropiumDust.getItem(3), null, null, null, 300, 25);

		// Europa Rock Dust
		addCentrifugeRecipe(EuropaRockDust.getItem(32), null, EuropiumDust.getItem(),
				RecipeUtilGS.getItem("techreborn", "dust", 57), RecipeUtilGS.getItem("techreborn", "dust", 65),
				RecipeUtilGS.getItem("techreborn", "dust", 67), 300, 25);

		// Io Rock Dust
		addCentrifugeRecipe(IoRockDust.getItem(32), null, MetalMeteoricIronDust.getItem(2),
				RecipeUtilGS.getItem("IC2", "itemDust", 3), RecipeUtilGS.getItem("IC2", "itemDust", 13, 3),
				RecipeUtilGS.getItem("techreborn", "dust", 66), 300, 25);

		// Mercury Rock Dust
		addCentrifugeRecipe(MercuryRockDust.getItem(32), null, MercurianIronDust.getItem(2), MetallicDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 54), RecipeUtilGS.getItem("IC2", "itemDust", 10, 2), 300,
				25);

		// Venus Dust
		addCentrifugeRecipe(VenusDust.getItem(32), null, CitrineDust.getItem(4),
				RecipeUtilGS.getItem("IC2", "itemDust", 2), null, null, 300, 25);

		// Venus Rock Dust
		addCentrifugeRecipe(VenusRockDust.getItem(32), null, CitrineDust.getItem(),
				RecipeUtilGS.getItem("IC2", "itemDust", 10, 2), RecipeUtilGS.getItem("IC2", "itemDust", 3, 2),
				RecipeUtilGS.getItem("IC2", "itemDust", 7), 300, 25);

		// Enceladus Rock Dust
		addCentrifugeRecipe(EnceladusRockDust.getItem(32), null, FrozenIronDust.getItem(2), null, null, null, 300, 25);

		// Titan Rock Dust
		addCentrifugeRecipe(TitanRockDust.getItem(32), null, PetaliteDust.getItem(2), RhodiumDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 56), null, 300, 25);

		// Miranda Rock Dust
		addCentrifugeRecipe(MirandaRockDust.getItem(32), null, RecipeUtilGS.getItem("IC2", "itemDust", 5, 3),
				JadeDust.getItem(2), null, null, 300, 25);

		// Oberon Rock Dust
		addCentrifugeRecipe(OberonRockDust.getItem(32), null, AdamantiteDust.getItem(2), null, null, null, 300, 25);

		// Proteus Rock Dust
		addCentrifugeRecipe(ProteusRockDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 81, 2),
				RecipeUtilGS.getItem("techreborn", "dust", 59), null, null, 300, 25);

		// Triton Rock Dust
		addCentrifugeRecipe(TritonRockDust.getItem(32), null, UraniumDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 51), null, null, 300, 25);

		// Vega B Rock Dust
		addCentrifugeRecipe(VegaBRockDust.getItem(32), null, WhiteCrystalDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 38), null, null, 300, 25);

		// Pluto Rock Dust
		addCentrifugeRecipe(PlutoRockDust.getItem(32), null, PlutoniumDust.getItem(2), MeteoricIronDust.getItem(),
				XeoniumDust.getItem(2), FrozenIronDust.getItem(), 300, 25);

		// Kuiper Belt
		addCentrifugeRecipe(DenseIceDust.getItem(32), null, RecipeUtilGS.getItem("IC2", "itemDust", 5), null, null,
				null, 300, 25);

		// Haumea Rock Dust
		addCentrifugeRecipe(HaumeaRockDust.getItem(32), null, OnyxDust.getItem(2), AdamantiteDust.getItem(1),
				OriharukonDust.getItem(1), null, 300, 25);

		// Makemake Rock Dust
		addCentrifugeRecipe(MakemakeRockDust.getItem(32), null, BismuthDust.getItem(2), EuropiumDust.getItem(), null,
				null, 300, 25);

		// Koentus Rock Dust
		addCentrifugeRecipe(KoentusRockDust.getItem(32), null, KoentusMeteoricIronDust.getItem(2),
				WhiteCrystalDust.getItem(), RecipeUtilGS.getItem("IC2", "itemDust", 3, 2),
				RecipeUtilGS.getItem("IC2", "itemDust", 7), 300, 25);

		// Diona Rock Dust
		addCentrifugeRecipe(DionaRockDust.getItem(32), null, QuontoniumDust.getItem(2), FronisiumDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 2), RecipeUtilGS.getItem("techreborn", "dust", 69), 300, 25);

		// alphaCentauri Bb Rock Dust
		addCentrifugeRecipe(aCentauriBbRockDust.getItem(32), null, CentauriumDust.getItem(2),
				MetalMeteoricIronDust.getItem(), MetallicDust.getItem(), null, 300, 25);

		// Polongius Rock Dust
		addCentrifugeRecipe(PolongiusRockDust.getItem(32), null, PolongiusMeteoricIronDust.getItem(2),
				FloniumDust.getItem(2), PalladiumDust.getItem(2), RecipeUtilGS.getItem("IC2", "itemDust", 7), 300, 25);

		// Barnarda C Dust
		addCentrifugeRecipe(BarnardaCDust.getItem(32), null, PinkQuartzDust.getItem(4),
				RecipeUtilGS.getItem("IC2", "itemDust", 2), null, null, 300, 25);

		// Barnarda E Rock Dust
		addCentrifugeRecipe(BarnardaERockDust.getItem(32), null, CarnelianDust.getItem(2),
				RecipeUtilGS.getItem("IC2", "itemDust", 4, 2), RecipeUtilGS.getItem("IC2", "itemDust", 5, 2), null, 300,
				25);

		// Barnarda F Rock Dust
		addCentrifugeRecipe(BarnardaFRockDust.getItem(32), null, ChalcedonyDust.getItem(2), PlutoniumDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 51), null, 300, 25);

		// Nibiru Rock Dust
		addCentrifugeRecipe(NibiruRockDust.getItem(32), null, RedGemDust.getItem(2), IchoriusDust.getItem(2),
				RecipeUtilGS.getItem("IC2", "itemDust", 5), null, 300, 25);

		// T Ceti E Rock Dust
		addCentrifugeRecipe(TCetiERockDust.getItem(32), null, NoriumDust.getItem(2), EMPDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 59), RecipeUtilGS.getItem("IC2", "itemDust", 6), 300, 25);

		// Eden Rock Dust
		addCentrifugeRecipe(EdenRockDust.getItem(32), null, ViriniumDust.getItem(2), DeshDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 2), MeteoricIronDust.getItem(), 300, 25);

		// Eden Dust
		addCentrifugeRecipe(EdenDust.getItem(32), null, ViriniumDust.getItem(4),
				RecipeUtilGS.getItem("IC2", "itemDust", 2), null, null, 300, 25);

		// Kapteyn B Rock Dust
		addCentrifugeRecipe(KapteynBRockDust.getItem(32), null, NameriumDust.getItem(2), FrozenIronDust.getItem(),
				UraniumDust.getItem(), null, 300, 25);

		// Fronos Rock Dust
		addCentrifugeRecipe(FronosRockDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 38),
				RecipeUtilGS.getItem("IC2", "itemDust", 4, 2), RecipeUtilGS.getItem("IC2", "itemDust", 3, 4),
				RecipeUtilGS.getItem("techreborn", "dust", 2, 2), 300, 25);

		// Fronos Dust
		addCentrifugeRecipe(FronosDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 38, 2),
				RecipeUtilGS.getItem("IC2", "itemDust", 2), null, null, 300, 25);

		// Kriffon Rock Dust
		addCentrifugeRecipe(KriffonRockDust.getItem(32), null, BlackDiamondDust.getItem(1), RedGemDust.getItem(1),
				RecipeUtilGS.getItem("techreborn", "dust", 20), RecipeUtilGS.getItem("techreborn", "dust", 81), 300,
				25);

		// Kriffon Dust
		addCentrifugeRecipe(KriffonDust.getItem(32), null, BlackDiamondDust.getItem(3), RedGemDust.getItem(1), null,
				null, 300, 25);

		// Zolrock Dust
		addCentrifugeRecipe(ZolrockDust.getItem(32), null, HeatiumDust.getItem(2), NoriumDust.getItem(1),
				RecipeUtilGS.getItem("IC2", "itemDust", 7, 2), RecipeUtilGS.getItem("IC2", "itemDust", 3, 3), 300, 25);

		// Zollus Dust
		addCentrifugeRecipe(ZollusDust.getItem(32), null, NoriumDust.getItem(1), HeatiumDust.getItem(3), null, null,
				300, 25);

		// Sirius B Rock Dust
		addCentrifugeRecipe(SiriusBRockDust.getItem(32), null, RecipeUtilGS.getItem("IC2", "itemDust", 13, 4),
				RecipeUtilGS.getItem("techreborn", "dust", 25, 2), RecipeUtilGS.getItem("techreborn", "dust", 81, 2),
				null, 300, 25);

		// Oasis Rock Dust
		addCentrifugeRecipe(OasisRockDust.getItem(32), null, RecipeUtilGS.getItem("IC2", "itemDust", 6, 3),
				RecipeUtilGS.getItem("techreborn", "dust", 80, 2), null, null, 300, 25);

		// Oasis Dust
		addCentrifugeRecipe(OasisDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 80),
				RecipeUtilGS.getItem("IC2", "itemDust", 6, 2), RecipeUtilGS.getItem("IC2", "itemDust", 13, 3),
				RecipeUtilGS.getItem("techreborn", "dust", 66), 300, 25);

		// Xathian Rock Dust
		addCentrifugeRecipe(XathianRockDust.getItem(32), null, XathiumDust.getItem(3),
				RecipeUtilGS.getItem("techreborn", "dust", 59, 2), RecipeUtilGS.getItem("techreborn", "dust", 56, 2),
				null, 300, 25);

		// Xathian Dust
		addCentrifugeRecipe(XathianDust.getItem(32), null, XathiumDust.getItem(5), null, null, null, 300, 25);

		// Purgot Rock Dust
		addCentrifugeRecipe(PurgotRockDust.getItem(32), null, EveniumDust.getItem(3), ViriniumDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 20), null, 300, 25);

		// Purgot Dust
		addCentrifugeRecipe(PurgotDust.getItem(32), null, EveniumDust.getItem(5), null, null, null, 300, 25);

		// Neper Dust
		addCentrifugeRecipe(NeperDust.getItem(32), null, PurpleGemDust.getItem(4),
				RecipeUtilGS.getItem("techreborn", "dust", 25, 2), RecipeUtilGS.getItem("techreborn", "dust", 27, 2),
				null, 300, 25);

		// Maahes Dust
		addCentrifugeRecipe(MaahesDust.getItem(32), null, RecipeUtilGS.getItem("IC2", "itemDust", 2, 5),
				RecipeUtilGS.getItem("techreborn", "dust", 2, 2), RecipeUtilGS.getItem("IC2", "itemDust", 5, 4),
				XeoniumDust.getItem(3), 300, 25);

		// Basalt Rock Dust Anubis
		addCentrifugeRecipe(BasaltRockDust.getItem(32), null, ChioniteDust.getItem(3), UraniumDust.getItem(2), null,
				null, 300, 25);

		// Obsidian Sand Dust Horus
		addCentrifugeRecipe(OberonRockDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 25, 1),
				RecipeUtilGS.getItem("techreborn", "dust", 27, 1), RecipeUtilGS.getItem("IC2", "itemDust", 11, 6), null,
				300, 25);

		// Coral Rock Seth
		addCentrifugeRecipe(OberonRockDust.getItem(32), null, BacterialFossilDust.getItem(6), null, null, null, 300,
				25);

		// Dark Asteroid Rock
		addCentrifugeRecipe(OberonRockDust.getItem(32), null, AlphereDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 25, 2), RecipeUtilGS.getItem("techreborn", "dust", 38, 3),
				null, 300, 25);

	}

	private static void addCentrifugeRecipe(ItemStack input1, ItemStack input2, ItemStack output1, ItemStack output2,
			ItemStack output3, ItemStack output4, int tickTime, int euPerTick) {

		techreborn.api.recipe.RecipeHandler.addRecipe(
				new CentrifugeRecipe(input1, input2, output1, output2, output3, output4, tickTime, euPerTick));

	}
}
