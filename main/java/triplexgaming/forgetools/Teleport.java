package triplexgaming.forgetools;

import java.util.ArrayList;
import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;

public class Teleport {

	public ArrayList<ArrayList<EntityPlayer>> AllTPList = new ArrayList<ArrayList<EntityPlayer>>();
	public ArrayList<EntityPlayer> PlayerTPList = new ArrayList<EntityPlayer>();
	
	
	private boolean isWaitingForTeleport = false;
	private long SendTime = 0;
	public void TeleportSession(EntityPlayer playerSender, String[] PlayerREceiver, boolean TpaType, long WorldTime)
	
	{

	    List<EntityPlayerMP> PlayerList = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
	    
		  if (PlayerREceiver.length != 0)
		    {
		    	
	            for(int i = 0; i < PlayerList.size(); i++) {
	                if(PlayerList.get(i).getDisplayName().equals(PlayerREceiver[0])){
	                    EntityPlayer ReceivingPlayer = PlayerList.get(i);
	                    
	            		if(TpaType)
	            		{
	            			//TPA
	            			PlayerTPList.add(playerSender);
	            			PlayerTPList.add(ReceivingPlayer);
	            			AllTPList.add(PlayerTPList);
	            		}
	            		else
	            		{
	            			//TPAHERE
	            			PlayerTPList.add(ReceivingPlayer);            			
	            			PlayerTPList.add(playerSender);
	            			AllTPList.add(PlayerTPList);
	            		}
	            		
	        	    	MsgReceivingPlayer(ReceivingPlayer);
	        	    	System.out.println(AllTPList);
	                }
	            }
		    }
		
	}
	
	
	public void MsgReceivingPlayer(EntityPlayer player)
	
	{
		player.addChatMessage(new ChatComponentTranslation(" =============================================="));
		player.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + "         " + player.getDisplayName() + " Wants to teleport to you"));
    	player.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + "         Type /Tpaccept to Accept the request."));
    	player.addChatMessage(new ChatComponentTranslation(" =============================================="));
	}
}
