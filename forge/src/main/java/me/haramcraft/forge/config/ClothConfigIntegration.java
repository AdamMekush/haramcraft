package me.haramcraft.forge.config;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModLoadingContext;

public class ClothConfigIntegration {
    public static void registerModsPage() {
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> {
            return new ConfigScreenHandler.ConfigScreenFactory((client, parent) -> {
                //return ClothConfigDemo.getConfigBuilderWithDemo().setParentScreen(parent).build();
                return AutoConfig.getConfigScreen(ModConfig.class, parent).get();
            });
        });
    }
}
