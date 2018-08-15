package com.marcus8448.mod.biomes;

import java.awt.Color;
import java.util.Random;

import com.marcus8448.mod.gen.WorldGenObsidian;
import com.marcus8448.mod.utils.Constants;

import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.*;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_preAlpha2
 *
 */
public class BiomeMarcus8448 extends Biome {
    
    static final Color color = new Color(144, 235, 255);
    static final int rgb = color.getRGB(); 
    
    public BiomeMarcus8448(Biome.BiomeProperties BP)
    {
        super(BP);
        this.topBlock = Blocks.GRASS.getDefaultState();
        this.setRegistryName(Constants.MODID, "marcus_biome");
        this.fillerBlock = com.marcus8448.mod.blocks.MMBlocks.BLUE_OAK_PLANKS.getDefaultState();
        
        this.decorator.sandPatchesPerChunk = 1;
        this.decorator.bigMushroomsPerChunk = 1;
        this.decorator.treesPerChunk = 0;
        this.decorator.extraTreeChance = 0.09F;
        this.decorator.reedsPerChunk = 1;
        this.decorator.flowersPerChunk = 3;
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityMooshroom.class, 5, 2, 3));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityIronGolem.class, 5, 1, 1));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityHorse.class, 5, 2, 6));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityIronGolem.class, 4, 1, 3));
        this.decorator.cactiPerChunk = 1;
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombieVillager.class, 30, 1, 4));
        this.flowers.clear();
        this.flowers.add(new Biome.FlowerEntry(Blocks.BLUE_SHULKER_BOX.getDefaultState(), 10));
        this.flowers.add(new Biome.FlowerEntry(Blocks.BLUE_GLAZED_TERRACOTTA.getDefaultState(), 20));
        this.flowers.add(new Biome.FlowerEntry(Blocks.OBSIDIAN.getDefaultState(), 15));
        
    }   

    public void decorate(World worldIn, Random rand, BlockPos pos) {
        int rand1 = rand.nextInt(16) + 8;
        int rand2 = rand.nextInt(16) + 8;
        int height1 = worldIn.getHeight(pos.add(rand1, 0, rand2)).getY() * 2;
        if (height1 < 1) height1 = 1;
        int height = rand.nextInt(height1);
        (new WorldGenObsidian()).generate(worldIn, rand, pos.add(rand1, height, rand2));
       // (new WorldGenTower()).generate(worldIn, rand, pos.add(rand1, height, rand2)); //Currently bugged, use other stuff
        this.decorator.decorate(worldIn, rand, this, pos);
        
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int getWaterColorMultiplier() {
        return 31743;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        return 6587110;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        return 18175;
    }
    
    @Override
    public void addDefaultFlowers()
    {
        addFlower(Blocks.BLUE_SHULKER_BOX.getDefaultState(), 1);
        addFlower(Blocks.BLUE_GLAZED_TERRACOTTA.getDefaultState(), 5);
        addFlower(Blocks.OBSIDIAN.getDefaultState(), 3);
        addFlower(Blocks.SAPLING.getDefaultState(), 7);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int getSkyColorByTemp(float currentTemperature)
    {
        return 47103;
    }
}