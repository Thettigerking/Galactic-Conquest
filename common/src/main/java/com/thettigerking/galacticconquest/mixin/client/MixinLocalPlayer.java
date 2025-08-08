    /*package com.thettigerking.galacticconquest.mixin.client;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

    @Mixin(LocalPlayer.class)
    public class MixinLocalPlayer {

        // Redirect the clamp in the turn method
        @Redirect(
                method = "turn(DD)V", // void turn(double, double)
                at = @At(
                        value = "INVOKE",
                        target = "Lnet/minecraft/util/Mth;clamp(FFF)F"
                )
        )
        private float noClamp(float value, float min, float max) {
            return value;
        }
    }

}*/
