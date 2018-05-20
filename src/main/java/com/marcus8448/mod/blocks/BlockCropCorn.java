package com.marcus8448.mod.blocks;

import com.marcus8448.mod.Marcus8448Mod;
import com.marcus8448.mod.items.MMItems;
import com.marcus8448.mod.utils.IHasModel;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-0.0.0_preAlpha2
 *
 */
public class BlockCropCorn extends BlockCrops implements IHasModel {

	public BlockCropCorn(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		MMBlocks.BLOCKS.add(this);

	}

	
	@Override
	protected Item getSeed() {
		return MMItems.CORN_SEED;
	}
	
	@Override
	protected Item getCrop() {
		return MMItems.CORN;
	}
	@Override
	public IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return MMBlocks.CORN_CROP.getDefaultState();
		
	}
    @Override
    public void registerModels() {
        Marcus8448Mod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "");
        
    }

}