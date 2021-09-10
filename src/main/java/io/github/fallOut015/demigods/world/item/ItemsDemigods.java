package io.github.fallOut015.demigods.world.item;

import io.github.fallOut015.demigods.MainDemigods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemsDemigods {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MainDemigods.MODID);

    public static final RegistryObject<Item> SCROLL = ITEMS.register("scroll", () -> new ScrollItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTabDemigods.TAB_DEMIGODS)));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}