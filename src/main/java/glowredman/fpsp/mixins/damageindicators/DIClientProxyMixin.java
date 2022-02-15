package glowredman.fpsp.mixins.damageindicators;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(targets = "DamageIndicatorsMod.client.DIClientProxy$1", remap = false)
public class DIClientProxyMixin {

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
	 * @reason [FPSP Core] Disable version check
	 */
	@Overwrite(remap = false)
	public void run() {}

}
