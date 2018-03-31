package com.marcus8448.mod.handlers;

import java.awt.Color;

import com.marcus8448.mod.biomes.MarcusModBiomes;
import com.marcus8448.mod.blocks.Blocks;
import com.marcus8448.mod.fluids.FluidCleanWater;
import com.marcus8448.mod.items.Items;
import com.marcus8448.mod.utils.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> Event) {
		
	 Event.getRegistry().registerAll(Items.ITEMS.toArray((new Item[0])));
		
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> Event) {
		
	 Event.getRegistry().registerAll(Blocks.BLOCKS.toArray((new Block[0])));
		
	}
	
	
	@SubscribeEvent
	public static void onBiomeRegister(RegistryEvent.Register<Biome> Event) {
		Event.getRegistry().register(MarcusModBiomes.MARCUS_BIOME);
        
		//BiomeManager.addBiome(BiomeType.COOL, MarcusModBiomes.biomeEntryMarcusBiome);
			//ForgeRegistries.BIOMES.register(MarcusModBiomes.MARCUS_BIOME);
			System.out.println(BiomeProvider.allowedBiomes);
	       // BiomeProvider.allowedBiomes.clear();
	        BiomeProvider.allowedBiomes.add(MarcusModBiomes.MARCUS_BIOME);
	        System.out.println(BiomeProvider.allowedBiomes);
	        BiomeManager.addVillageBiome(MarcusModBiomes.MARCUS_BIOME, true);
	        System.out.println(MapGenVillage.VILLAGE_SPAWN_BIOMES);
	      //  BiomeManager.strongHoldBiomes.clear();
	 //       BiomeManager.strongHoldBiomes.add(Biomes.BEACH);
	        BiomeManager.strongHoldBiomes.add(MarcusModBiomes.MARCUS_BIOME);
	        System.out.println(BiomeManager.strongHoldBiomes);
			BiomeDictionary.addTypes(MarcusModBiomes.MARCUS_BIOME, Type.MAGICAL);
	}
	
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent Event) {
		
		for (Item item : Items.ITEMS) {
			if (item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		
		for (Block block : Blocks.BLOCKS) {
			if (block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
		
	}
	static Color CleanWaterColour = new Color(13759231);


		public static final Fluid cleanWater = new FluidCleanWater("clean_water", new ResourceLocation("marcus8448mod:clean_water_still"), new ResourceLocation ("marcus8448mod:clean_water_flowing"), CleanWaterColour);

		public static void preInit() {
			registerFluid(cleanWater);
		}

		public static void postInit() {
			cleanWater.setColor(13759231);

			FluidRegistry.registerFluid(cleanWater);
		}

		private static void registerFluid(Fluid fluid) {
			net.minecraftforge.fluids.FluidRegistry.registerFluid(fluid);
		}
	
	
}
