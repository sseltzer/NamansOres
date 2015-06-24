package com.namans.namansores.core.json;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.namans.namansores.blocks.base.ModBlocks;
import com.namans.namansores.core.main.ModConfig;
import com.namans.namansores.core.main.NamansMod;
import com.namans.namansores.items.base.ModItems;

public class JsonWriter {
	
	private static String rootPath;
	private static String blockstatesPath;
	private static String modelBlockPath;
	private static String modelItemPath;
	
	private static void buildPaths() {
		rootPath         = JsonWriter.class.getClassLoader().getResource("assets").getPath() + "/" + ModConfig.MOD_ID;
		blockstatesPath  = rootPath + "/blockstates/";
		modelBlockPath   = rootPath + "/models/block/";
		modelItemPath    = rootPath + "/models/item/";
	}

	public static void writeAll() {
		buildPaths();
		JsonFileWriter blockstateWriter = new JsonFileWriter(ModConfig.JSON_TEMPLATE_BLOCKSTATE);
		JsonFileWriter modelBlockWriter = new JsonFileWriter(ModConfig.JSON_TEMPLATE_MODELBLOCK);
		JsonFileWriter modelItemBlockWriter = new JsonFileWriter(ModConfig.JSON_TEMPLATE_MODELITEMBLOCK);
		
		for (ModBlocks block : ModBlocks.values()) {
			blockstateWriter.write(blockstatesPath + block.getName() + ".json", block.getName());
			modelBlockWriter.write(modelBlockPath  + block.getName() + ".json", block.getName());
			modelItemBlockWriter.write(modelItemPath + block.getName() + ".json", block.getName());
		}
		
		JsonFileWriter modelItemWriter = new JsonFileWriter(ModConfig.JSON_TEMPLATE_MODELITEM);
		
		for (ModItems item : ModItems.values()) {
			modelItemWriter.write(modelItemPath + item.getName() + ".json", item.getName());
		}
	}
}
