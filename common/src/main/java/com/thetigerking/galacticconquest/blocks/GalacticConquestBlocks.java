package com.thetigerking.galacticconquest.blocks;

import com.thetigerking.galacticconquest.GalacticConquest;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class GalacticConquestBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(GalacticConquest.MOD_ID, Registries.BLOCK);

    public static void initBlocks(){

    }

    public static RegistrySupplier<Block> registerBlock(String name, Supplier<Block> block){
        return BLOCKS.register(ResourceLocation.fromName(GalacticConquest.MOD_ID))
    }
}
