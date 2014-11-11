package triplexgaming.forgetools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;

public class Teleport {

	private Map<EntityPlayer,EntityPlayer> TeleportQue = new HashMap<EntityPlayer, EntityPlayer>();

	public void TeleportAddSession(EntityPlayer playerSender, String[] PlayerReceiver, long WorldTime, boolean Type)
	{
		List<EntityPlayerMP> PlayerList = MinecraftServer.getServer().getConfigurationManager().playerEntityList;

		  if (PlayerReceiver.length != 0)
		    {
	            for(int i = 0; i < PlayerList.size(); i++)
	            {
	                if(PlayerList.get(i).getDisplayName().equals(PlayerReceiver[0]))
	                {
	                  	 EntityPlayer ReceivingPlayer = PlayerList.get(i);
	                	if(TeleportQue.containsKey(ReceivingPlayer))
	                	{
	                		TeleportQue.remove(ReceivingPlayer);

	                	}
	                	if(TeleportQue.containsValue(playerSender))
	                	{
	                        for (Entry<EntityPlayer, EntityPlayer> entry : TeleportQue.entrySet()) {
	                            if (entry.getValue().equals(playerSender)) {
	                            	TeleportQue.remove(entry.getKey());
	                            }
	                        }
	                		TeleportQue.remove(playerSender);

	                	}
	                 	if(Type)
	                 	{
	                 			//TPA
	                     	TeleportQue.put(ReceivingPlayer, playerSender);
		         			MsgReceivingPlayer(ReceivingPlayer, true);
	                 	}
	                 	else
	                 	{
	             			//TPAHere
	                     	TeleportQue.put(playerSender, ReceivingPlayer);
		         			MsgReceivingPlayer(ReceivingPlayer, false);
	                 	}
	                }
	                playerSender.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + " Player not Available!"));
	            }
		    }
	}
	
	public void TeleportAcceptSession(EntityPlayer recieving)
	{
        if(TeleportQue.containsKey(recieving))
        {
        	TeleportPlayer(TeleportQue.get(recieving), recieving);
        	TeleportQue.remove(recieving);
        }
        if(TeleportQue.containsValue(recieving))
        {
            for (Entry<EntityPlayer, EntityPlayer> entry : TeleportQue.entrySet()) {
                if (entry.getValue().equals(recieving)) {
                	TeleportPlayer(recieving, entry.getKey());
                	TeleportQue.remove(entry.getKey());
                }
            }
        }
    }
	
	//Player that is being Teleported ---> Player to be teleported To!
	public void TeleportPlayer(EntityPlayer Player1, EntityPlayer Player2)
	{
		
		ChunkCoordinates vec = Player2.getPlayerCoordinates();
		Player1.setPositionAndUpdate(vec.posX, vec.posY, vec.posZ);
		
	}
	
	
	public void MsgReceivingPlayer(EntityPlayer player, boolean Type)
	{
		if(Type)
		{
			player.addChatMessage(new ChatComponentTranslation(" =============================================="));
			player.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + "         " + player.getDisplayName() + " Wants to teleport to you"));
	    	player.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + "         Type /Tpaccept to Accept the request."));
	    	player.addChatMessage(new ChatComponentTranslation(" =============================================="));	
		}
		else
		{
			player.addChatMessage(new ChatComponentTranslation(" =============================================="));
			player.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + "      " + player.getDisplayName() + " Wants you to teleport to them"));
	    	player.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + "         Type /Tpaccept to Accept the request."));
	    	player.addChatMessage(new ChatComponentTranslation(" =============================================="));	
			
		}

	}

}
