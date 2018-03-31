package com.marcus8448.mod;

import java.io.File;

import com.marcus8448.mod.items.Items;
import com.marcus8448.mod.proxy.CommonProxy;
import com.marcus8448.mod.utils.Constants;
import com.marcus8448.mod.utils.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Constants.MODID, name = Constants.NAME, version = Constants.VERSION, useMetadata = false, acceptedMinecraftVersions = Constants.MCV)



public class Marcus8448Mod {
    @SidedProxy(clientSide = Constants.CLIENT_PROXY, serverSide = Constants.COMMON_PROXY)
    public static CommonProxy proxy;
    
    public static Configuration config;
    @Instance
    public static Marcus8448Mod instance;
    
    public static final ToolMaterial GLASS = EnumHelper.addToolMaterial("GLASS", 4, 3122, 50.0F, 50.0F, 5 );
    
    public static CreativeTabs marcus8448Tab = new CreativeTabs("tab_marcus8448") {
        
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.BLUE_BOOK);
        }
        
    };
        
    @EventHandler
       public void preInit(FMLPreInitializationEvent event)
    {
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "marcus8448mod.cfg"));
        Config.readConfig();

        
        
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {    

        Logger.getLogger().info("marcus8448's Mod is now Initilizing!");
        if(Loader.isModLoaded("galacticraftcore")) {
            Logger.getLogger().info("Hiya, Galacticraft!");
        }
        else {
             Logger.getLogger().info("Get ready to say wow!");
        }

    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
       {
        
        Logger.getLogger().info("marcus8448's Mod is (finally) Post-Initilizing!");
        if (Config.doYouLikeThisMod == false) {
            Logger.getLogger().error("Pleae give feedback on why you don't like this ;-;");
        }

     }
    
    
    }
