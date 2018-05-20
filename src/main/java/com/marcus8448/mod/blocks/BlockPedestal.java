package com.marcus8448.mod.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import java.io.FileOutputStream;

import javax.annotation.Nullable;

import com.marcus8448.mod.Marcus8448Mod;
import com.marcus8448.mod.handlers.GuiHandler;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-0.0.0_Alpha
 *
 */
public class BlockPedestal extends BlockTileEntity<TileEntityPedestal> {

	
	private static String Owner;
	public BlockPedestal(String name, Material mat) {
		super(mat, name);
		MMBlocks.BLOCKS.add(this);
		this.setCreativeTab(Marcus8448Mod.marcus8448TabBlocks);
		
	}

	@Override
	@Deprecated
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	@Deprecated
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			player.getName();
 			if (!player.isSneaking()) {
 				String playerS = player.getName();
 				System.out.println(playerS);
 				System.out.println(Owner);
 				//if (playerS == Owner) { //BROKEN: DOES NOT SAVE  
 				player.openGui(Marcus8448Mod.instance, GuiHandler.PEDESTAL, world, pos.getX(), pos.getY(), pos.getZ());
 				//}
  			} else {
  				
  			}
  		}
  		return true;

	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		Owner = placer.getName();
		System.out.println(Owner);
		NBTTagCompound nbt = new NBTTagCompound();
        stack.writeToNBT(nbt);
        String file = "owners.dat";
        try {
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            CompressedStreamTools.writeCompressed(nbt, fileoutputstream);
            fileoutputstream.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
		
		
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityPedestal tile = getTileEntity(world, pos);
		IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		ItemStack stack = itemHandler.getStackInSlot(0);
		if (!stack.isEmpty()) {
			EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
			world.spawnEntity(item);
		}
		super.breakBlock(world, pos, state);
	}

	@Override
	public Class<TileEntityPedestal> getTileEntityClass() {
		return TileEntityPedestal.class;
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Nullable
	@Override
	public TileEntityPedestal createTileEntity(World world, IBlockState state) {
		return new TileEntityPedestal();
	}

}