package com.marcus8448.mods.marcus8448mod.blocks;

import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.marcus8448.mods.marcus8448mod.Marcus8448Mod;
import com.marcus8448.mods.marcus8448mod.items.MMItems;
import com.marcus8448.mods.marcus8448mod.utils.Constants;
import com.marcus8448.mods.marcus8448mod.utils.IHaveModel;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_preAlpha1
 *
 */
public class BlockBlueSlime extends Block implements IHaveModel {

    float fd = 0;
    String name = "";

    public BlockBlueSlime(String name, Material material) {
        super(material);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(Marcus8448Mod.marcus8448TabBlocks);
        this.setSoundType(SoundType.SLIME);
        this.setHardness(0.2F);
        this.setResistance(45F); // Very flexible jelly/Slime!

        MMBlocks.BLOCKS.add(this);
        MMItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED; // Supposed to be TRANSPARENT but causes a bug.
    }

    /**
     * Block's chance to react to a living entity falling on it.
     */
    @Override
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        if (entityIn.isSneaking()) {
            entityIn.motionY = -10F;
        } else {

            Random rjump = new Random();
            double n = rjump.nextDouble() + 1;
            entityIn.motionY = entityIn.motionY + n;
            @SuppressWarnings("unused")
            Double jump = entityIn.motionY + 3.0D;
            entityIn.fall(fallDistance, 0.0F);
            entityIn.motionY = n;
            System.out.println(entityIn.motionY);
            fd = fd + fallDistance;
            if (n >= 9.5D) {
                fallDistance = fd;
            }
            System.out.println(fallDistance);
        }
    }

    /**
     * Called when an Entity lands on this Block. This method *must* update motionY
     * because the entity will not do that on its own
     */
    @Override
    public void onLanded(World worldIn, Entity entityIn) {
        if (entityIn.isSneaking()) {
            super.onLanded(worldIn, entityIn);
        } else if (entityIn.motionY < 0.0D) {
            entityIn.motionY = -entityIn.motionY;

            if (!(entityIn instanceof EntityLivingBase)) {
                entityIn.motionY *= 0.8D;
            }
        }
    }

    /**
     * Called when the given entity walks on this Block
     */
    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (Math.abs(entityIn.motionY) < 0.0D && !entityIn.isSneaking()) {
            double d0 = 0.4D + Math.abs(entityIn.motionY) * 0.2D;
            entityIn.motionX *= d0;
            entityIn.motionZ *= d0;
        }

        super.onEntityWalk(worldIn, pos, entityIn);
    }

    @Override
    public void addInformation(ItemStack itemStack, World worldIn, List<String> list, ITooltipFlag flag) {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            list.add("Woah super bouncy!");
        } else {
            list.add("Press SHIFT for more info");
        }
        super.addInformation(itemStack, worldIn, list, flag);
    }

    @Override
    public void registerModels() {
        Marcus8448Mod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, Constants.MODID + ":" + name);
    }

}
