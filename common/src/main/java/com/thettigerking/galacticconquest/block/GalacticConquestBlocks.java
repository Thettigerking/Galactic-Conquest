package com.thettigerking.galacticconquest.block;

import com.google.common.base.Suppliers;
import com.thettigerking.galacticconquest.GalacticConquest;
import com.thettigerking.galacticconquest.items.GalacticConquestItems;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class GalacticConquestBlocks {
    public static final com.google.common.base.Supplier<RegistrarManager> MANAGER = Suppliers.memoize(() -> RegistrarManager.get(GalacticConquest.MOD_ID));

    private static final Registrar<Block> BLOCKS = MANAGER.get().get(Registries.BLOCK);

    public static final RegistrySupplier<Block> MARTIANSTONE = registerBlock(
            "martianstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                   // .friction(.6f)
                    .ignitedByLava()
                    .destroyTime(5)
            )
    );

    private static <T extends Block> RegistrySupplier<T> registerBlock(String name, Supplier<T> block) {
        RegistrySupplier<T> toReturn = BLOCKS.register(
                new ResourceLocation(GalacticConquest.MOD_ID, name),
                block
        );
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistrySupplier<Item> registerBlockItem(String name, RegistrySupplier<T> block) {
        return GalacticConquestItems.ITEMS.register(
                new ResourceLocation(GalacticConquest.MOD_ID, name),
                () -> new BlockItem(
                    block.get(),
                    new Item.Properties()
                )
        );
    }

    public static void register(){
        // Force class loading
    }
}
