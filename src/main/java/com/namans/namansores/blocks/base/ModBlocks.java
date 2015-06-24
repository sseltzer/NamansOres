package com.namans.namansores.blocks.base;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.namans.namansores.blocks.ores.BlockMetal;
import com.namans.namansores.blocks.ores.BlockOre;
import com.namans.namansores.core.crafting.Craftable;
import com.namans.namansores.core.main.ModConfig;
import com.namans.namansores.items.base.ModItems;

public enum ModBlocks {
	
	ORE_COPPER     (new BlockOre("block_ore_copper")),
	ORE_LEAD       (new BlockOre("block_ore_lead")),
	ORE_MITHRIL    (new BlockOre("block_ore_mithril")),
	ORE_NICKEL     (new BlockOre("block_ore_nickel")),
	ORE_PLATINUM   (new BlockOre("block_ore_platinum")),
	ORE_SILVER     (new BlockOre("block_ore_silver")),
	ORE_TIN        (new BlockOre("block_ore_tin")),
	
	METAL_COPPER   (new BlockMetal("block_metal_copper")),
	METAL_LEAD     (new BlockMetal("block_metal_lead")),
	METAL_MITHRIL  (new BlockMetal("block_metal_mithril")),
	METAL_NICKEL   (new BlockMetal("block_metal_nickel")),
	METAL_PLATINUM (new BlockMetal("block_metal_platinum")),
	METAL_SILVER   (new BlockMetal("block_metal_silver")),
	METAL_TIN      (new BlockMetal("block_metal_tin"));
	
	private String name;
	private Block block;
	
	private ModBlocks(Block block) {
		this.block = block;
		this.name = get().getUnlocalizedName().substring(5);
		if (block instanceof ModBlock) {
			((ModBlock)block).setSelf(this);
		}
	}
	public Block get() {
		return block;
	}
	public ItemStack getNewItemStack() {
		return new ItemStack(get());
	}
	public ItemStack getNewItemStack(int amount, int metaData) {
		return new ItemStack(get(), amount, metaData);
	}
	public String getName() {
		return name;
	}
	public ModelResourceLocation getResource() {
		return new ModelResourceLocation(ModConfig.MOD_ID + ":" + name, "inventory");
	}
	public static void registerAll() {
		for (ModBlocks block : ModBlocks.values()) {
			Block b = block.get(); 
			b.setLightLevel(1.0f);
		    GameRegistry.registerBlock(b, block.getName());
		}
	}
	public static void registerAllRenderers() {
	    for (ModBlocks block : ModBlocks.values()) {
	    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block.get()), 0, block.getResource());
    	}
	}
	public static void registerAllCrafting() {
	    for (ModBlocks block : ModBlocks.values()) {
	    	if (!(block.get() instanceof Craftable)) continue;
	    	Craftable craftable = (Craftable) block.get();
	    	craftable.initCrafting();
	    	craftable.registerShapedRecipies();
	    	craftable.registerShapelessRecipies();
	    	craftable.registerSmeltingRecipies();
    	}
	}
	
	public static void registerAllWorldGen() {
	    for (ModBlocks block : ModBlocks.values()) {
	    	if (!(block.get() instanceof IWorldGenerator)) continue;
	    	GameRegistry.registerWorldGenerator((IWorldGenerator) block.get(), 0);
	    }
	}
}