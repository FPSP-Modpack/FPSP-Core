package glowredman.fpsp.item;

import glowredman.fpsp.FPSP;
import net.minecraft.item.ItemStack;

public enum ItemDefinitions {

	// Stuff (63 leftover)
	MassZivicioDust(0),

	// Moon
	MoonRockDust(1), MoonDust(98),

	// Mars
	MarsRockDust(2), DeshDust(56),

	// Phobos
	PhobosRockDust(3),

	// Deimos
	DeimosRockDust(4), OriharukonDust(57),

	// All sorts of asteroids
	AsteroidRockDust(5), MeteoricIronDust(55),

	// Callisto
	CallistoRockDust(6), PalladiumDust(58),

	// Ganymede
	GanymedeRockDust(7),

	// Ceres
	CeresRockDust(8),

	// Europa
	EuropaDust(9), EuropaRockDust(42), EuropiumDust(59),

	// Io
	IoRockDust(10), MetalMeteoricIronDust(60), IoDust(102),

	// Mercury
	MercuryRockDust(11), MetallicDust(61), MercurianIronDust(62),

	// Venus
	VenusRockDust(12), CitrineDust(64),

	// Enceladus
	EnceladusRockDust(13), FrozenIronDust(65), EnceladusDust(107),

	// Titan
	TitanRockDust(14), RhodiumDust(66), PetaliteDust(67),

	// Miranda
	MirandaRockDust(15), JadeDust(68),

	// Oberon
	OberonRockDust(16), AdamantiteDust(69),

	// Proteus
	ProteusRockDust(17),

	// Triton
	TritonRockDust(18), UraniumDust(70),

	// Vega B
	VegaBRockDust(19), WhiteCrystalDust(71),

	// Pluto
	PlutoRockDust(20), PlutoniumDust(72), XeoniumDust(73), PlutoDust(103),

	// Kuiper Belt
	DenseIceDust(21),

	// Haumea
	HaumeaRockDust(22), OnyxDust(74),

	// Makemake
	MakemakeRockDust(23), BismuthDust(75),

	// Koentus
	KoentusRockDust(24), KoentusMeteoricIronDust(76), KoentusDust(104),

	// Diona
	DionaRockDust(25), QuontoniumDust(77), FronisiumDust(78),

	// aCentauri Bb
	ACentauriBbRockDust(26), CentauriumDust(79),

	// Plongius
	PolongniusRockDust(27), PolongniusMeteoricIronDust(80), FloniumDust(81),

	// Barnarda Planets
	BarnardaCDust(28), BarnardaERockDust(29), BarnardaFRockDust(30),

	// Barnarda raw materials
	PinkQuartzDust(82), CarnelianDust(83), ChalcedonyDust(84),

	// Nibiru
	NibiruRockDust(31), IchoriusDust(85), RedGemDust(86),

	// T Ceti E
	TCetiERockDust(32), EMPDust(87), NoriumDust(88),

	// Eden
	EdenRockDust(33), EdenDust(43), ViriniumDust(89),

	// Kapteyn
	KapteynBRockDust(34), NameriumDust(90), KapteynBDust(105),

	// Fronos
	FronosRockDust(35), FronosDust(44),

	// Kriffon
	KriffonRockDust(36), KriffonDust(45), BlackDiamondDust(91),

	// Zollus
	ZolrockDust(37), ZollusDust(46), HeatiumDust(92),

	// Sirius B
	SiriusBRockDust(38),

	// Oasis
	OasisRockDust(39), OasisDust(47),

	// Xathius
	XathianRockDust(40), XathianDust(48), XathiumDust(93),

	// Purgot
	PurgotRockDust(41), PurgotDust(49), EveniumDust(94),

	// Horus
	ObsidianSandDust(50),

	// Anubis Neper
	BasaltRockDust(51), NeperDust(52), ChioniteDust(95), BacterialFossilDust(96), PurpleGemDust(97), BasaltDust(106),

	// Maahes
	MaahesDust(53),

	// Seth
	CoralDust(54),

	// Dark Asteroids
	DarkAsteroidRockDust(99), AlphereDust(100), DarkAsteroidDust(101),

	;

	private int meta;

	private ItemDefinitions(int meta) {
		this.meta = meta;
	}

	public String getName() {
		return this.toString();
	}

	public int getMeta() {
		return this.meta;
	}

	public ItemStack getItem() {
		return this.getItem(1);
	}

	public ItemStack getItem(int amount) {
		return new ItemStack(FPSP.ITEM, amount, this.getMeta());
	}

}
