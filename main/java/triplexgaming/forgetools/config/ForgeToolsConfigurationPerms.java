package triplexgaming.forgetools.config;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import org.apache.logging.log4j.Level;

import triplexgaming.forgetools.ForgeTools;
import cpw.mods.fml.common.FMLLog;

public class ForgeToolsConfigurationPerms{
	
	
	public static Configuration config;
	
	public static void init(File configFile){
		
		config = new Configuration(configFile);

		try{
			config.load();
			
			ForgeTools.RankAmount = config.get("Permissions", "ARankAmount", 3, "Amount of Ranks On Server").getInt();
			
			ForgeTools.PermsRank = new String[ForgeTools.RankAmount];
			for(int i = 0; i < ForgeTools.RankAmount ; i++)
			{
				
				ForgeTools.PermsRank[i] = config.get("Permissions", "Permission" + i, "Member", "Name OF Rank ").getString();
				//Permission 1
				//ForgeTools.Perm1Enable = config.get("Permissions", "Permission1Enable", true, "Turn Perm1 on/off").getBoolean(true);
				//ForgeTools.Perm1 = config.get("Permissions", "Permission1", "Member", "Change amount of money players start with").getString();
				
			}
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