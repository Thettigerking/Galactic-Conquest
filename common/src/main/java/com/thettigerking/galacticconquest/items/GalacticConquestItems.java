package com.thettigerking.galacticconquest.items;


import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.thettigerking.galacticconquest.GalacticConquest;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class GalacticConquestItems {
    public static final Supplier<RegistrarManager> MANAGER = Suppliers.memoize(() -> RegistrarManager.get(GalacticConquest.MOD_ID));

    public static final Registrar<Item> ITEMS = MANAGER.get().get(Registries.ITEM);

    public static final RegistrySupplier<Item> STEEL_INGOT = ITEMS.register(new ResourceLocation(GalacticConquest.MOD_ID, "steel_ingot"), () -> new Item(new Item.Properties()));


    public static void register() {
        // Force class loading
    }
}

