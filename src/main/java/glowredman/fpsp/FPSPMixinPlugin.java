package glowredman.fpsp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import cpw.mods.fml.relauncher.FMLLaunchHandler;
import net.minecraft.launchwrapper.Launch;
import ru.timeconqueror.spongemixins.MinecraftURLClassPath;

public class FPSPMixinPlugin implements IMixinConfigPlugin {

	@Override
	public void onLoad(String mixinPackage) {}

	@Override
	public String getRefMapperConfig() {
		return null;
	}

	@Override
	public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
		return true;
	}

	@Override
	public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}

	@Override
	public List<String> getMixins() {
		List<String> mixins = new ArrayList<>();
		
		if(FMLLaunchHandler.side().isClient()) {
			if(loadJar("[1.7.10]DamageIndicatorsMod-3.3.2.jar")) mixins.add("damageindicators.DIClientProxyMixin");
			if(loadJar("PortalGun-4.0.0-beta-6-fix-1.jar")) mixins.add("portalgun.ThreadDownloadResourcesMixin");
		}
		
		return mixins;
	}

	@Override
	public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

	@Override
	public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
	
	private static boolean loadJar(String jarname) {
		try {
			MinecraftURLClassPath.addJar(new File(Launch.minecraftHome, "mods/" + jarname));
			FPSP.LOGGER.info("Found " + jarname + "! Integrating now...");
			return true;
		} catch (Exception e) {
			FPSP.LOGGER.error("Could not find " + jarname + "! Skipping integration...");
			e.printStackTrace();
			return false;
		}
	}

}
