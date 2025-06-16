package com.thettigerking.galacticconquest;

import com.thettigerking.galacticconquest.event.AtmosphereCollision;
import dev.architectury.event.events.common.TickEvent;
import net.minecraft.server.level.ServerLevel;

public final class GalacticConquest {
    public static final String MOD_ID = "GalacticConquest";

    public static void init() {
        TickEvent.ServerLevelTick.SERVER_LEVEL_POST.register((ServerLevel serverLevel) -> {
        // makes sure it doesn't run multiple times for tick, error for some reason, idk why
         /*   if (event.phase != TickEvent.Phase.END) {
               return; */
                AtmosphereCollision.onShipCollide();
        });


    }
}
