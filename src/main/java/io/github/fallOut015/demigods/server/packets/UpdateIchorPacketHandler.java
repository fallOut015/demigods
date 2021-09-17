package io.github.fallOut015.demigods.server.packets;

import io.github.fallOut015.demigods.client.render.ScreenRendererDemigods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateIchorPacketHandler extends PacketHandlerDemigods {
    public static final int ID = PacketHandlerDemigods.getNewID();
    private final int ichorAmount;

    public UpdateIchorPacketHandler(final int ichorAmount) {
        super(ID);

        this.ichorAmount = ichorAmount;
    }

    public static void encoder(UpdateIchorPacketHandler msg, FriendlyByteBuf buffer) {
        buffer.writeInt(msg.ichorAmount);
    }
    public static UpdateIchorPacketHandler decoder(FriendlyByteBuf buffer) {
        return new UpdateIchorPacketHandler(buffer.readInt());
    }
    public static void handle(UpdateIchorPacketHandler msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ScreenRendererDemigods.ichorAmount = msg.ichorAmount;
        });

        ctx.get().setPacketHandled(true);
    }
}