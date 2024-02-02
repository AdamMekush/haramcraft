package com.slide_am.event;


import com.slide_am.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.TypedActionResult;

import static net.minecraft.world.World.ExplosionSourceType.TNT;
import static net.minecraft.world.World.NETHER;

public class PorkConsumeEvent {

    public static void init(){

        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

        UseItemCallback.EVENT.register((player, world, hand) -> {
            if(!world.isClient){
                if(world.getRegistryKey() != NETHER){
                    if(player.getStackInHand(hand).getItem() == Items.PORKCHOP ||
                            player.getStackInHand(hand).getItem() == Items.COOKED_PORKCHOP
                    ){
                        player.sendMessage(Text.of(String.valueOf(config.explosionPower)));
                        if(config.enableExplosion){
                            world.createExplosion(player, player.getX(), player.getY(), player.getZ(), config.explosionPower, TNT);
                        }

                        if(config.enableTeleportation){
                            ServerWorld nether = player.getServer().getWorld(NETHER);
                            player.teleport(nether, player.getX(), player.getY(), player.getZ(), null, player.getYaw(), player.getPitch());
                        }
                    }
                }
            }
            return TypedActionResult.pass(ItemStack.EMPTY);
        });
    }
}
