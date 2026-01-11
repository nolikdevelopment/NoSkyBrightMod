package org.dev.noskybrightmod.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.renderer.LightTexture;

import org.dev.noskybrightmod.NoSkyBrightMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LightTexture.class)
public class MixinLightTexture {
    @ModifyExpressionValue(method = "updateLightTexture", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GameRenderer;getDarkenWorldAmount(F)F"))
    private float aVoid(float original) {
        if (NoSkyBrightMod.isBright) {
            return -9999999f;
        }
        return original;
    }
}