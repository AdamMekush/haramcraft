package me.haramcraft.config;

import com.google.gson.Gson;
import dev.architectury.platform.Platform;
import me.haramcraft.ExampleMod;

import java.io.*;

public class Config {
    private boolean isEnableDeath;
    private boolean isEnableExplosion;
    private boolean isEnableTeleportation;
    private float explosionPower;
    public boolean isEnableDeath() {
        return isEnableDeath;
    }

    public boolean isEnableExplosion() {
        return isEnableExplosion;
    }

    public boolean isEnableTeleportation() {
        return isEnableTeleportation;
    }

    public float getExplosionPower() {
        return explosionPower;
    }

    public static Config getConfig(){

        File configFile = Platform.getConfigFolder().resolve(ExampleMod.MOD_ID + ".json").toFile();

        Gson gson = new Gson();

        try(Reader reader = new FileReader(configFile)) {
            return gson.fromJson(reader, Config.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
