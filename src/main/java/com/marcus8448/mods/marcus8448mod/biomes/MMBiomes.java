package com.marcus8448.mods.marcus8448mod.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;

import net.minecraftforge.common.BiomeManager.BiomeEntry;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_preAlpha2
 *
 */
public class MMBiomes {

    public static final Biome MARCUS_BIOME = new BiomeMarcus8448(new BiomeProperties("Marcus8448Biome")
            .setBaseHeight(0.1F).setHeightVariation(0.1F).setRainfall(0.1F).setWaterColor(BiomeMarcus8448.rgb));
    public static final BiomeEntry biomeEntryMarcusBiome = new BiomeEntry(MARCUS_BIOME, 2147483647);

}