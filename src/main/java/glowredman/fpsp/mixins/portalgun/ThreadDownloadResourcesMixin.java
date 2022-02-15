package glowredman.fpsp.mixins.portalgun;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import ichun.common.core.util.ResourceHelper;
import net.minecraft.client.Minecraft;
import portalgun.client.thread.ThreadDownloadResources;
import portalgun.common.PortalGun;

@Mixin(value = ThreadDownloadResources.class, remap = false)
public class ThreadDownloadResourcesMixin {

	/**
	 * If this thread was constructed using a separate <code>Runnable</code> run
	 * object, then that <code>Runnable</code> object's <code>run</code> method is
	 * called; otherwise, this method does nothing and returns.
	 * <p>
	 * Subclasses of <code>Thread</code> should override this method.
	 *
	 * @see #start()
	 * @see #stop()
	 * @see #Thread(ThreadGroup, Runnable, String)
	 * @author glowredman
	 * @reason [FPSP Core] Fix sound file download
	 */
	@Overwrite(remap = false)
	public void run() {
		boolean newFile = false;
		try {
			File pakFile = new File(ResourceHelper.getModsFolder(), "PortalGunSounds.pak");
			File md5File = new File(ResourceHelper.getModsFolder(), "PortalGunSounds.pak.md5");
			if (!pakFile.exists()) {
				PortalGun.proxy.downloading = true;
				downloadResource(new URL("https://dist.creeper.host/ichun/assets/pg1.7.10/PortalGunSounds.pak"), pakFile, 14885449);
				newFile = true;
				PortalGun.proxy.downloading = false;
			}
			if (!md5File.exists()) {
				PortalGun.proxy.downloading = true;
				downloadResource(new URL("https://dist.creeper.host/ichun/assets/pg1.7.10/PortalGunSounds.pak.md5"), md5File, 32);
				PortalGun.proxy.downloading = false;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (newFile) {
			PortalGun.console("Downloaded Resource Pack! Reloading resources!");
			PortalGun.proxy.loadResourcePack();
			Minecraft.getMinecraft().scheduleResourcesRefresh();
		}
	}

	@Shadow(remap = false)
	private void downloadResource(URL url, File file, long size) throws IOException {
		throw new RuntimeException("Failed to shadow ThreadDownloadResourcesMixin#downloadResource!");
	}

}
