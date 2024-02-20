package me.haramcraft;

import me.haramcraft.event.PorkConsumeEvent;

public class HaramCraft {
    public static final String MOD_ID = "haramcraft";

    public static void init() {
        PorkConsumeEvent.init();
    }
}
