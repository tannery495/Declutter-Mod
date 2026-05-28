package com.tannery495.declutterui.mixin;

import com.tannery495.declutterui.Config;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "com.mojang.realmsclient.gui.screens.RealmsNotificationsScreen")
public abstract class RealmsNotificationsScreenMixin {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void cancelRender(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, CallbackInfo ci) {
        if (Config.HIDE_REALMS.get()) {
            ci.cancel();
        }
    }
}
