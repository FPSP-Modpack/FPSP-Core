package glowredman.fpsp;

import static glowredman.fpsp.item.ItemDefinitions.*;

import galaxyspace.core.recipe.RecipeUtilGS;
import net.minecraft.item.ItemStack;
import techreborn.api.recipe.machines.CentrifugeRecipe;

public class RecipeHandler {

	public static void init() {

		addCentrifugeRecipe(MoonRockDust.getItem(), null, MeteoricIronDust.getItem(),
				RecipeUtilGS.getItem("IC2", "itemDust", 3, 3), RecipeUtilGS.getItem("IC2", "itemDust", 7), null, 300,
				25);

	}

	private static void addCentrifugeRecipe(ItemStack input1, ItemStack input2, ItemStack output1, ItemStack output2,
			ItemStack output3, ItemStack output4, int tickTime, int euPerTick) {

		techreborn.api.recipe.RecipeHandler.addRecipe(
				new CentrifugeRecipe(input1, input2, output1, output2, output3, output4, tickTime, euPerTick));

	}
}
