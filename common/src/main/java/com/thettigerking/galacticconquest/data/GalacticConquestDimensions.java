package com.thettigerking.galacticconquest.data;

import com.thettigerking.galacticconquest.GalacticConquest;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class GalacticConquestDimensions {
    public static final ResourceKey<Level> SOLAR_SYSTEM_KEY = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(GalacticConquest.MOD_ID, "solar_system"));

    public static final ResourceKey<DimensionType> SOLAR_SYSTEM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(GalacticConquest.MOD_ID, "solar_system"));

    public static boolean shouldHaveFog(ResourceLocation levelResourceLocation) {
        if (levelResourceLocation.equals(
            GalacticConquestDimensions.SOLAR_SYSTEM_KEY.location()
        )) {
            return false;
        }
        return true;
    }

    public static boolean shouldOnlyRenderStars(ResourceLocation levelResourceLocation) {
        if (levelResourceLocation.equals(
                GalacticConquestDimensions.SOLAR_SYSTEM_KEY.location()
        )) {
            return true;
        }
        return false;
    }

    public static boolean shouldVoidKillYou(ResourceLocation levelResourceLocation) {
        if (levelResourceLocation.equals(
                GalacticConquestDimensions.SOLAR_SYSTEM_KEY.location()
        )) {
            return false;
        }
        return true;
    }
}
