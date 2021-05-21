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
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import reborncore.common.util.OreUtil;

public class Utils {

	public static ItemStack getItem(String modID, String itemName) {
		return GameRegistry.findItemStack(modID, itemName, 1);
	}

	public static ItemStack getItem(String modID, String itemName, int meta) {
		ItemStack stack = GameRegistry.findItemStack(modID, itemName, 1);
		Items.apple.setDamage(stack, meta);
		return stack;
	}
	
	public static ItemStack getItem(String oreDict) {
		return OreUtil.getStackFromName(oreDict);
	}

	public static ItemStack getItems(String modID, String itemName, int amount) {
		return GameRegistry.findItemStack(modID, itemName, amount);
	}

	public static ItemStack getItems(String modID, String itemName, int meta, int amount) {
		ItemStack stack = GameRegistry.findItemStack(modID, itemName, amount);
		Items.apple.setDamage(stack, meta);
		return stack;
	}
	
	public static ItemStack getItems(String oreDict, int amount) {
		return OreUtil.getStackFromName(oreDict, amount);
	}

	public static Block getBlock(ItemStack blockStack) {
		Item item = blockStack.getItem();
		if (item instanceof ItemBlock) {
			return ((ItemBlock) item).field_150939_a;
		} else {
			return null;
		}
	}
	
