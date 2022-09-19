package glowredman.fpsp.mixins.portalgun;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import portalgun.client.thread.ThreadDownloadResources;

@Mixin(ThreadDownloadResources.class)
public class ThreadDownloadResourcesMixin {

    @ModifyConstant(constant = @Constant(stringValue = "http://repo.creeperhost.net/ichun/static/assets.xml"), method = "run()V", remap = false)
    private String getAssets(String original) {
        return "https://dist.creeper.host/ichun/static/assets.xml";
    }

}
