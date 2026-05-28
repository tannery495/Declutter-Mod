package com.example.declutter.mixin;

import com.example.declutter.Config;
import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import net.minecraft.client.gui.screens.worldselection.ConfirmExperimentalFeaturesScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ConfirmExperimentalFeaturesScreen.class)
public abstract class ConfirmExperimentalFeaturesScreenMixin {

    @Shadow
    private BooleanConsumer callback;

    @Inject(method = "init", at = @At("HEAD"), cancellable = true)
    private void skipExperimentalWarning(CallbackInfo ci) {
        if (Config.SKIP_EXPERIMENTAL_WARNING.get()) {
            this.callback.accept(true);
            ci.cancel();
        }
    }
}
