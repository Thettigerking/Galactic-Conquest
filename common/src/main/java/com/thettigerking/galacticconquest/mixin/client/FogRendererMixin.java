package com.thettigerking.galacticconquest.mixin.client;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.thettigerking.galacticconquest.data.GalacticConquestDimensions;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.FogRenderer.FogMode;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = FogRenderer.class, priority = 910)
public class FogRendererMixin {

    @Inject(method = "setupFog", at = @At("RETURN"))
    private static void onSetupFogMixin(Camera camera, FogRenderer.FogMode fogMode, float farPlaneDistance, boolean bl, float f, CallbackInfo ci) {
        final Entity entity = camera.getEntity();

        if (fogMode == FogMode.FOG_TERRAIN && !GalacticConquestDimensions.shouldHaveFog(entity.level().dimension().location())) {
            RenderSystem.setShaderFogStart(-8.0F);
            RenderSystem.setShaderFogEnd(1_000_000.0F);
            RenderSystem.setShaderFogShape(FogShape.CYLINDER);
        }
    }
}

