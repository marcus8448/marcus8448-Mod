package com.marcus8448.mod.handlers;

import com.marcus8448.mod.Marcus8448Mod;
import com.marcus8448.mod.biomes.MMBiomes;
import com.marcus8448.mod.blocks.MMBlocks;
import com.marcus8448.mod.blocks.TileEntityPedestal;
import com.marcus8448.mod.entity.EntityHappyZombie;
import com.marcus8448.mod.entity.RenderHappyZombie;
import com.marcus8448.mod.items.MMItems;
import com.marcus8448.mod.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
	public static void onBiomeRegister(RegistryEvent.Register<Biome> Event) {
/*			Event.getRegistry().register(MarcusModBiomes.MARCUS_BIOME);
        
			BiomeManager.addBiome(BiomeType.COOL, MarcusModBiomes.biomeEntryMarcusBiome);
			ForgeRegistries.BIOMES.register(MarcusModBiomes.MARCUS_BIOME);
			BiomeDictionary.addTypes(MarcusModBiomes.MARCUS_BIOME, Type.MAGICAL);
			BiomeDictionary.addTypes(MarcusModBiomes.MARCUS_BIOME, Type.COOL);
			MarcusModBiomes.MARCUS_BIOME.decorator.bigMushroomsPerChunk = 2;
			System.out.println(BiomeProvider.allowedBiomes);
	        //BiomeProvider.allowedBiomes.clear();
	        BiomeProvider.allowedBiomes.add(MarcusModBiomes.MARCUS_BIOME);
	        System.out.println(BiomeProvider.allowedBiomes);
	        BiomeManager.addVillageBiome(MarcusModBiomes.MARCUS_BIOME, true);
	        System.out.println(MapGenVillage.VILLAGE_SPAWN_BIOMES);
	      //  BiomeManager.strongHoldBiomes.clear();
	        BiomeManager.strongHoldBiomes.add(MarcusModBiomes.MARCUS_BIOME);
	        System.out.println(BiomeManager.strongHoldBiomes);
			BiomeDictionary.addTypes(MarcusModBiomes.MARCUS_BIOME, Type.MAGICAL);
		//OLD ABOVE
		BiomeManager.addBiome(BiomeType.COOL, MarcusModBiomes.biomeEntryMarcusBiome);
		BiomeManager.addStrongholdBiome(MarcusModBiomes.MARCUS_BIOME);
		BiomeManager.addSpawnBiome(MarcusModBiomes.MARCUS_BIOME);
		BiomeManager.addVillageBiome(MarcusModBiomes.MARCUS_BIOME, true);
		//Event.getRegistry().registerAll(MarcusModBiomes.BIOMES.toArray((new Biome[0])));
		  //STUFF
			Event.getRegistry().register(MarcusModBiomes.MARCUS_BIOME);	
			BiomeManager.addBiome(BiomeType.COOL, MarcusModBiomes.biomeEntryMarcusBiome);
			System.out.println(BiomeProvider.allowedBiomes);
	        BiomeProvider.allowedBiomes.add(MarcusModBiomes.MARCUS_BIOME);
	        System.out.println(BiomeProvider.allowedBiomes);
	        BiomeManager.addVillageBiome(MarcusModBiomes.MARCUS_BIOME, true);
	        System.out.println(MapGenVillage.VILLAGE_SPAWN_BIOMES);
	        BiomeManager.strongHoldBiomes.add(MarcusModBiomes.MARCUS_BIOME);
	        System.out.println(BiomeManager.strongHoldBiomes);
			BiomeDictionary.addTypes(MarcusModBiomes.MARCUS_BIOME, Type.MAGICAL);
		*/

		Event.getRegistry().register(MMBiomes.MARCUS_BIOME);
        
			BiomeManager.addBiome(BiomeType.COOL, MMBiomes.biomeEntryMarcusBiome);
			//ForgeRegistries.BIOMES.register(MarcusModBiomes.MARCUS_BIOME);
			System.out.println(BiomeProvider.allowedBiomes);
			// BiomeProvider.allowedBiomes.clear();
	        BiomeProvider.allowedBiomes.add(MMBiomes.MARCUS_BIOME);
	        System.out.println(BiomeProvider.allowedBiomes);
	        BiomeManager.addVillageBiome(MMBiomes.MARCUS_BIOME, true);
	        System.out.println(MapGenVillage.VILLAGE_SPAWN_BIOMES);
	        //  BiomeManager.strongHoldBiomes.clear();
	        //BiomeManager.strongHoldBiomes.add(Biomes.BEACH);
	        BiomeManager.strongHoldBiomes.add(MMBiomes.MARCUS_BIOME);
	        System.out.println(BiomeManager.strongHoldBiomes);
			BiomeDictionary.addTypes(MMBiomes.MARCUS_BIOME, Type.MAGICAL);
		
	}
	
	
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent Event) {
		
		for (Item item : MMItems.ITEMS) {
			if (item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		
		for (Block block : MMBlocks.BLOCKS) {
			if (block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
		
	}
	
	public static void registerEntity() {
        // Every entity in our mod has an ID (local to this mod)
        int id = 1;
        EntityRegistry.registerModEntity(new ResourceLocation("marcus8448mod:happy_zombie"), EntityHappyZombie.class, "HappyZombie", id++, Marcus8448Mod.instance, 64, 3, true, 0x996600, 0x00ff00);

        // We want our mob to spawn in Plains and ice plains biomes. If you don't add this then it will not spawn automatically
        // but you can of course still make it spawn manually
        EntityRegistry.addSpawn(EntityHappyZombie.class, 100, 3, 5, EnumCreatureType.CREATURE, Biomes.PLAINS, Biomes.ICE_PLAINS);

        // This is the loot table for our mob
        LootTableList.register(EntityHappyZombie.LOOT);
    }

    @SideOnly(Side.CLIENT)
    public static void registerEntityModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntityHappyZombie.class, RenderHappyZombie.FACTORY);
    }
}
