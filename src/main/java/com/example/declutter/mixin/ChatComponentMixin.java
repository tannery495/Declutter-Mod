package com.example.declutter.mixin;

import com.example.declutter.Config;
import net.minecraft.client.GuiMessage;
import net.minecraft.client.GuiMessageTag;
import net.minecraft.client.gui.components.ChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChatComponent.class)
public abstract class ChatComponentMixin {

    @Redirect(
        method = "render",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/GuiMessage$Line;tag()Lnet/minecraft/client/GuiMessageTag;"
        )
    )
    private GuiMessageTag suppressChatTag(GuiMessage.Line line) {
        if (Config.HIDE_CHAT_INDICATORS.get()) return null;
        return line.tag();
    }
}
