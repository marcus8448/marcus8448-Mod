package com.marcus8448.mods.marcus8448mod.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.marcus8448.mods.marcus8448mod.biomes.MMBiomes;
import com.marcus8448.mods.marcus8448mod.blocks.MMBlocks;
import com.marcus8448.mods.marcus8448mod.blocks.TileEntityPedestal;
import com.marcus8448.mods.marcus8448mod.items.MMItems;
import com.marcus8448.mods.marcus8448mod.utils.IHaveModel;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_preAlpha1
 *
 */
@EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> Event) {

        Event.getRegistry().registerAll(MMItems.ITEMS.toArray((new Item[0])));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> Event) {

        Event.getRegistry().registerAll(MMBlocks.BLOCKS.toArray((new Block[0])));
        GameRegistry.registerTileEntity(TileEntityPedestal.class, "tile_entity_pedestal");
    }

    @SubscribeEvent
    public static void onEntityRegister(RegistryEvent.Register<EntityEntry> event) {
    }

    @SubscribeEvent
    public static void onBiomeRegister(RegistryEvent.Register<Biome> Event) {
        Event.getRegistry().register(MMBiomes.MARCUS_BIOME);

        BiomeManager.addBiome(BiomeType.COOL, MMBiomes.biomeEntryMarcusBiome);
        BiomeProvider.allowedBiomes.add(MMBiomes.MARCUS_BIOME);
        BiomeManager.addVillageBiome(MMBiomes.MARCUS_BIOME, true);
        BiomeManager.strongHoldBiomes.add(MMBiomes.MARCUS_BIOME);
        System.out.println(BiomeManager.strongHoldBiomes);
        BiomeDictionary.addTypes(MMBiomes.MARCUS_BIOME, Type.MAGICAL);

    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent Event) {

        for (Item item : MMItems.ITEMS) {
            if (item instanceof IHaveModel) {
                ((IHaveModel) item).registerModels();
            }
        }

        for (Block block : MMBlocks.BLOCKS) {
            if (block instanceof IHaveModel) {
                ((IHaveModel) block).registerModels();
            }
        }

    }

}
