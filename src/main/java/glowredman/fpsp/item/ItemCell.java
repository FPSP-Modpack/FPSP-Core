package glowredman.fpsp.item;

import java.util.List;

import glowredman.fpsp.FPSP;
import ic2.api.item.IC2Items;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;

public class ItemCell extends Item implements IFluidContainerItem {

	private IIcon[] textures;
	public static final String[] types = new String[] { "tinplasma", "nitrogenplasma", "zincplasma", "calciumplasma",
			"sulfurplasma", "ironplasma", "molten.tin", "molten.zinc", "molten.iron" };

	public ItemCell() {
		setHasSubtypes(true);
		setUnlocalizedName("cell");
		textures = new IIcon[types.length];
	}

	public void register() {
		for (int i = 0; i < types.length; i++) {
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluid(types[i]), new ItemStack(this, 1, i),
					IC2Items.getItem("cell"));
		}
	}

	@Override
	public void registerIcons(IIconRegister iconRegister) {
		for (int i = 0; i < types.length; i++)
			textures[i] = iconRegister.registerIcon(FPSP.MODID + ":cells/" + types[i]);
	}

	@Override
	public IIcon getIconFromDamage(int meta) {
		return meta < types.length ? textures[meta] : textures[0];
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int meta = stack.getItemDamage();
		if (meta >= types.length)
			meta = 0;
		return getUnlocalizedName() + "." + types[meta];
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> variants) {
		for (int i = 0; i < types.length; i++) {
			variants.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public FluidStack getFluid(ItemStack container) {
		int meta = container.getItemDamage();
		return meta < types.length ? FluidRegistry.getFluidStack(types[meta], 1000) : null;
	}

	@Override
	public int getCapacity(ItemStack container) {
		return 1000;
	}

	@Override
	public int fill(ItemStack container, FluidStack resource, boolean doFill) {
		return 0;
	}

	@Override
	public FluidStack drain(ItemStack container, int maxDrain, boolean doDrain) {
		if (maxDrain < getCapacity(container))
			return null;
		FluidStack fluid = getFluid(container);
		if (doDrain && fluid != null)
			container = IC2Items.getItem("cell");
		return fluid;
	}

}
