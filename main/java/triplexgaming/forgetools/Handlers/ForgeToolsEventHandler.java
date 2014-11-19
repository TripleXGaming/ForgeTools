package triplexgaming.forgetools.Handlers;

import triplexgaming.forgetools.ForgeTools;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class ForgeToolsEventHandler {
	
	@SubscribeEvent	
	 public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
	{
	    // DEBUG
	    if (event.player instanceof EntityPlayer)
	    {
	        if(!(event.player.getEntityData().hasKey("Money")))
	        {
	        	event.player.getEntityData().setDouble("Money", ForgeTools.StartingMoney);
	        	System.out.println("Testing");
	        }
	        
	        if(!(event.player.getEntityData().hasKey("Rank")))
	        {
	        	event.player.getEntityData().setString("Rank", "Member");
	        }	
	    	
	    }
	        
	}
	
}