package com.tannery495.declutterui.mixin;

import com.tannery495.declutterui.Config;
import net.minecraft.client.gui.screens.BackupConfirmScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BackupConfirmScreen.class)
public class BackupConfirmScreenMixin {

    @Shadow
    protected BackupConfirmScreen.Listener onProceed;

    @Inject(method = "init", at = @At("HEAD"))
    private void skipBackupScreen(CallbackInfo ci) {
        if (Config.SKIP_WORLD_UPGRADE_BACKUP.get()) {
            this.onProceed.proceed(false, false);
        }
    }
}
