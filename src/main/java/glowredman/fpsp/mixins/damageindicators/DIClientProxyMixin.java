package glowredman.fpsp.mixins.damageindicators;

import DamageIndicatorsMod.client.DIClientProxy;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(DIClientProxy.class)
public class DIClientProxyMixin {
    
    /**
     * @author glowredman
     * @reason Disable update check
     */
    @Overwrite(remap = false)
    public void trysendmessage() {}

}
