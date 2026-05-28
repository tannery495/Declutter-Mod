package com.tannery495.declutterui.mixin;

import com.tannery495.declutterui.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.gui.screens.multiplayer.SafetyScreen;
import net.minecraft.client.gui.screens.multiplayer.WarningScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WarningScreen.class)
public abstract class WarningScreenMixin {

    @Inject(method = "init", at = @At("HEAD"), cancellable = true)
    private void skipMultiplayerWarning(CallbackInfo ci) {
        if ((Object)this instanceof SafetyScreen && Config.HIDE_MULTIPLAYER_WARNING.get()) {
            SafetyScreenAccessor accessor = (SafetyScreenAccessor)(Object)this;
            Minecraft.getInstance().setScreen(new JoinMultiplayerScreen(accessor.getPrevious()));
            ci.cancel();
        }
    }
}
