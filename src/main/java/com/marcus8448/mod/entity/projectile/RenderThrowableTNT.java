package com.marcus8448.mod.entity.projectile;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.marcus8448.mod.items.MMItems;

@SideOnly(Side.CLIENT)
public class RenderThrowableTNT<T extends Entity> extends Render<T> {
    protected final Item item;
    private static RenderItem itemRenderer;
    private final ResourceLocation texture = new ResourceLocation("marcus8448mod:items/throwable_tnt");
    public static final Factory FACTORY = new Factory();

    public RenderThrowableTNT(RenderManager renderManagerIn, RenderItem itemRenderIn) {
        super(renderManagerIn);
        this.item = MMItems.THROWABLE_TNT;
        RenderThrowableTNT.itemRenderer = itemRenderIn;
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    @Override
    public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x, (float) y, (float) z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((renderManager.options.thirdPersonView == 2 ? -1 : 1) * renderManager.playerViewX, 1.0F,
                0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindTexture(texture);

        RenderThrowableTNT.itemRenderer.renderItem(this.getStackToRender(entity),
                ItemCameraTransforms.TransformType.GROUND);

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    public ItemStack getStackToRender(T entity) {
        return new ItemStack(MMItems.THROWABLE_TNT);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless
     * you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }

    @SideOnly(Side.CLIENT)
    public static class Factory implements IRenderFactory<EntityThrowableTNT> {

        @SuppressWarnings({ "rawtypes", "unchecked" })
        @Override
        public Render<? super EntityThrowableTNT> createRenderFor(RenderManager manager) {
            return new RenderThrowableTNT(manager, itemRenderer);
        }

    }
}