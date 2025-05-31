package com.thetigerking.galacticconquest.forge;

import com.thetigerking.galacticconquest.Galacticconquest;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Galacticconquest.MOD_ID)
public final class GalacticconquestForge {
    public GalacticconquestForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(Galacticconquest.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        Galacticconquest.init();
    }
}
