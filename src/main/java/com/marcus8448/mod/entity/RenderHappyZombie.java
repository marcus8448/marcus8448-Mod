package com.marcus8448.mod.entity;

import javax.annotation.Nonnull;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHappyZombie extends RenderLiving<EntityHappyZombie> {

    private ResourceLocation mobTexture = new ResourceLocation("modtut:textures/entity/HappyZombie.png");

    public static final Factory FACTORY = new Factory();

    public RenderHappyZombie(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelZombie(), 0.5F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityHappyZombie entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<EntityHappyZombie> {

        @Override
        public Render<? super EntityHappyZombie> createRenderFor(RenderManager manager) {
            return new RenderHappyZombie(manager);
        }

    }

}