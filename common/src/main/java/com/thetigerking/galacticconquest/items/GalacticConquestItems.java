package com.thetigerking.galacticconquest.items;


import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.thetigerking.galacticconquest.GalacticConquest;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class GalacticConquestItems {
    public static final Supplier<RegistrarManager> MANAGER = Suppliers.memoize(() -> RegistrarManager.get(GalacticConquest.MOD_ID));

    Registrar<Item> items = MANAGER.get().get(Registries.ITEM);
    RegistrySupplier<Item> steel_ingot = items.register(new ResourceLocation(GalacticConquest.MOD_ID, "steel_ingot  "), () -> new Item(new Item.Properties()));

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(GalacticConquest.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> steel_Ingot = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties()));


    public static void register() {
    }
}

