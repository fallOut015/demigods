package io.github.fallOut015.demigods.world.item;

import io.github.fallOut015.demigods.MainDemigods;
import io.github.fallOut015.demigods.common.capabilities.CapabilitiesDemigods;
import io.github.fallOut015.demigods.common.capabilities.god.God;
import net.minecraft.ChatFormatting;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ScrollItem extends Item {
    public ScrollItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        return true;
    }
    @Override
    public void fillItemCategory(CreativeModeTab creativeModeTab, NonNullList<ItemStack> itemStacks) {
        if(this.allowdedIn(creativeModeTab)) {
            for(int i = 0; i < God.getGodsNumber(); ++ i) {
                ItemStack scroll = new ItemStack(ItemsDemigods.SCROLL.get());
                ScrollItem.setGod(scroll, God.getGodAt(i));
                itemStacks.add(scroll);
            }
        }
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if(!level.isClientSide()) {
            player.getCapability(CapabilitiesDemigods.ABILITIES).ifPresent(abilities -> {
                abilities.setIsImmortal(true);
                abilities.setIchor(100);
            });
            MainDemigods.LOGGER.info("Your parent god is " + ScrollItem.getGod(player.getItemInHand(interactionHand)).getTranslatedName() + "!");
        }
        return super.use(level, player, interactionHand);
    }
    @Override
    public Component getName(ItemStack itemStack) {
        if(ScrollItem.hasGod(itemStack)) {
            return new TranslatableComponent("item.demigods.scroll." + ScrollItem.getGod(itemStack).getID()).withStyle(ChatFormatting.YELLOW);
        } else {
            return super.getName(itemStack);
        }
    }
    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        if(ScrollItem.hasGod(itemStack)) {
            components.add(ScrollItem.getGod(itemStack).getTranslatedName());
        }
        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }

    public static boolean hasGod(ItemStack itemStack) {
        return itemStack.getOrCreateTag().contains("id");
    }
    public static God getGod(ItemStack itemStack) {
        return God.fromID(itemStack.getOrCreateTag().getString("id"));
    }
    public static void setGod(ItemStack itemStack, final God god) {
        itemStack.getOrCreateTag().putString("id", god.getID());
    }
}