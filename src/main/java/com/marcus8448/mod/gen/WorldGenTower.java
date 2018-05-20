package com.marcus8448.mod.gen;

import java.util.Random;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-0.0.0_Alpha
 *
 */
public class WorldGenTower extends WorldGenerator
{
    private static final ResourceLocation BASE = new ResourceLocation("marcus8448mod:base");


    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
    	int ri = rand.nextInt(100);
    	if (ri == 50) {
        Random random = worldIn.getChunkFromBlockCoords(position).getRandomWithSeed(987234911L);
        MinecraftServer minecraftserver = worldIn.getMinecraftServer();
        Rotation[] arotation = Rotation.values();
        Rotation rotation = arotation[random.nextInt(arotation.length)];
        TemplateManager templatemanager = worldIn.getSaveHandler().getStructureTemplateManager();
        Template baseTemplate = templatemanager.getTemplate(minecraftserver, BASE);
        ChunkPos chunkpos = new ChunkPos(position);
        StructureBoundingBox structureboundingbox = new StructureBoundingBox(chunkpos.getXStart(), 0, chunkpos.getZStart(), chunkpos.getXEnd(), 256, chunkpos.getZEnd());
        PlacementSettings placementsettings = (new PlacementSettings()).setRotation(rotation).setBoundingBox(structureboundingbox).setRandom(random);
        BlockPos blockpos = baseTemplate.transformedSize(rotation);
        int j = random.nextInt(16 - blockpos.getX());
        int k = random.nextInt(16 - blockpos.getZ());
        int l = 256;

        for (int i1 = 0; i1 < blockpos.getX(); ++i1)
        {
            for (int j1 = 0; j1 < blockpos.getX(); ++j1)
            {
                l = Math.min(l, worldIn.getHeight(position.getX() + i1 + j, position.getZ() + j1 + k));
            }
        }

        int k1 = Math.max(l - 15 - random.nextInt(10), 10);
        BlockPos blockpos1 = baseTemplate.getZeroPositionWithTransform(position.add(j, k1, k), Mirror.NONE, rotation);
        placementsettings.setIntegrity(0.9F);
        baseTemplate.addBlocksToWorld(worldIn, blockpos1, placementsettings, 20);
        placementsettings.setIntegrity(0.1F);
        return true;
    	} else {
    		return false;
    	}   
    }
}