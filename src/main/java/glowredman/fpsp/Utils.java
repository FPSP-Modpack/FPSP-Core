package glowredman.fpsp;

import static net.minecraft.util.EnumChatFormatting.AQUA;
import static net.minecraft.util.EnumChatFormatting.BLUE;
import static net.minecraft.util.EnumChatFormatting.DARK_AQUA;
import static net.minecraft.util.EnumChatFormatting.DARK_PURPLE;
import static net.minecraft.util.EnumChatFormatting.GOLD;
import static net.minecraft.util.EnumChatFormatting.GREEN;
import static net.minecraft.util.EnumChatFormatting.ITALIC;
import static net.minecraft.util.EnumChatFormatting.RED;
import static net.minecraft.util.EnumChatFormatting.RESET;
import static net.minecraft.util.EnumChatFormatting.YELLOW;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

import com.mojang.authlib.GameProfile;

import buildcraft.api.tiles.IControllable;
import buildcraft.api.tiles.IHeatable;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import ic2.api.energy.tile.IEnergyConductor;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.energy.tile.IHeatSource;
import ic2.api.energy.tile.IKineticSource;
import ic2.api.reactor.IReactor;
import ic2.api.reactor.IReactorChamber;
import ic2.api.tile.IEnergyStorage;
import ic2.api.tile.IWrenchable;
import ic2.core.block.generator.tileentity.TileEntityWindGenerator;
import ic2.core.block.machine.tileentity.TileEntityNuke;
import ic2.core.block.machine.tileentity.TileEntityTeleporter;
import ic2.core.block.personal.IPersonalBlock;
import micdoodle8.mods.galacticraft.api.power.IEnergyStorageGC;
import micdoodle8.mods.galacticraft.api.tile.IColorable;
import micdoodle8.mods.galacticraft.api.transmission.tile.IConductor;
import micdoodle8.mods.galacticraft.api.transmission.tile.IElectrical;
import micdoodle8.mods.galacticraft.api.transmission.tile.IElectricalStorage;
import micdoodle8.mods.galacticraft.api.transmission.tile.IOxygenReceiver;
import micdoodle8.mods.galacticraft.api.transmission.tile.IOxygenStorage;

public class Utils {

    public static ItemStack getItem(String modID, String itemName) {
        return GameRegistry.findItemStack(modID, itemName, 1);
    }

    public static ItemStack getItem(String modID, String itemName, int meta) {
        ItemStack stack = GameRegistry.findItemStack(modID, itemName, 1);
        Items.apple.setDamage(stack, meta);
        return stack;
    }

    public static ItemStack getItems(String modID, String itemName, int amount) {
        return GameRegistry.findItemStack(modID, itemName, amount);
    }

    public static ItemStack getItems(String modID, String itemName, int meta, int amount) {
        ItemStack stack = GameRegistry.findItemStack(modID, itemName, amount);
        Items.apple.setDamage(stack, meta);
        return stack;
    }

    public static List<String> getCoordinateScan(EntityPlayer player, World world, int x, int y, int z, int side,
        float clickX, float clickY, float clickZ) {
        long time = System.nanoTime();

        List<String> list = new ArrayList<>();

        TileEntity te = world.getTileEntity(x, y, z);
        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);

        list.add("");
        list.add(
            "----- X: " + AQUA
                + formatNumber(x)
                + RESET
                + " Y: "
                + AQUA
                + formatNumber(y)
                + RESET
                + " Z: "
                + AQUA
                + formatNumber(z)
                + RESET
                + " B: "
                + AQUA
                + world.getBiomeGenForCoords(x, z).biomeID
                + RESET
                + " D: "
                + AQUA
                + world.provider.dimensionId
                + RESET
                + " -----");
        list.add(
            " Block Class: " + BLUE
                + block.getClass()
                    .getName()
                + RESET);
        list.add(" Name: " + BLUE + block.getUnlocalizedName() + RESET + " MetaData: " + AQUA + meta + RESET);
        list.add(
            " Hardness: " + YELLOW
                + formatNumber(block.getBlockHardness(world, x, y, z))
                + RESET
                + " Blast Resistance: "
                + YELLOW
                + formatNumber(
                    block.getExplosionResistance(player, world, x, y, z, player.posX, player.posY, player.posZ))
                + RESET);
        if (block.isBeaconBase(world, x, y, z, x, y + 1, z)) list.add(GOLD + "Is valid Beacon Base Material");

