package com.marcus8448.mod;

import java.io.File;

import com.marcus8448.mod.handlers.*;
import com.marcus8448.mod.items.ItemThrowableTNT;
import com.marcus8448.mod.items.MMItems;
import com.marcus8448.mod.proxy.CommonProxy;
import com.marcus8448.mod.tabs.*;
import com.marcus8448.mod.utils.*;
import com.marcus8448.mod.entity.projectile.*;

import net.minecraft.block.BlockDispenser;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;


/**
 * 
 * https://marcus8448.com/mods/marcus8448-mod/
 * @author marcus8448
 *  
 */
@Mod(modid = Constants.MODID, name = Constants.NAME, version = Constants.VERSION, useMetadata = false, acceptedMinecraftVersions = Constants.MCV)
public class Marcus8448Mod {
    @SidedProxy(clientSide = Constants.CLIENT_PROXY, serverSide = Constants.COMMON_PROXY)
    public static CommonProxy proxy;
    
    public static Configuration config;
    @Instance
    public static Marcus8448Mod instance;
    
    //LevelOfDamage(int), durability(int), efficiency(float), Damage(float), enchantability (int)
    public static final ToolMaterial GLASS = EnumHelper.addToolMaterial("GLASS", 4, 3122, 50.0F, 50.0F, 5 );
    public static final ToolMaterial LIGHTNING = EnumHelper.addToolMaterial("LIGHTNING", 4, 2048, 30.0F, 30.0F, 0);
    public static final ToolMaterial COMPRESSED_OBSIDIAN = EnumHelper.addToolMaterial("COMPRESSED_OBSIDIAN", 4, 4096, 40.0F, 40.0F, 0);
    
    /**
     * Items tab
     * @author marcus8448
     * @see TabMarcus8448Items
     * @since 1.12.2-1.0.0_preAlpha3
     */
    public static CreativeTabs marcus8448TabItems = new TabMarcus8448Items();
    
    /**
     * Blocks tab
     * @author marcus8448
     * @see TabMarcus8448Blocks
     * @since 1.12.2-1.0.0_preAlpha3
     */
    public static CreativeTabs marcus8448TabBlocks = new TabMarcus8448Blocks();
    
        
    @EventHandler
       public void preInit(FMLPreInitializationEvent event)
    {
        File dir = event.getModConfigurationDirectory();
        String configDirectory = dir.getAbsolutePath() + File.separatorChar +"marcus8448" + File.separatorChar;
        
        config = new Configuration(new File(configDirectory, "marcus8448mod.cfg"));
        Config.readConfig();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        proxy.preInit(event);
        
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {    
        MinecraftForge.EVENT_BUS.register(new MMEventHandler());
        
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
       {
    	 BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(MMItems.THROWABLE_TNT, new BehaviorProjectileDispense()
         {
             protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn)
             {
                 EntityThrowableTNT entityThrowableTNT = new EntityThrowableTNT(worldIn, position.getX(), position.getY(), position.getZ());
                 return entityThrowableTNT;
             }
         });
    	Logger.getLogger().info("marcus8448's Mod is Post-Initilizing!");
        if (Config.doYouLikeThisMod == false) {
            Logger.getLogger().error("Pleae give feedback on why you don't like this mod (;-;)");
        }

     }
    
    
    }
