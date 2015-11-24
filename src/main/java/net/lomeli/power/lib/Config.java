package net.lomeli.power.lib;

import net.lomeli.lomlib.core.config.annotations.ConfigBoolean;
import net.lomeli.lomlib.core.config.annotations.ConfigInt;

public class Config {
    @ConfigBoolean(defaultValue = false)
    public static boolean checkForUpdates;
    @ConfigInt(defaultValue = 1000)
    public static int fusionCoreCapacity;
}
