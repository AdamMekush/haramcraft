package com.slide_am.config;


import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "haramcraft")
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    public boolean enableDeath = true;

    @ConfigEntry.Gui.Tooltip
    public boolean enableExplosion = false;

    @ConfigEntry.Gui.Tooltip
    public boolean enableTeleportation = false;

    @ConfigEntry.Gui.Tooltip
    public float explosionPower = 5;
}
