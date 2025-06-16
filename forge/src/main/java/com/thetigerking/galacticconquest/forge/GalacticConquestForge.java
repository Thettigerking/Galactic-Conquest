package com.thetigerking.galacticconquest.forge;

import com.thetigerking.galacticconquest.GalacticConquest;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GalacticConquest.MOD_ID)
public final class GalacticConquestForge {
    public GalacticConquestForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(GalacticConquest.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        GalacticConquest.init();
    }
}
