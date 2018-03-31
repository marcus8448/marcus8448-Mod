package com.marcus8448.mod.biomes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

public class MarcusModBiomes {
	public static final List<Biome> BIOMES = new ArrayList<Biome>();
	
	public static final Biome MARCUS_BIOME = new BiomeMarcus8448(new BiomeProperties("Marcus8448Biome").setBaseHeight(0.1F).setHeightVariation(0.1F).setRainfall(0.1F).setWaterColor(BiomeMarcus8448.rgb));
	public static final BiomeEntry biomeEntryMarcusBiome = new BiomeEntry(MARCUS_BIOME, 2147483647);
	
}
