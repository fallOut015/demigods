package io.github.fallOut015.demigods.common.capabilities;

import io.github.fallOut015.demigods.server.packets.PacketHandlerDemigods;
import io.github.fallOut015.demigods.server.packets.UpdateIchorPacketHandler;
import io.github.fallOut015.demigods.server.packets.UpdateImmortalityPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fmllegacy.network.NetworkDirection;

public class Abilities implements IAbilities {
    private int ichor;
    private boolean immortal;

    public Abilities() {
        this.ichor = 0;
    }

    @Override
    public void setIchor(int ichor) {
        this.ichor = ichor;
        PacketHandlerDemigods.INSTANCE.sendTo(new UpdateIchorPacketHandler(ichor), Minecraft.getInstance().getConnection().getConnection(), NetworkDirection.PLAY_TO_CLIENT);
    }
    @Override
    public int getIchor() {
        return this.ichor;
    }

    @Override
    public void setIsImmortal(boolean immortal) {
        this.immortal = immortal;
        PacketHandlerDemigods.INSTANCE.sendTo(new UpdateImmortalityPacketHandler(immortal), Minecraft.getInstance().getConnection().getConnection(), NetworkDirection.PLAY_TO_CLIENT);
    }
    @Override
    public boolean getIsImmortal() {
        return this.immortal;
    }
}