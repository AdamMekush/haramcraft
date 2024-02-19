package me.haramcraft.forge.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.haramcraft.ExampleMod;

@Config(name = ExampleMod.MOD_ID)
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    public boolean isEnableDeath = true;

    @ConfigEntry.Gui.Tooltip
    public boolean isEnableExplosion = false;

    @ConfigEntry.Gui.Tooltip
    public boolean isEnableTeleportation = false;

    @ConfigEntry.Gui.Tooltip
    public float explosionPower = 5;

}
