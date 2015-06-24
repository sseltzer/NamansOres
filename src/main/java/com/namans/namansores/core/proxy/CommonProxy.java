package com.namans.namansores.core.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.namans.namansores.blocks.base.ModBlocks;
import com.namans.namansores.items.base.ModItems;


public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
		ModBlocks.registerAll();
		ModItems.registerAll();
	}
	public void init(FMLInitializationEvent e) {
		ModBlocks.registerAllWorldGen();
		ModBlocks.registerAllCrafting();
		ModItems.registerAllCrafting();
	}
	public void postInit(FMLPostInitializationEvent e) {
	}
}
