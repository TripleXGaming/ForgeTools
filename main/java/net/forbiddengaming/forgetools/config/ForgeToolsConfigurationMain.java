package net.forbiddengaming.forgetools.config;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

import java.io.File;

public class ForgeToolsConfigurationMain{
	public static Configuration config;

	public static boolean debugMode;

	public static void init(File configFile){
		
		config = new Configuration(configFile);

		try{
			config.load();
			debugMode = config.get("Debug Settings", "Debug Mode", false, "Turn debug mode on/off").getBoolean(false);
		}
		catch (Exception e){
			FMLLog.log(Level.ERROR, "SpaceCraft Warped into a problem with its config!", e);
		}
		finally{
			if (config.hasChanged()) {
				config.save();
			}
		}
	}
}