package io.github.fallOut015.demigods.world.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeModeTabDemigods {
    public static final CreativeModeTab TAB_DEMIGODS = new CreativeModeTab("demigods") {
        public ItemStack makeIcon() {
            return new ItemStack(ItemsDemigods.SCROLL.get());
        }
    };
}