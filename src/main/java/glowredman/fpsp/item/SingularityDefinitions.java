package glowredman.fpsp.item;

import java.awt.Color;

import glowredman.fpsp.FPSP;
import glowredman.fpsp.Utils;
import net.minecraft.item.ItemStack;

public enum SingularityDefinitions {
	IRIDIUM(0xF0F0F5, "blockIridium", 1210),
	BLOOD_INFUSED_IRON(0x45090A, Utils.getItem("BloodArsenal", "blood_infused_iron_block"), 1851),
	CITRINE(0xF0E628, "blockCitrine", 260),
	ONYX(0x454545, "blockOnyx", 640),
	PINK_QUARTZ(0xFFAAC8, "blockPinkQuartz", 150),
	CARNELIAN(0xEB2D23, "blockCarnelian", 160),
	CHALCEDONY(0x8C5018, "blockChalcedony", 160),
	JADE(0x006400, "blockJade", 120),
	PETALITE(0xE9EEAF, "blockPetalite", 640),
	MERCURIAN_IRON(0x89847e, "blockMercurianIron", 40),
	PLUTONIUM(0xF03232, "blockPlutonium", 310),
	BISMUTH(0x64A0A0, "blockBismuth", 640),
	CENTAURIUM(0xFF921D, 0xFF3A3D, "blockCentaurium", 480),
	EUROPIUM(0x778899, "blockEuropium", 2000),
	RHODIUM(0xC8D7C8, "blockRhodium", 960),
	CERTUS(0xD2D2E6, Utils.getItem("appliedenergistics2", "tile.BlockQuartz"), 3780),
	FLUIX(0x9860C0, 0x182040, Utils.getItem("appliedenergistics2", "tile.BlockFluix"), 2400),
	MANASTEEL(0x50A0E0, Utils.getItem("Botania", "storage"), 2048),
	TERRASTEEL(0x58D028, Utils.getItem("Botania", "storage", 1), 512),
	ELEMENTIUM(0xDC64FA, Utils.getItem("Botania", "storage", 2), 256),
	MANA_DIAMOND(0xA0E8E8, Utils.getItem("Botania", "storage", 3), 1024),
	DRAGONSTONE(0xE6AADC, Utils.getItem("Botania", "storage", 4), 128),
	IRONWOOD(0x968C6E, "blockIronwood", 1000),
	KNIGHTMETAL(0xD2F0C8, Utils.getItem("TwilightForest", "tile.KnightmetalBlock"), 8000),
	STELLAR_ALLOY(0xD9DCCB, "blockStellarAlloy", 100),
	MELODIC_ALLOY(0x886288, "blockMelodicAlloy", 200),
	CRYSTALLINE_PINK_SLIME(0xE79EDB, "blockCrystallinePinkSlime", 400),
	END_STEEL(0xDFD9A5, "blockEndSteel", 600),
	CRYSTALLINE_ALLOY(0x72C5C5, "blockCrystallineAlloy", 800),
	VIVID_ALLOY(0x46BCD, "blockVividAlloy", 1600),
	ENERGETIC_SILVER(0x95B7CD, "blockEnergeticSilver", 3200),
	ENDIUM(0xA5DCFA, "blockHeeEndium", 2000),
	METEORIC_IRON(0x643250, "blockMeteoricIron", 4000),
	DESH(0x282828, "blockDesh", 2980),
	ADAMANTITE(0xCDD299, "blockAdamantite", 1160),
	MAGNESIUM(0xFFC8C8, "blockMagnesium", 1020),
	ORIHARUKON(0x677D68, "blockOriharukon", 1290),
	QUONTONIUM(0xABABF8, "blockQuontonium", 1530),
	FRONISIUM(0xE2E2E2, "blockFronisium", 650),
	POLONGNIUS_METEORIC_IRON(0xF2B500, "blockPolongniusMeteoricIron", 10),
	PURPLE_CRYSTAL(0xB418B4, "blockPurpleCrystal", 550),
	ICHORIUS(0xC850C8, "blockIchorius", 630),
	NORIUM(0xB4CDE6, "blockNorium", 800),
	WHITE_CRYSTAL(0xD7F0F0, "blockWhiteCrystal", 1090),
	EMP(0x8294D8, "blockEMP", 400),
	KOENTUS_METEORIC_IRON(0x0046AA, "blockKoentusMeteoricIron", 8),
	BLACK_DIAMOND(0x232323, "blockBlackDiamond", 480),
	NAMERIUM(0xFF8000, "blockNamerium", 630),
	FROZEN_IRON(0xEFFFFF, "blockFrozenIron", 2240),
	METAL_METEORIC_IRON(0x404040, "blockMetalMeteor", 1000),
	FLONIUM(0xFF3C3C, "blockFlonium", 850),
	BACTERIAL_FOSSIL(0x005575, "blockBacterialFossil", 640),
	ICE_CRYSTAL(0x7CBC9D, "blockIceCrystal", 4),
	METALLIC(0x606060, "blockMetallic", 420),
	XEONIUM(0x00F293, "blockXeonium", 630),
	SOULIUM(0x320032, "blockSoulium", 1000),
	TUNGSTENSTEEL(0x6464A0, "plateTungstensteel", 1200),
	YELLOW_GARNET(0xC8C850, "blockYellowGarnet", 220),
	RED_GARNET(0xC85050, "blockRedGarnet", 950),
	OLIVINE(0x96FF96, "blockOlivine", 100),
	DARK_SOULARIUM(0x5A4B3C, "blockDarkSoularium", 1000)
	;

	private int color1;
	private int color2;
	private Object input;
	private int amount;

	private SingularityDefinitions(int color, Object input, int amount) {
		this(color, darker(color), input, amount);
	}

	private SingularityDefinitions(int color1, int color2, Object input, int amount) {
		this.color1 = color1;
		this.color2 = color2;
		this.input = input;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}

	public int getColor1() {
		return this.color1;
	}

	public int getColor2() {
		return this.color2;
	}

	public Object getInput() {
		return this.input;
	}

	public int getAmount() {
		return this.amount;
	}

	public ItemStack getItem() {
		return new ItemStack(FPSP.itemSingularity, 1, this.ordinal());
	}

	private static int darker(int colorIn) {
		return new Color(colorIn).darker().getRGB();
	}

}