	public static List<String> getCoordinateScan(EntityPlayer player, World world, int x, int y, int z, int side, float clickX, float clickY, float clickZ) {
		long time = System.nanoTime();
		
		List<String> list = new ArrayList<>();
		
		TileEntity te = world.getTileEntity(x, y, z);
		Block block = world.getBlock(x, y, z);
		
		list.add("");
		list.add("----- X: " + AQUA + formatNumber(x) + RESET + " Y: " + AQUA + formatNumber(y) + RESET + " Z: " + AQUA + formatNumber(z) + RESET + " B: " + AQUA + world.getBiomeGenForCoords(x, z).biomeID + RESET + " D: " + AQUA + world.provider.dimensionId + RESET + " -----");
		list.add(" Block Class: " + BLUE + block.getClass().getName() + RESET);
		
		if(te != null) {
			
			// -=-=- MINECRAFT -=-=-
			try {
				list.add(" Tile Entity Class: " + BLUE + te.getClass().getName() + RESET);
				list.add(" Name: " + BLUE + block.getUnlocalizedName() + RESET + " MetaData: " + AQUA + world.getBlockMetadata(x, y, z) + RESET);
				list.add(" Hardness: " + YELLOW + formatNumber(block.getBlockHardness(world, x, y, z)) + RESET + " Blast Resistance: " + YELLOW + formatNumber(block.getExplosionResistance(player, world, x, y, z, player.posX, player.posY, player.posZ)) + RESET);
				if(block.isBeaconBase(world, x, y, z, x, y + 1, z)) list.add(GOLD + "Is valid Beacon Base Material");
				
				if(te instanceof IInventory) {
					list.add(DARK_PURPLE + "" + ITALIC + "IInventory:");
					list.add(" Name: " + BLUE + ((IInventory) te).getInventoryName() + RESET + " MetaData: " + AQUA + world.getBlockMetadata(x, y, z) + RESET);
				}
			} catch (Exception e) {
				
			}
			
			// -=-=- MINECRAFT FORGE -=-=-
			try {
				if(te instanceof IFluidHandler) {
					FluidTankInfo[] tanks = ((IFluidHandler) te).getTankInfo(ForgeDirection.getOrientation(side));
					if(tanks != null) {
						list.add(DARK_PURPLE + "" + ITALIC + "IFluidHandler:");
						for(int i = 0; i < tanks.length; i++)
							list.add(" Tank " + i + ": " + AQUA + formatNumber(tanks[i].fluid == null ? 0 : tanks[i].fluid.amount) + RESET + "mB / " + AQUA + formatNumber(tanks[i].capacity) + RESET + "mB " + BLUE + getFluidName(tanks[i].fluid, true) + RESET);
					}
				}
			} catch (Exception e) {
				
			}
			
			// -=-=- INDUTRIAL CRAFT 2 -=-=-
			try {
				if(te instanceof IReactorChamber)
					te = (TileEntity) ((IReactorChamber) te).getReactor();
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof IReactor) {
					list.add(DARK_PURPLE + "" + ITALIC + "IC2.IReactor:");
					list.add(" Heat: " + AQUA + formatNumber(((IReactor) te).getHeat()) + RESET + " / " + AQUA + formatNumber(((IReactor) te).getMaxHeat()) + RESET);
					list.add(" HEM: " + YELLOW + formatNumber(((IReactor) te).getHeatEffectModifier()) + RESET + " Output: " + YELLOW + formatNumber(((IReactor) te).getReactorEUEnergyOutput()) + RESET + "EU/t");
				}
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof IWrenchable) {
					list.add(DARK_PURPLE + "" + ITALIC + "IC2.IWrenchable:");
					list.add(" Facing: " + BLUE + ForgeDirection.getOrientation(((IWrenchable) te).getFacing()).name() + RESET + " Chance: " + YELLOW + (((IWrenchable) te).getWrenchDropRate() * 100) + RESET + "%");
					list.add(((IWrenchable) te).wrenchCanRemove(player) ? GREEN + " You can remove this with a Wrench" + RESET : RED + " You can NOT remove this with a Wrench" + RESET);
				}
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof IEnergySink)
					list.add(DARK_PURPLE + "" + ITALIC + "IC2.IEnergySink:");
					list.add(" Input Tier: " + AQUA + ((IEnergySink) te).getSinkTier() + RESET + " Demanded Energy: " + YELLOW + formatNumber(((IEnergySink) te).getDemandedEnergy()) + RESET + "EU");
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof IEnergySource)
					list.add(DARK_PURPLE + "" + ITALIC + "IC2.IEnergySource:");
					list.add(" Output Tier: " + AQUA + ((IEnergySource) te).getSourceTier() + RESET + " Offered Energy: " + YELLOW + formatNumber(((IEnergySource) te).getOfferedEnergy()) + RESET + "EU");
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof IEnergyConductor) {
					list.add(DARK_PURPLE + "" + ITALIC + "IC2.IEnergyConductor:");
					list.add(" Loss: " + YELLOW + formatNumber(((IEnergyConductor) te).getConductionLoss()) + RESET + "EU/Block Conductor Breakdown Energy: " + YELLOW + formatNumber(((IEnergyConductor) te).getConductorBreakdownEnergy()) + RESET + "EU/t");
					list.add(" Insulation Absorption: " + YELLOW + formatNumber(((IEnergyConductor) te).getInsulationEnergyAbsorption()) + RESET + "EU/t Insulator Breakdown Energy: " + YELLOW + formatNumber(((IEnergyConductor) te).getInsulationBreakdownEnergy()) + RESET + "EU/t");
				}
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof IEnergyStorage) {
					list.add(DARK_PURPLE + "" + ITALIC + "IC2.IEnergyStorage:");
					list.add(" Contained Energy: " + AQUA + formatNumber(((IEnergyStorage) te).getStored()) + RESET + "EU / " + AQUA + formatNumber(((IEnergyStorage) te).getCapacity()) + RESET + "EU");
					list.add(" Output: " + YELLOW + formatNumber(((IEnergyStorage) te).getOutputEnergyUnitsPerTick()) + RESET + "EU/t");
					list.add(((IEnergyStorage) te).isTeleporterCompatible(ForgeDirection.getOrientation(side)) ? GREEN + " Teleporter Compatible" + RESET : RED + " NOT Teleporter Compatible" + RESET);
				}
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof IKineticSource)
					list.add(DARK_PURPLE + "" + ITALIC + "IC2.IKineticSource:");
					list.add(" Max Kinetic Energy (theoretical): " + YELLOW + formatNumber(((IKineticSource) te).maxrequestkineticenergyTick(ForgeDirection.getOrientation(side))) + RESET + "KU/t");
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof IHeatSource)
					list.add(DARK_PURPLE + "" + ITALIC + "IC2.IHeatSource:");
					list.add(" Max Heat Energy (theoretical): " + YELLOW + formatNumber(((IHeatSource) te).maxrequestHeatTick(ForgeDirection.getOrientation(side))) + RESET + "HU/t");
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof IPersonalBlock && ((IPersonalBlock) te).getOwner() != null) {
					list.add(DARK_PURPLE + "" + ITALIC + "IC2.IPersonalBlock:");
					GameProfile owner = ((IPersonalBlock) te).getOwner();
					list.add(" Owner: " + BLUE + owner.getName() + RESET + " (" + BLUE + owner.getId().toString() + RESET + ")");
					list.add(((IPersonalBlock) te).permitsAccess(player.getGameProfile()) ? GREEN + " Access granted" + RESET : RED + " Access denied" + RESET);
				}
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof TileEntityWindGenerator) {
					list.add(DARK_PURPLE + "" + ITALIC + "IC2.TileEntityWindGenerator:");
					list.add(" Obscurated Blocks: " + AQUA + ((TileEntityWindGenerator) te).obscuratedBlockCount + RESET);
				}
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof TileEntityNuke) {
					list.add(DARK_PURPLE + "" + ITALIC + "IC2.TileEntityNuke:");
					list.add(" Explosion Power: " + YELLOW + ((TileEntityNuke) te).getNukeExplosivePower() + RESET + " Radiation Range: " + AQUA + ((TileEntityNuke) te).getRadiationRange() + RESET);
				}
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof TileEntityTeleporter) {
					list.add(DARK_PURPLE + "" + ITALIC + "IC2.TileEntityTeleporter:");
					if(((TileEntityTeleporter) te).targetSet) {
						int weight = ((TileEntityTeleporter) te).getWeightOf(player);
						double distance = distance((TileEntityTeleporter) te);
						list.add(" Target -- X: " + AQUA + formatNumber(((TileEntityTeleporter) te).targetX) + RESET + " Y: " + AQUA + formatNumber(((TileEntityTeleporter) te).targetY) + RESET + " Z: " + AQUA + formatNumber(((TileEntityTeleporter) te).targetZ) + RESET);
						list.add(" Your Weight: " + AQUA + formatNumber(weight) + RESET + " Distance: " + YELLOW + formatNumber(distance) + RESET + " Required Energy: " + AQUA + formatNumber((int) (weight * Math.pow(distance + 10.0D, 0.7D) * 5.0D)) + RESET + "EU");
					}
					else
						list.add(RED + " Target not set!" + RESET);
					
				}
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof ICropTile) {
					CropCard crop = ((ICropTile) te).getCrop();
					if(((ICropTile) te).getScanLevel() < 4)
						((ICropTile) te).setScanLevel((byte) 4);
					
					if(crop != null) {
						list.add(DARK_PURPLE + "" + ITALIC + "IC2.ICropTile:");
						String name = BLUE + crop.name() + RESET;
						if(crop.isWeed(((ICropTile) te)))
							name += " (" + RED + "WEED!" + RESET + ")";
						list.add(" Name: " + name + " Tier: " + AQUA + crop.tier() + RESET);
						list.add(" Type -- Growth: " + AQUA + ((ICropTile) te).getGrowth() + RESET
								+ " Gain: " + AQUA + ((ICropTile) te).getGain() + RESET
								+ " Resistance: " + AQUA + ((ICropTile) te).getResistance() + RESET);
						list.add(" Plant -- Fertilizer: " + AQUA + ((ICropTile) te).getNutrientStorage() + RESET
								+ " Water: " + AQUA + ((ICropTile) te).getHydrationStorage() + RESET
								+ " Weed-Ex: " + AQUA + ((ICropTile) te).getWeedExStorage() + RESET);
						list.add(" Environment -- Nutrients: " + AQUA + ((ICropTile) te).getNutrients() + RESET
								+ " Humidity: " + AQUA + ((ICropTile) te).getHumidity() + RESET
								+ " Air Quality: " + AQUA + ((ICropTile) te).getAirQuality() + RESET);
						boolean harvestable = crop.canBeHarvested(((ICropTile) te));
						boolean canGrow = crop.canGrow(((ICropTile) te));
						boolean canCrossBreed = crop.canCross(((ICropTile) te));
						String temp = GREEN + (harvestable ? " Harvestable" : "") + (canGrow ? " Can grow" : "") + (canCrossBreed ? " Can cross-breed" : "") + RESET;
						if(harvestable || canCrossBreed || canGrow)
							list.add(temp);
						boolean optimal = ((ICropTile) te).getSize() == crop.getOptimalHavestSize(((ICropTile) te));
						list.add(" Size: " + AQUA + ((ICropTile) te).getSize() + (optimal ? GREEN + " OPTIMAL" : "" + RESET));
						String attr = "";
						if(crop.attributes() != null)
							for(String a : crop.attributes())
								attr += ", " + BLUE + a + RESET;
						list.add(" Attributes:" + attr.replaceFirst(",", ""));
						list.add(" Discovered by: " + BLUE +  crop.discoveredBy() + RESET);
						
					}
				}
			} catch (Exception e) {
				
			}
			
			// -=-=- Galacticraft 3 -=-=-
			try {
				if(te instanceof IColorable) {
					list.add(DARK_PURPLE + "" + ITALIC + "GC.IColorable:");
					EnumChatFormatting color = EnumChatFormatting.values()[((IColorable) te).getColor()];
					list.add(" Color: " + color + capitalize(color.getFriendlyName()) + RESET);
				}
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof IConductor) {
					list.add(DARK_PURPLE + "" + ITALIC + "GC.IConductor:");
					list.add(" Network Type: " + BLUE + ((IConductor) te).getNetworkType().name() + RESET + " Tier: " + AQUA + ((IConductor) te).getTierGC() + RESET);
				}
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof IElectrical) {
					list.add(DARK_PURPLE + "" + ITALIC + "GC.IElectrical:");
					list.add(" Tier: " + AQUA + ((IElectrical) te).getTierGC() + RESET);
					list.add(" Energy Provided: " + YELLOW + formatNumber(((IElectrical) te).getProvide(ForgeDirection.getOrientation(side))) + RESET + "J Energy Requested: " + YELLOW + formatNumber(((IElectrical) te).getRequest(ForgeDirection.getOrientation(side))) + RESET + "J");
				}
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof IElectricalStorage) {
					list.add(DARK_PURPLE + "" + ITALIC + "GC.IElectricalStorage:");
					list.add(" Energy Stored: " + YELLOW + formatNumber(((IElectricalStorage) te).getEnergyStored()) + RESET + "J / " + YELLOW + formatNumber(((IElectricalStorage) te).getMaxEnergyStored()) + RESET + "J");
				}
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof IEnergyStorageGC) {
					list.add(DARK_PURPLE + "" + ITALIC + "GC.IEnergyStorageGC:");
					list.add(" Energy Stored: " + YELLOW + formatNumber(((IEnergyStorageGC) te).getEnergyStoredGC()) + RESET + "J / " + YELLOW + formatNumber(((IEnergyStorageGC) te).getCapacityGC()) + RESET + "J");
				}
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof IOxygenReceiver) {
					list.add(DARK_PURPLE + "" + ITALIC + "GC.IOxygenReceiver:");
					list.add(" Oxygen Provided: " + YELLOW + formatNumber(((IOxygenReceiver) te).getOxygenProvide(ForgeDirection.getOrientation(side))) + RESET + " Oxygen Requested: " + YELLOW + formatNumber(((IOxygenReceiver) te).getOxygenRequest(ForgeDirection.getOrientation(side))) + RESET);
				}
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof IOxygenStorage) {
					list.add(DARK_PURPLE + "" + ITALIC + "GC.IOxygenStorage:");
					list.add(" Oxygen Stored: " + YELLOW + formatNumber(((IOxygenStorage) te).getOxygenStored()) + RESET + " / " + YELLOW + formatNumber(((IOxygenStorage) te).getMaxOxygenStored()) + RESET);
				}
			} catch (Exception e) {
				
			}
			
			// -=-=- Buildcraft 7 -=-=- 
			try {
				if(te instanceof IControllable) {
					list.add(DARK_PURPLE + "" + ITALIC + "BC.IControllable:");
					list.add(" Mode: " + BLUE + ((IControllable) te).getControlMode().name() + RESET);
				}
			} catch (Exception e) {
				
			}
			try {
				if(te instanceof IHeatable) {
					list.add(DARK_PURPLE + "" + ITALIC + "BC.IHeatable:");
					list.add(" Min Heat: " + YELLOW + formatNumber(((IHeatable) te).getMinHeatValue()) + RESET + "�C Max Heat: " + YELLOW + formatNumber(((IHeatable) te).getMaxHeatValue()) + RESET + "�C");
					list.add(" Current Heat: " + YELLOW + formatNumber(((IHeatable) te).getCurrentHeatValue()) + RESET + "�C Ideal Heat: " + YELLOW + formatNumber(((IHeatable) te).getIdealHeatValue()) + RESET + "�C");
				}
			} catch (Exception e) {
				
			}
		}
		
		list.add("Scanning took " + DARK_AQUA + formatNumber((System.nanoTime() - time)) + RESET + "ns.");
		
		return list;
	}
	
	public static String formatNumber(long number) {
		DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
		DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
		symbols.setGroupingSeparator('\u202F');
		return formatter.format(number);
	}
	
	public static String formatNumber(double number) {
		DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
		DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
		symbols.setGroupingSeparator('\u202F');
		return formatter.format(number);
	}
	
	public static String getFluidName(FluidStack fluid, boolean localized) {
		if(fluid == null)
			return "";
		String name = localized ? fluid.getLocalizedName() : fluid.getUnlocalizedName();
		if(name.contains("fluid.") || name.contains("tile."))
			return capitalize(name.replaceAll("fluid.", "").replaceAll("tile.", ""));
		return name;
	}
	
	public static String getFluidName(Fluid fluid, boolean localized) {
		if(fluid == null)
			return "";
		String name = localized ? fluid.getLocalizedName() : fluid.getUnlocalizedName();
		if(name.contains("fluid.") || name.contains("tile."))
			return capitalize(name.replaceAll("fluid.", "").replaceAll("tile.", ""));
		return name;
	}
	
	public static double distance(TileEntityTeleporter tile) {
		return Math.sqrt((tile.xCoord - tile.targetX) * (tile.yCoord - tile.targetY)
				+ (tile.yCoord - tile.targetY) * (tile.yCoord - tile.targetY)
				+ (tile.zCoord - tile.targetZ) * (tile.zCoord - tile.targetZ));
	}
	
	public static String capitalize(String s) {
		if(s != null && s.length() > 0)
			return s.substring(0, 1).toUpperCase() + s.substring(1);
		return "";
	}

	private Utils() {
	}

}
