package TripleXGaming.ForgeTools;
//coded by TripleXGaming
import TripleXGaming.ForgeTools.Commands.CommandHeal;
import TripleXGaming.ForgeTools.Commands.CommandHome;
import TripleXGaming.ForgeTools.Commands.CommandSetHome;
import TripleXGaming.ForgeTools.Commands.CommandSetSpawn;
import TripleXGaming.ForgeTools.Commands.CommandSpawn;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.init.Blocks;
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
    public static final String VERSION = "0.1";

    //this better be here
    //test

    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        System.out.println(ChatFormatting.RED + MODID + " Version " + VERSION + " is Initializing.");
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
		
		
	}
}
