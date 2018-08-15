package com.marcus8448.mod.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.marcus8448.mod.Marcus8448Mod;
import com.marcus8448.mod.blocks.MMBlocks;
import com.marcus8448.mod.utils.IHaveModel;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_preAlpha2
 *
 */
public class ItemCornSeed extends ItemSeeds implements IHaveModel {

    public ItemCornSeed(String name) {
        super(MMBlocks.CORN_CROP, net.minecraft.init.Blocks.FARMLAND);
        this.setCreativeTab(Marcus8448Mod.marcus8448TabItems);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        MMItems.ITEMS.add(this);

    }

    @Override
    public void registerModels() {
        Marcus8448Mod.proxy.registerItemRenderer(this, 0, "");
    }

    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX,
            float hitY, float hitZ, EnumHand hand) {
        IBlockState ibs = world.getBlockState(pos);
        Block block = ibs.getBlock();
        if (block == net.minecraft.init.Blocks.FARMLAND) {
            BlockPos pos2 = pos.add(0, 1, 0);
            world.setBlockState(pos2, MMBlocks.CORN_CROP.getDefaultState());
            ItemStack blob = player.getHeldItemMainhand();
            if (!player.capabilities.isCreativeMode) {
                blob.shrink(1);
            }
            return EnumActionResult.SUCCESS;
        } else {
            return EnumActionResult.FAIL;
        }
    }

    @Override
    public IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos) {
        return MMBlocks.CORN_CROP.getDefaultState();

    }

}