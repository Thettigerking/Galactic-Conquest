package com.thettigerking.galacticconquest.mixin;

import com.thettigerking.galacticconquest.GalacticConquest;
import com.thettigerking.galacticconquest.data.GalacticConquestDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Shadow
    private Level level;

    @Inject(method = "onBelowWorld", at = @At("HEAD"), cancellable = true)
    private void onBelowWorldMixin(CallbackInfo ci) {
        if(!GalacticConquestDimensions.shouldVoidKillYou(level.dimension().location())) {
            ci.cancel();
        }
    }
}
