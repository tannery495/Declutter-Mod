package com.example.declutter.mixin;

import com.example.declutter.Config;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RecipeBookComponent.class)
public abstract class RecipeBookComponentMixin {

    @Shadow public abstract boolean isVisible();
    @Shadow protected abstract void setVisible(boolean visible);

    @Inject(method = "init", at = @At("RETURN"))
    private void forceHideRecipeBook(CallbackInfo ci) {
        if (Config.HIDE_RECIPE_BOOK.get() && isVisible()) {
            setVisible(false);
        }
    }
}
