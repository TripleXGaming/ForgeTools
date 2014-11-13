package triplexgaming.forgetools.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import org.apache.logging.log4j.Level;

import triplexgaming.forgetools.ForgeTools;
import cpw.mods.fml.common.FMLLog;

public class ForgeToolsConfigurationMain{
	public static Configuration config;

	public static boolean debugMode;

	
	public static void init(File configFile){
		
		config = new Configuration(configFile);

		try{
			config.load();
			debugMode = config.get("Debug Settings", "Debug Mode", false, "Turn debug mode on/off").getBoolean(false);
			ForgeTools.StartingMoney = config.get("Money", "Starting Money", 200.0, "Change amount of money players start with").getDouble();
			ForgeTools.PlayReward = config.get("Money", "PlayTime Reward", 30.0, "Amount of money players get per amount of time").getDouble();
			ForgeTools.StartingMoney = config.get("Money", "Reward Time", 5.0, "Amount of time between reward payouts (in seconds)").getInt();
		}
		catch (Exception e){
			FMLLog.log(Level.ERROR, "ForgeTools melted into a problem with its config!", e);
		}
		finally{
			if (config.hasChanged()) {
				config.save();
			}
		}
	}
}