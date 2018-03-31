package com.marcus8448.mod;

import net.minecraftforge.common.config.Configuration;
import com.marcus8448.mod.utils.Logger;

public class Config {

    private static final String CATEGORY_GENERAL = "general";

    public static boolean doYouLikeThisMod = true;

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
     
    }
}