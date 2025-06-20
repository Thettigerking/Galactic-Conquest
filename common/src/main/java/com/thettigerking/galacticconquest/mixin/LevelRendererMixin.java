package com.thettigerking.galacticconquest.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.thettigerking.galacticconquest.data.GalacticConquestDimensions;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LevelRenderer;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import javax.annotation.Nullable;
// Sets the solar system dimension to black
@Mixin(LevelRenderer.class)
public class LevelRendererMixin {

    @Shadow
    @Nullable
    private ClientLevel level;

    @Shadow @Nullable private VertexBuffer starBuffer;

    @WrapOperation(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/FogRenderer;setupColor(Lnet/minecraft/client/Camera;FLnet/minecraft/client/multiplayer/ClientLevel;IF)V"))
    private void clearFog(Camera camera, float f, ClientLevel clientLevel, int i, float g, Operation<Void> original) {
        if (!GalacticConquestDimensions.shouldHaveFog(clientLevel.dimension().location())) {
            original.call(camera, f, clientLevel, i, g);
            return;
        }
        RenderSystem.clearColor(0.0f,0.0f,0.0f,0.0f);
    }

    @WrapOperation(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/LevelRenderer;renderSky(Lcom/mojang/blaze3d/vertex/PoseStack;Lorg/joml/Matrix4f;FLnet/minecraft/client/Camera;ZLjava/lang/Runnable;)V"))
    private void onlyRenderStars(LevelRenderer instance, PoseStack poseStack, Matrix4f projectionMatrix, float f, Camera camera, boolean bl, Runnable runnable, Operation<Void> original) {
        if (!GalacticConquestDimensions.shouldOnlyRenderStars(level.dimension().location())) {
            original.call(instance, poseStack, projectionMatrix, f, camera, bl, runnable);
            return;
        }
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        FogRenderer.setupNoFog();
        this.starBuffer.bind();
        this.starBuffer.drawWithShader(poseStack.last().pose(), projectionMatrix, GameRenderer.getPositionShader());
        VertexBuffer.unbind();
    }
}