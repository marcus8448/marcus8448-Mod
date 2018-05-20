package com.marcus8448.mod;

import net.minecraftforge.common.config.Configuration;
import com.marcus8448.mod.utils.Logger;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-0.0.0_preAlpha1
 *
 */
public class Config {

    private static final String CATEGORY_GENERAL = "general";

    public static boolean doYouLikeThisMod = true;
    public static boolean sendMessageOnStartup = true;

    public static void readConfig() {
        Configuration cfg = Marcus8448Mod.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
        } catch (Exception e) {
            Logger.getLogger().error("Problem loading config file!", e);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        doYouLikeThisMod = cfg.getBoolean("awesomeMod", CATEGORY_GENERAL, doYouLikeThisMod, "Set to false if you don't like this mod");
        sendMessageOnStartup = cfg.getBoolean("startupMessage", CATEGORY_GENERAL, sendMessageOnStartup, "Set to false if you don't want a message when you join your world");
     
    }
}