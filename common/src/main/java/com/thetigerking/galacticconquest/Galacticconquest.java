package com.thetigerking.galacticconquest;

import com.thetigerking.galacticconquest.event.AtmosphereCollision;
import dev.architectury.event.events.common.TickEvent;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;

public final class Galacticconquest {
    public static final String MOD_ID = "galacticconquest";

    public static void init() {
        TickEvent.ServerLevelTick.SERVER_LEVEL_POST.register((ServerLevel serverLevel) -> {
        // makes sure it doesn't run multiple times for tick, error for some reason, idk why
         /*   if (event.phase != TickEvent.Phase.END) {
               return; */
                AtmosphereCollision.onShipCollide();
        });


    }
}
