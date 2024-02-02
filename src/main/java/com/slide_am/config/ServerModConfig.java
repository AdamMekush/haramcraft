package com.slide_am.config;


import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "haramcraft")
public class ServerModConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public boolean enableExplosion = false;

    @ConfigEntry.Gui.Tooltip
    public boolean enableTeleportation = true;

    @ConfigEntry.Gui.Tooltip
    public float explosionPower = 5;
}
