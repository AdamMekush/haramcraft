package me.haramcraft.forge.config;

import me.haramcraft.HaramCraft;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = HaramCraft.MOD_ID)
public class ModConfig implements ConfigData {

    public boolean isDeathEnabled = true;

    @ConfigEntry.Gui.CollapsibleObject
    InnerStuff fun = new InnerStuff();

    @ConfigEntry.Gui.Excluded
    InnerStuff invisibleStuff = new InnerStuff();

    static class InnerStuff {

        public boolean isExplosionEnabled = false;

        public boolean isTeleportationEnabled = false;

        public float explosionPower = 5;
    }

}
