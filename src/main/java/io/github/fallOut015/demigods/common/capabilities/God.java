package io.github.fallOut015.demigods.common.capabilities;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class God {
    private static final Map<String, God> GODS_MAP = new HashMap<>();

    private final String id;
    private final Component translatedName;

    public God(final String id) {
        this.id = id;
        this.translatedName = new TranslatableComponent("god." + this.id + ".name");

        God.GODS_MAP.put(this.id, this);
    }

    public final String getID() {
        return this.id;
    }
    public final Component getTranslatedName() {
        return this.translatedName;
    }

    public static God getGodAt(int index) {
        return God.GODS_MAP.values().toArray(God[]::new)[index];
    }
    public static God getRandomGod(Random random) {
        return God.getGodAt(random.nextInt(God.GODS_MAP.size()));
    }
    public static God fromID(String id) {
        return God.GODS_MAP.get(id);
    }
    public static int getGodsNumber() {
        return God.GODS_MAP.size();
    }
}