package me.haramcraft.config;

import com.google.gson.Gson;
import dev.architectury.platform.Platform;
import me.haramcraft.HaramCraft;

import java.io.*;

public class Config {

    private boolean isDeathEnabled;

    private boolean isExplosionEnabled;

    private boolean isTeleportationEnabled;

    private float explosionPower;

    public boolean isDeathEnabled() {
        return isDeathEnabled;
    }

    public boolean isExplosionEnabled() {
        return isExplosionEnabled;
    }

    public boolean isTeleportationEnabled() {
        return isTeleportationEnabled;
    }

    public float getExplosionPower() {
        return explosionPower;
    }

    public static Config getConfig() {

        File configFile = Platform.getConfigFolder().resolve(HaramCraft.MOD_ID + ".json").toFile();

        Gson gson = new Gson();

        try (Reader reader = new FileReader(configFile)) {
            return gson.fromJson(reader, Config.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
