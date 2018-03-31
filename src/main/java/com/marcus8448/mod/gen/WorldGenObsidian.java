package com.marcus8448.mod.gen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenObsidian extends WorldGenerator {
	
	public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (Blocks.OBSIDIAN.canPlaceBlockAt(worldIn, blockpos) && worldIn.getBlockState(blockpos.down()).getBlock() == com.marcus8448.mod.blocks.Blocks.BLUE_OAK_PLANKS)
            {
                worldIn.setBlockState(blockpos, Blocks.OBSIDIAN.getDefaultState(), 2);
            }
        }

        return true;
    }
}
