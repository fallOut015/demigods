package io.github.fallOut015.demigods.common.capabilities;

import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AbilitiesProvider implements ICapabilityProvider {
    private LazyOptional<IAbilities> abilities;

    public AbilitiesProvider(IAbilities abilities) {
        this.abilities = LazyOptional.of(() -> abilities);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == CapabilitiesDemigods.ABILITIES ? (LazyOptional<T>) this.abilities : LazyOptional.empty();
    }
}