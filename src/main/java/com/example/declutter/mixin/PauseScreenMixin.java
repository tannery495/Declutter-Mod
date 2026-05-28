package com.example.declutter.mixin;

import com.example.declutter.Config;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.gui.screens.PauseScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PauseScreen.class)
public abstract class PauseScreenMixin {

    @Redirect(
        method = "addFeedbackButtons",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/layouts/GridLayout$RowHelper;addChild(Lnet/minecraft/client/gui/layouts/LayoutElement;)Lnet/minecraft/client/gui/layouts/LayoutElement;"
        )
    )
    private static LayoutElement skipFeedbackButtonAdd(GridLayout.RowHelper rowHelper, LayoutElement element) {
        if (Config.HIDE_FEEDBACK_BUTTONS.get()) return element;
        return rowHelper.addChild(element);
    }
}
