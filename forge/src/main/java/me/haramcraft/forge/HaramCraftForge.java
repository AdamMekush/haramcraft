package me.haramcraft.forge;

import dev.architectury.platform.forge.EventBuses;
import me.haramcraft.HaramCraft;
import me.haramcraft.forge.config.ClothConfigIntegration;
import me.haramcraft.forge.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkConstants;

@Mod(HaramCraft.MOD_ID)
public class HaramCraftForge {
    public HaramCraftForge() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClothConfigIntegration::registerModsPage);
        AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
        EventBuses.registerModEventBus(HaramCraft.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        HaramCraft.init();
    }
}
