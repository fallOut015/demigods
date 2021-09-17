package io.github.fallOut015.demigods.client.render;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ScreenRendererDemigods {
    public static int ichorAmount;
    public static boolean isImmortal;

    @SubscribeEvent
    public static void onRenderGameOverlay(final RenderGameOverlayEvent event) {
        if(event.getType().equals(RenderGameOverlayEvent.ElementType.ALL)) {
            if(Minecraft.getInstance().player != null) {
                if(ScreenRendererDemigods.isImmortal) {
                    System.out.println("Player has " + ScreenRendererDemigods.ichorAmount + " ichor");
                }
            }
        }
    }
}