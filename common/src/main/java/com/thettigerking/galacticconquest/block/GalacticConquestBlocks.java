package com.thettigerking.galacticconquest.block;

import com.thettigerking.galacticconquest.GalacticConquest;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class GalacticConquestBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(GalacticConquest.MOD_ID, Registries.BLOCK);

    public static void initBlocks(){

    }

    //Register a block
    public static RegistrySupplier<Block> registerBlock(String name, Supplier<Block> block){
        return BLOCKS.register(
                new ResourceLocation(GalacticConquest.MOD_ID, "martianstone"),
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                        .friction(0)
                        .ignitedByLava()
                        .destroyTime(5)
                )
        );
    }
}
