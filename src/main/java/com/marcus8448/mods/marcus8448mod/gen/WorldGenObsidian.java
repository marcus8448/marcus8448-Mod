package com.marcus8448.mods.marcus8448mod.gen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0
 *
 */
public class WorldGenObsidian extends WorldGenerator {

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        for (int i = 0; i < 64; ++i) {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4),
                    rand.nextInt(8) - rand.nextInt(8));

            if (Blocks.OBSIDIAN.canPlaceBlockAt(worldIn, blockpos)
                    && worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.GRASS) {
                worldIn.setBlockState(blockpos, Blocks.OBSIDIAN.getDefaultState(), 1);
            }
        }

        return true;
    }
}
