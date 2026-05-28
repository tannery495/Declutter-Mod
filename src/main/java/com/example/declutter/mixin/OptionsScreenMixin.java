package com.example.declutter.mixin;

import com.example.declutter.Config;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(OptionsScreen.class)
public abstract class OptionsScreenMixin {

    @Redirect(
        method = "init",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/layouts/GridLayout$RowHelper;addChild(Lnet/minecraft/client/gui/layouts/LayoutElement;)Lnet/minecraft/client/gui/layouts/LayoutElement;",
            ordinal = 8
        )
    )
    private LayoutElement skipTelemetryButton(GridLayout.RowHelper rowHelper, LayoutElement element) {
        if (Config.DISABLE_TELEMETRY.get()) return element;
        return rowHelper.addChild(element);
    }

    @Redirect(
        method = "init",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/layouts/GridLayout$RowHelper;addChild(Lnet/minecraft/client/gui/layouts/LayoutElement;)Lnet/minecraft/client/gui/layouts/LayoutElement;",
            ordinal = 9
        )
    )
    private LayoutElement skipCreditsButton(GridLayout.RowHelper rowHelper, LayoutElement element) {
        if (Config.HIDE_CREDITS.get()) return element;
        return rowHelper.addChild(element);
    }
}
