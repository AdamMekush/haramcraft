package me.haramcraft.event;

import dev.architectury.event.CompoundEventResult;
import dev.architectury.event.events.common.InteractionEvent;
import me.haramcraft.config.Config;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import static net.minecraft.world.level.Level.NETHER;

public class PorkConsumeEvent {

    public static void init() {

        InteractionEvent.RIGHT_CLICK_ITEM.register((Player player, InteractionHand hand) -> {

            Config config = Config.getConfig();
            if (!player.getCommandSenderWorld().isClientSide) {
                ServerLevel nether = player.getServer().getLevel(NETHER);
                if (player.getServer().isNetherEnabled() && player.getCommandSenderWorld() != nether) {
                    if (player.getMainHandItem().is(Items.PORKCHOP) || player.getMainHandItem().is(Items.COOKED_PORKCHOP)) {
                        if (config.isDeathEnabled()) {
                            player.kill();
                        }
                        if (config.isTeleportationEnabled()) {
                            player.teleportTo(nether, player.getX(), player.getY(), player.getZ(), null, 0, 0);
                        }
                        if (config.isExplosionEnabled()) {
                            player.getCommandSenderWorld().explode(player, player.getX(), player.getY(), player.getZ(), config.getExplosionPower(), Level.ExplosionInteraction.TNT);
                        }
                    }
                }
            }
            return CompoundEventResult.pass();
        });
    }
}
