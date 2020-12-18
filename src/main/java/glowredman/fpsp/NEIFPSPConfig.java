package glowredman.fpsp;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import glowredman.fpsp.item.ItemDefinitions;
import net.minecraft.item.ItemStack;

public class NEIFPSPConfig implements IConfigureNEI {

	@Override
	public String getName() {
		return "FPSP NEI Plugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void loadConfig() {
		API.hideItem(new ItemStack(FPSP.ITEM, 1, ItemDefinitions.values().length));
	}

}
