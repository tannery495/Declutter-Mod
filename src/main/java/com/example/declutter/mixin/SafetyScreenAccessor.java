package com.example.declutter.mixin;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.multiplayer.SafetyScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SafetyScreen.class)
public interface SafetyScreenAccessor {
    @Accessor("previous")
    Screen getPrevious();
}
