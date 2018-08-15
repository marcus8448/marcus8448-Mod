package com.marcus8448.mod.biomes;

import java.awt.Color;
import java.util.Random;

import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.marcus8448.mod.gen.WorldGenObsidian;
import com.marcus8448.mod.utils.Constants;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_preAlpha2
 *
 */
public class BiomeMarcus8448 extends Biome {

    static final Color color = new Color(144, 235, 255);
    static final int rgb = color.getRGB();

    public BiomeMarcus8448(Biome.BiomeProperties BP) {
        super(BP);
        topBlock = Blocks.GRASS.getDefaultState();
        this.setRegistryName(Constants.MODID, "marcus_biome");
        fillerBlock = com.marcus8448.mod.blocks.MMBlocks.BLUE_OAK_PLANKS.getDefaultState();

        decorator.sandPatchesPerChunk = 1;
        decorator.bigMushroomsPerChunk = 1;
        decorator.treesPerChunk = 0;
        decorator.extraTreeChance = 0.09F;
        decorator.reedsPerChunk = 1;
        decorator.flowersPerChunk = 3;
        spawnableCaveCreatureList.clear();
        spawnableMonsterList.clear();
        spawnableWaterCreatureList.clear();
        spawnableCreatureList.add(new Biome.SpawnListEntry(EntityMooshroom.class, 5, 2, 3));
        spawnableCreatureList.add(new Biome.SpawnListEntry(EntityIronGolem.class, 5, 1, 1));
        spawnableCreatureList.add(new Biome.SpawnListEntry(EntityHorse.class, 5, 2, 6));
        spawnableCreatureList.add(new Biome.SpawnListEntry(EntityIronGolem.class, 4, 1, 3));
        decorator.cactiPerChunk = 1;
        spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombieVillager.class, 30, 1, 4));
        flowers.clear();
        flowers.add(new Biome.FlowerEntry(Blocks.BLUE_SHULKER_BOX.getDefaultState(), 10));
        flowers.add(new Biome.FlowerEntry(Blocks.BLUE_GLAZED_TERRACOTTA.getDefaultState(), 20));
        flowers.add(new Biome.FlowerEntry(Blocks.OBSIDIAN.getDefaultState(), 15));

    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        int rand1 = rand.nextInt(16) + 8;
        int rand2 = rand.nextInt(16) + 8;
        int height1 = worldIn.getHeight(pos.add(rand1, 0, rand2)).getY() * 2;
        if (height1 < 1) {
            height1 = 1;
        }
        int height = rand.nextInt(height1);
        (new WorldGenObsidian()).generate(worldIn, rand, pos.add(rand1, height, rand2));
        // (new WorldGenTower()).generate(worldIn, rand, pos.add(rand1, height, rand2));
        // //Currently bugged, use other stuff
        decorator.decorate(worldIn, rand, this, pos);

    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getWaterColorMultiplier() {
        return 31743;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getFoliageColorAtPos(BlockPos pos) {
        return 6587110;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 18175;
    }

    @Override
    public void addDefaultFlowers() {
        addFlower(Blocks.BLUE_SHULKER_BOX.getDefaultState(), 1);
        addFlower(Blocks.BLUE_GLAZED_TERRACOTTA.getDefaultState(), 5);
        addFlower(Blocks.OBSIDIAN.getDefaultState(), 3);
        addFlower(Blocks.SAPLING.getDefaultState(), 7);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 47103;
    }
}