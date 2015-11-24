package net.lomeli.power.lib;

import net.lomeli.lomlib.core.config.annotations.ConfigBoolean;

public class Config {
    @ConfigBoolean(defaultValue = false)
    public static boolean checkForUpdates;
}
