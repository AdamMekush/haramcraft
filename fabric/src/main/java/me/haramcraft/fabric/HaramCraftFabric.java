package me.haramcraft.fabric;

import me.haramcraft.HaramCraft;
import me.haramcraft.fabric.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class HaramCraftFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
        HaramCraft.init();
    }
}
