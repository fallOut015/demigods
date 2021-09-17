package io.github.fallOut015.demigods.server.packets;

import io.github.fallOut015.demigods.MainDemigods;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fmllegacy.network.NetworkRegistry;
import net.minecraftforge.fmllegacy.network.simple.SimpleChannel;

@Mod.EventBusSubscriber
public abstract class PacketHandlerDemigods {
    private static int ids = 0;
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
        new ResourceLocation(MainDemigods.MODID, "main"),
        () -> PROTOCOL_VERSION,
        PROTOCOL_VERSION::equals,
        PROTOCOL_VERSION::equals
    );

    final int id;

    protected PacketHandlerDemigods(int id) {
        this.id = id;
    }

    public static int getNewID() {
        return ids++;
    }

    @SubscribeEvent
    public static void setup(final FMLCommonSetupEvent event) {
        INSTANCE.registerMessage(UpdateIchorPacketHandler.ID, UpdateIchorPacketHandler.class, UpdateIchorPacketHandler::encoder, UpdateIchorPacketHandler::decoder, UpdateIchorPacketHandler::handle);
        INSTANCE.registerMessage(UpdateImmortalityPacketHandler.ID, UpdateImmortalityPacketHandler.class, UpdateImmortalityPacketHandler::encoder, UpdateImmortalityPacketHandler::decoder, UpdateImmortalityPacketHandler::handle);
    }
}