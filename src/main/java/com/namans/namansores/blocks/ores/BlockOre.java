package com.namans.namansores.blocks.ores;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.namans.namansores.blocks.base.ModBlock;
import com.namans.namansores.blocks.base.ModBlocks;
import com.namans.namansores.core.crafting.Craftable;
import com.namans.namansores.items.base.ModItems;

public class BlockOre extends Block implements ModBlock, Craftable, IWorldGenerator {

	private ModBlocks thisBlock;
	private ModItems ingotItem;

	public BlockOre(String name) {
		super(Material.rock);
		this.setUnlocalizedName(name);

		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(2.0f);
		this.setResistance(10.0f);
	}
	
	@Override
	public void setSelf(ModBlocks thisBlock) {
		this.thisBlock = thisBlock;
	}
	
	@Override
	public void initCrafting() {
		switch (thisBlock) {
			case ORE_COPPER:    ingotItem = ModItems.INGOT_COPPER;   break;
			case ORE_LEAD:      ingotItem = ModItems.INGOT_LEAD;     break;
			case ORE_MITHRIL:   ingotItem = ModItems.INGOT_MITHRIL;  break;
			case ORE_NICKEL:    ingotItem = ModItems.INGOT_NICKEL;   break;
			case ORE_PLATINUM:  ingotItem = ModItems.INGOT_PLATINUM; break;
			case ORE_SILVER:    ingotItem = ModItems.INGOT_SILVER;   break;
			case ORE_TIN:       ingotItem = ModItems.INGOT_TIN;      break;
			default:                                                 break;
		}
	}
	@Override
	public void registerShapedRecipies() {}
	@Override
	public void registerShapelessRecipies() {}
	@Override
	public void registerSmeltingRecipies() {
		GameRegistry.addSmelting(thisBlock.get(), ingotItem.getNewItemStack(), 1.0f);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.getDimensionId() == 0) {
	        runGenerator(new WorldGenMinable(this.getDefaultState(), 8), world, random, chunkX, chunkZ, 20, 0, 64);
		}
	}
	private Random random = new Random();
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) {
	        int x = chunk_X * 16 + ((rand.nextInt(16) * random.nextInt(16)) % 16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + ((rand.nextInt(16) * random.nextInt(16)) % 16);
	        generator.generate(world, rand, new BlockPos(x, y, z));
	    }
	}
}