        if (te != null) {

            // -=-=- MINECRAFT -=-=-
            try {
                list.add(
                    " Tile Entity Class: " + BLUE
                        + te.getClass()
                            .getName()
                        + RESET);

                if (te instanceof IInventory) {
                    list.add(DARK_PURPLE + "" + ITALIC + "IInventory:");
                    list.add(" Name: " + BLUE + ((IInventory) te).getInventoryName() + RESET);
                }
            } catch (Exception e) {

            }

            // -=-=- MINECRAFT FORGE -=-=-
            if (te instanceof IFluidHandler fluidHandler) {
                FluidTankInfo[] tanks = fluidHandler.getTankInfo(ForgeDirection.getOrientation(side));
                if (tanks != null) {
                    list.add(DARK_PURPLE + "" + ITALIC + "IFluidHandler:");
                    for (int i = 0; i < tanks.length; i++) list.add(
                        " Tank " + i
                            + ": "
                            + AQUA
                            + formatNumber(tanks[i].fluid == null ? 0 : tanks[i].fluid.amount)
                            + RESET
                            + "mB / "
                            + AQUA
                            + formatNumber(tanks[i].capacity)
                            + RESET
                            + "mB "
                            + BLUE
                            + getFluidName(tanks[i].fluid, true)
                            + RESET);
                }
            }

            // -=-=- INDUTRIAL CRAFT 2 -=-=-
            try {
                if (te instanceof IReactorChamber reactorChamber) te = (TileEntity) reactorChamber.getReactor();
            } catch (Exception e) {}
            if (te instanceof IReactor reactor) {
                list.add(DARK_PURPLE + "" + ITALIC + "IC2.IReactor:");
                list.add(
                    " Heat: " + AQUA
                        + formatNumber(reactor.getHeat())
                        + RESET
                        + " / "
                        + AQUA
                        + formatNumber(reactor.getMaxHeat())
                        + RESET);
                list.add(
                    " HEM: " + YELLOW
                        + formatNumber(reactor.getHeatEffectModifier())
                        + RESET
                        + " Output: "
                        + YELLOW
                        + formatNumber(reactor.getReactorEUEnergyOutput())
                        + RESET
                        + "EU/t");
            }
            if (te instanceof IWrenchable wrenchable) {
                list.add(DARK_PURPLE + "" + ITALIC + "IC2.IWrenchable:");
                list.add(
                    " Facing: " + BLUE
                        + ForgeDirection.getOrientation(wrenchable.getFacing())
                            .name()
                        + RESET
                        + " Chance: "
                        + YELLOW
                        + (wrenchable.getWrenchDropRate() * 100)
                        + RESET
                        + "%");
                list.add(
                    wrenchable.wrenchCanRemove(player) ? GREEN + " You can remove this with a Wrench" + RESET
                        : RED + " You can NOT remove this with a Wrench" + RESET);
            }
            if (te instanceof IEnergySink energySink) {
                list.add(DARK_PURPLE + "" + ITALIC + "IC2.IEnergySink:");
                list.add(
                    " Input Tier: " + AQUA
                        + energySink.getSinkTier()
                        + RESET
                        + " Demanded Energy: "
                        + YELLOW
                        + formatNumber(energySink.getDemandedEnergy())
                        + RESET
                        + "EU");
            }
            if (te instanceof IEnergySource energySource) {
                list.add(DARK_PURPLE + "" + ITALIC + "IC2.IEnergySource:");
                list.add(
                    " Output Tier: " + AQUA
                        + energySource.getSourceTier()
                        + RESET
                        + " Offered Energy: "
                        + YELLOW
                        + formatNumber(energySource.getOfferedEnergy())
                        + RESET
                        + "EU");
            }
            if (te instanceof IEnergyConductor energyConductor) {
                list.add(DARK_PURPLE + "" + ITALIC + "IC2.IEnergyConductor:");
                list.add(
                    " Loss: " + YELLOW
                        + formatNumber(energyConductor.getConductionLoss())
                        + RESET
                        + "EU/Block Conductor Breakdown Energy: "
                        + YELLOW
                        + formatNumber(energyConductor.getConductorBreakdownEnergy())
                        + RESET
                        + "EU/t");
                list.add(
                    " Insulation Absorption: " + YELLOW
                        + formatNumber(energyConductor.getInsulationEnergyAbsorption())
                        + RESET
                        + "EU/t Insulator Breakdown Energy: "
                        + YELLOW
                        + formatNumber(energyConductor.getInsulationBreakdownEnergy())
                        + RESET
                        + "EU/t");
            }
            if (te instanceof IEnergyStorage energyStorage) {
                list.add(DARK_PURPLE + "" + ITALIC + "IC2.IEnergyStorage:");
                list.add(
                    " Contained Energy: " + AQUA
                        + formatNumber(energyStorage.getStored())
                        + RESET
                        + "EU / "
                        + AQUA
                        + formatNumber(energyStorage.getCapacity())
                        + RESET
                        + "EU");
                list.add(
                    " Output: " + YELLOW + formatNumber(energyStorage.getOutputEnergyUnitsPerTick()) + RESET + "EU/t");
                list.add(
                    energyStorage.isTeleporterCompatible(ForgeDirection.getOrientation(side))
                        ? GREEN + " Teleporter Compatible" + RESET
                        : RED + " NOT Teleporter Compatible" + RESET);
            }
            if (te instanceof IKineticSource kineticSource) {
                list.add(DARK_PURPLE + "" + ITALIC + "IC2.IKineticSource:");
                list.add(
                    " Max Kinetic Energy (theoretical): " + YELLOW
                        + formatNumber(kineticSource.maxrequestkineticenergyTick(ForgeDirection.getOrientation(side)))
                        + RESET
                        + "KU/t");
            }
            if (te instanceof IHeatSource heatSource) {
                list.add(DARK_PURPLE + "" + ITALIC + "IC2.IHeatSource:");
                list.add(
                    " Max Heat Energy (theoretical): " + YELLOW
                        + formatNumber(heatSource.maxrequestHeatTick(ForgeDirection.getOrientation(side)))
                        + RESET
                        + "HU/t");
            }
            if (te instanceof IPersonalBlock personalBlock) {
                list.add(DARK_PURPLE + "" + ITALIC + "IC2.IPersonalBlock:");
                GameProfile owner = personalBlock.getOwner();
                if (owner != null) {
                    list.add(
                        " Owner: " + BLUE
                            + owner.getName()
                            + RESET
                            + " ("
                            + BLUE
                            + owner.getId()
                                .toString()
                            + RESET
                            + ")");
                }
                list.add(
                    personalBlock.permitsAccess(player.getGameProfile()) ? GREEN + " Access granted" + RESET
                        : RED + " Access denied" + RESET);
            }
            if (te instanceof TileEntityWindGenerator windGenerator) {
                list.add(DARK_PURPLE + "" + ITALIC + "IC2.TileEntityWindGenerator:");
                list.add(" Obscurated Blocks: " + AQUA + windGenerator.obscuratedBlockCount + RESET);
            }
            if (te instanceof TileEntityNuke nuke) {
                list.add(DARK_PURPLE + "" + ITALIC + "IC2.TileEntityNuke:");
                list.add(
                    " Explosion Power: " + YELLOW
                        + nuke.getNukeExplosivePower()
                        + RESET
                        + " Radiation Range: "
                        + AQUA
                        + nuke.getRadiationRange()
                        + RESET);
            }
            if (te instanceof TileEntityTeleporter teleporter) {
                list.add(DARK_PURPLE + "" + ITALIC + "IC2.TileEntityTeleporter:");
                if (teleporter.targetSet) {
                    int weight = teleporter.getWeightOf(player);
                    double distance = distance(teleporter);
                    list.add(
                        " Target -- X: " + AQUA
                            + formatNumber(teleporter.targetX)
                            + RESET
                            + " Y: "
                            + AQUA
                            + formatNumber(teleporter.targetY)
                            + RESET
                            + " Z: "
                            + AQUA
                            + formatNumber(teleporter.targetZ)
                            + RESET);
                    list.add(
                        " Your Weight: " + AQUA
                            + formatNumber(weight)
                            + RESET
                            + " Distance: "
                            + YELLOW
                            + formatNumber(distance)
                            + RESET
                            + " Required Energy: "
                            + AQUA
                            + formatNumber((int) (weight * Math.pow(distance + 10.0D, 0.7D) * 5.0D))
                            + RESET
                            + "EU");
                } else {
                    list.add(RED + " Target not set!" + RESET);
                }
            }
            if (te instanceof ICropTile cropTile) {
                CropCard crop = cropTile.getCrop();
                if (cropTile.getScanLevel() < 4) cropTile.setScanLevel((byte) 4);

                if (crop != null) {
                    list.add(DARK_PURPLE + "" + ITALIC + "IC2.ICropTile:");
                    String name = BLUE + crop.name() + RESET;
                    if (crop.isWeed(cropTile)) name += " (" + RED + "WEED!" + RESET + ")";
                    list.add(" Name: " + name + " Tier: " + AQUA + crop.tier() + RESET);
                    list.add(
                        " Type -- Growth: " + AQUA
                            + cropTile.getGrowth()
                            + RESET
                            + " Gain: "
                            + AQUA
                            + cropTile.getGain()
                            + RESET
                            + " Resistance: "
                            + AQUA
                            + cropTile.getResistance()
                            + RESET);
                    list.add(
                        " Plant -- Fertilizer: " + AQUA
                            + cropTile.getNutrientStorage()
                            + RESET
                            + " Water: "
                            + AQUA
                            + cropTile.getHydrationStorage()
                            + RESET
                            + " Weed-Ex: "
                            + AQUA
                            + cropTile.getWeedExStorage()
                            + RESET);
                    list.add(
                        " Environment -- Nutrients: " + AQUA
                            + cropTile.getNutrients()
                            + RESET
                            + " Humidity: "
                            + AQUA
                            + cropTile.getHumidity()
                            + RESET
                            + " Air Quality: "
                            + AQUA
                            + cropTile.getAirQuality()
                            + RESET);
                    boolean harvestable = crop.canBeHarvested(cropTile);
                    boolean canGrow = crop.canGrow(cropTile);
                    boolean canCrossBreed = crop.canCross(cropTile);
                    String temp = GREEN + (harvestable ? " Harvestable" : "")
                        + (canGrow ? " Can grow" : "")
                        + (canCrossBreed ? " Can cross-breed" : "")
                        + RESET;
                    if (harvestable || canCrossBreed || canGrow) list.add(temp);
                    boolean optimal = cropTile.getSize() == crop.getOptimalHavestSize(cropTile);
                    list.add(" Size: " + AQUA + cropTile.getSize() + (optimal ? GREEN + " OPTIMAL" : "" + RESET));
                    String attr = "";
                    if (crop.attributes() != null) for (String a : crop.attributes()) attr += ", " + BLUE + a + RESET;
                    list.add(" Attributes:" + attr.replaceFirst(",", ""));
                    list.add(" Discovered by: " + BLUE + crop.discoveredBy() + RESET);

                }
            }

            // -=-=- Galacticraft 3 -=-=-
            if (te instanceof IColorable colorable) {
                list.add(DARK_PURPLE + "" + ITALIC + "GC.IColorable:");
                EnumChatFormatting color = EnumChatFormatting.values()[colorable.getColor()];
                list.add(" Color: " + color + capitalize(color.getFriendlyName()) + RESET);
            }
            if (te instanceof IConductor conductor) {
                list.add(DARK_PURPLE + "" + ITALIC + "GC.IConductor:");
                list.add(
                    " Network Type: " + BLUE
                        + conductor.getNetworkType()
                            .name()
                        + RESET
                        + " Tier: "
                        + AQUA
                        + conductor.getTierGC()
                        + RESET);
            }
            if (te instanceof IElectrical electrical) {
                list.add(DARK_PURPLE + "" + ITALIC + "GC.IElectrical:");
                list.add(" Tier: " + AQUA + electrical.getTierGC() + RESET);
                list.add(
                    " Energy Provided: " + YELLOW
                        + formatNumber(electrical.getProvide(ForgeDirection.getOrientation(side)))
                        + RESET
                        + "J Energy Requested: "
                        + YELLOW
                        + formatNumber(electrical.getRequest(ForgeDirection.getOrientation(side)))
                        + RESET
                        + "J");
            }
            if (te instanceof IElectricalStorage electricalStorage) {
                list.add(DARK_PURPLE + "" + ITALIC + "GC.IElectricalStorage:");
                list.add(
                    " Energy Stored: " + YELLOW
                        + formatNumber(electricalStorage.getEnergyStored())
                        + RESET
                        + "J / "
                        + YELLOW
                        + formatNumber(electricalStorage.getMaxEnergyStored())
                        + RESET
                        + "J");
            }
            if (te instanceof IEnergyStorageGC energyStorage) {
                list.add(DARK_PURPLE + "" + ITALIC + "GC.IEnergyStorageGC:");
                list.add(
                    " Energy Stored: " + YELLOW
                        + formatNumber(energyStorage.getEnergyStoredGC())
                        + RESET
                        + "J / "
                        + YELLOW
                        + formatNumber(energyStorage.getCapacityGC())
                        + RESET
                        + "J");
            }
            if (te instanceof IOxygenReceiver oxygenReceiver) {
                list.add(DARK_PURPLE + "" + ITALIC + "GC.IOxygenReceiver:");
                list.add(
                    " Oxygen Provided: " + YELLOW
                        + formatNumber(oxygenReceiver.getOxygenProvide(ForgeDirection.getOrientation(side)))
                        + RESET
                        + " Oxygen Requested: "
                        + YELLOW
                        + formatNumber(oxygenReceiver.getOxygenRequest(ForgeDirection.getOrientation(side)))
                        + RESET);
            }
            if (te instanceof IOxygenStorage oxygenStorage) {
                list.add(DARK_PURPLE + "" + ITALIC + "GC.IOxygenStorage:");
                list.add(
                    " Oxygen Stored: " + YELLOW
                        + formatNumber(oxygenStorage.getOxygenStored())
                        + RESET
                        + " / "
                        + YELLOW
                        + formatNumber(oxygenStorage.getMaxOxygenStored())
                        + RESET);
            }

            // -=-=- Buildcraft 7 -=-=-
            if (te instanceof IControllable controllable) {
                list.add(DARK_PURPLE + "" + ITALIC + "BC.IControllable:");
                list.add(" Mode: " + BLUE + controllable.getControlMode() + RESET);
            }
            if (te instanceof IHeatable heatable) {
                list.add(DARK_PURPLE + "" + ITALIC + "BC.IHeatable:");
                list.add(
                    " Min Heat: " + YELLOW
                        + formatNumber(heatable.getMinHeatValue())
                        + RESET
                        + "\u00BC Max Heat: "
                        + YELLOW
                        + formatNumber(heatable.getMaxHeatValue())
                        + RESET
                        + "\u00BC");
                list.add(
                    " Current Heat: " + YELLOW
                        + formatNumber(heatable.getCurrentHeatValue())
                        + RESET
                        + "\u00BC Ideal Heat: "
                        + YELLOW
                        + formatNumber(heatable.getIdealHeatValue())
                        + RESET
                        + "\u00B0C");
            }
        }

        list.add("Scanning took " + DARK_AQUA + formatNumber((System.nanoTime() - time)) + RESET + "ns.");

        return list;
    }

    private static String formatNumber(long number) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator('\u202F');
        return formatter.format(number);
    }

    private static String formatNumber(double number) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator('\u202F');
        return formatter.format(number);
    }

    private static String getFluidName(FluidStack fluid, boolean localized) {
        if (fluid == null) return "";
        String name = localized ? fluid.getLocalizedName() : fluid.getUnlocalizedName();
        if (name.contains("fluid.") || name.contains("tile.")) return capitalize(
            name.replaceAll("fluid.", "")
                .replaceAll("tile.", ""));
        return name;
    }

    private static double distance(TileEntityTeleporter tile) {
        int dX = tile.xCoord - tile.targetX;
        int dY = tile.yCoord - tile.targetY;
        int dZ = tile.zCoord - tile.targetZ;
        return Math.sqrt(dX * dX + dY * dY + dZ * dZ);
    }

    private static String capitalize(String s) {
        if (s != null && s.length() > 0) return s.substring(0, 1)
            .toUpperCase() + s.substring(1);
        return "";
    }

    private Utils() {}
}
