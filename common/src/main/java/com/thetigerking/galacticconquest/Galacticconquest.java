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
            AtmosphereCollision.onShipCollide();
        });


    }
}
