package com.tannery495.declutterui.mixin;

import com.tannery495.declutterui.Config;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public abstract class MinecraftTelemetryMixin {
    @Inject(method = "allowsTelemetry", at = @At("HEAD"), cancellable = true)
    private void disableTelemetry(CallbackInfoReturnable<Boolean> cir) {
        if (Config.DISABLE_TELEMETRY.get()) {
            cir.setReturnValue(false);
        }
    }
}
