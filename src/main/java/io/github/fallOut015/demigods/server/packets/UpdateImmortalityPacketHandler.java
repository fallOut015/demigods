package io.github.fallOut015.demigods.server.packets;

import io.github.fallOut015.demigods.client.render.ScreenRendererDemigods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateImmortalityPacketHandler extends PacketHandlerDemigods {
    public static final int ID = PacketHandlerDemigods.getNewID();
    private final boolean isImmortal;

    public UpdateImmortalityPacketHandler(final boolean isImmortal) {
        super(ID);

        this.isImmortal = isImmortal;
    }

    public static void encoder(UpdateImmortalityPacketHandler msg, FriendlyByteBuf buffer) {
        buffer.writeBoolean(msg.isImmortal);
    }
    public static UpdateImmortalityPacketHandler decoder(FriendlyByteBuf buffer) {
        return new UpdateImmortalityPacketHandler(buffer.readBoolean());
    }
    public static void handle(UpdateImmortalityPacketHandler msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ScreenRendererDemigods.isImmortal = msg.isImmortal;
        });

        ctx.get().setPacketHandled(true);
    }
}