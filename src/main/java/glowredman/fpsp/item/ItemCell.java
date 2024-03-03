package glowredman.fpsp.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;

import glowredman.fpsp.FPSP;
import ic2.api.item.IC2Items;

public class ItemCell extends Item implements IFluidContainerItem {

    private IIcon[] textures;
    public static final String[] TYPES = new String[] { "tinplasma", "nitrogenplasma", "zincplasma", "calciumplasma",
        "sulfurplasma", "ironplasma", "molten.tin", "molten.zinc", "molten.iron" };

    public ItemCell() {
        setHasSubtypes(true);
        setUnlocalizedName("cell");
        textures = new IIcon[TYPES.length];
    }

    public void register() {
        for (int i = 0; i < TYPES.length; i++) {
            FluidContainerRegistry.registerFluidContainer(
                FluidRegistry.getFluid(TYPES[i]),
                new ItemStack(this, 1, i),
                IC2Items.getItem("cell"));
        }
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        for (int i = 0; i < TYPES.length; i++)
            textures[i] = iconRegister.registerIcon(FPSP.MODID + ":cells/" + TYPES[i]);
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        return meta < TYPES.length ? textures[meta] : textures[0];
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getItemDamage();
        if (meta >= TYPES.length) meta = 0;
        return getUnlocalizedName() + "." + TYPES[meta];
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> variants) {
        for (int i = 0; i < TYPES.length; i++) {
            variants.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public FluidStack getFluid(ItemStack container) {
        int meta = container.getItemDamage();
        return meta < TYPES.length ? FluidRegistry.getFluidStack(TYPES[meta], 1000) : null;
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
        if (maxDrain < getCapacity(container)) return null;
        FluidStack fluid = getFluid(container);
        if (doDrain && fluid != null) container = IC2Items.getItem("cell");
        return fluid;
    }

}
