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

public class JsonFileWriter {
	
	private static final String TAG_MOD_ID = "%MOD_ID%";
	private static final String TAG_MOD_FILE = "%MOD_FILE%";
	
	private String templatePath;
	private List<String> templateContents;
	
	public JsonFileWriter(String templatePath) {
		this.templatePath = normalize(NamansMod.class.getClassLoader().getResource(templatePath).getPath());
	}
	
	public void write(String filePath, String name) {
		filePath = normalize(filePath);
		File json = new File(filePath);
		if (json.exists()) return;
		
		if (templateContents == null) templateContents = getContents();
		fillAndWriteContents(json, name);
	}

	private static String normalize(String path) {
		if (path.startsWith("/")) path = path.substring(1);
		return path;
	}
	
	private List<String> getContents() {
		List<String> contents;
		try {
			contents = Files.readAllLines(Paths.get(templatePath), Charset.defaultCharset());
		} catch (IOException e) {
			return new ArrayList<String>();
		}

		List<String> newContents = new ArrayList<String>();
		for (String string : contents) {
			string = string.replaceAll(TAG_MOD_ID, ModConfig.MOD_ID);
			newContents.add(string);
		}
		return newContents;
	}
	
	private void fillAndWriteContents(File json, String name) {
		List<String> newContents = new ArrayList<String>();
		for (String string : templateContents) {
			string = string.replaceAll(TAG_MOD_FILE, name);
			newContents.add(string);
		}
		try {
			Files.createFile(json.toPath());
			Files.write(json.toPath(), newContents, Charset.defaultCharset(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}	}
}
