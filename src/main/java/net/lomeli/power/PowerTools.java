package net.lomeli.power;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.lomeli.lomlib.core.config.ModConfig;
import net.lomeli.lomlib.core.version.VersionChecker;
import net.lomeli.lomlib.util.LogHelper;

import net.lomeli.power.core.Proxy;
import net.lomeli.power.lib.Config;

@Mod(modid = PowerTools.MOD_ID, name = PowerTools.MOD_NAME, version = PowerTools.VERSION, dependencies = PowerTools.DEPENDENCIES)
public class PowerTools {
    public static final String MOD_ID = "powertools", MOD_NAME = "Power Tools", DEPENDENCIES = "required-after:LomLib";
    public static final int MAJOR = 1, MINOR = 0, REV = 0;
    public static final String VERSION = MAJOR + "." + MINOR + "." + REV,
            PROXY = "net.lomeli.power.core.Proxy", CLIENT = "net.lomeli.power.client.ClientProxy",
            UPDATE_URL = "";

    @SidedProxy(serverSide = PROXY, clientSide = CLIENT)
    public static Proxy proxy;

    @Mod.Instance
    public static PowerTools modInstance;

    public static LogHelper log = LogHelper.createLogger(MOD_NAME);
    public static VersionChecker versionChecker;
    public static ModConfig config;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        config = new ModConfig(MOD_ID, event.getSuggestedConfigurationFile(), Config.class);
        config.loadConfig();
        versionChecker = new VersionChecker(UPDATE_URL, MOD_ID, MOD_NAME, MAJOR, MINOR, REV);
        if (Config.checkForUpdates)
            new Thread(versionChecker).start();
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }
}
