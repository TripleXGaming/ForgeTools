package triplexgaming.forgetools;
//coded by TripleXGaming and Spying247


import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import triplexgaming.forgetools.Handlers.ForgeToolsEventHandler;
import triplexgaming.forgetools.commands.*;

import com.mojang.realmsclient.gui.ChatFormatting;

import triplexgaming.forgetools.config.ForgeToolsConfiguration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = ForgeTools.MODID, version = ForgeTools.VERSION , acceptableRemoteVersions = "*")
public class ForgeTools
{
    public static final String MODID = "Forge Tools";
    public static final String VERSION = "0.2";
	public static  String configPath;
	public Teleport teleport;
	
	//Static Variables for Configs and other things!
	public static double StartingMoney;
	public static double PlayReward;
	public static int TickAmount;
	
	
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	FMLCommonHandler.instance().bus().register(new ForgeToolsEventHandler());
        System.out.println(ChatFormatting.RED + MODID + " Version " + VERSION + " is Initializing.");
        teleport = new Teleport();
        configPath = event.getModConfigurationDirectory() + "/ForgeTools/";
        ForgeToolsConfiguration.init(configPath);
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
		
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {

    }
    
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event){
		event.registerServerCommand(new CommandHome());
		event.registerServerCommand(new CommandSetHome());
		event.registerServerCommand(new CommandSpawn());
		event.registerServerCommand(new CommandSetSpawn());
		event.registerServerCommand(new CommandHeal());
		event.registerServerCommand(new CommandInfo());
		event.registerServerCommand(new CommandTpa(teleport));
		event.registerServerCommand(new CommandTpaHere(teleport));
		event.registerServerCommand(new CommandTpaccept(teleport));
		event.registerServerCommand(new CommandKillAll());
		event.registerServerCommand(new CommandkillItems());
        event.registerServerCommand(new CommandSuperHeal());
        event.registerServerCommand(new CommandFeed());
        event.registerServerCommand(new CommandMoney());
	}
}
