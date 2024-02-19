package me.haramcraft;

import me.haramcraft.event.PorkConsumeEvent;

public class ExampleMod {
    public static final String MOD_ID = "haramcraft";
    
    public static void init() {
        PorkConsumeEvent.init();
    }
}
