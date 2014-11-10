package triplexgaming.forgetools;

import java.util.ArrayList;
import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;

public class Teleport {

	public ArrayList<ArrayList<EntityPlayer>> AllTPList = new ArrayList<ArrayList<EntityPlayer>>();
	public ArrayList<EntityPlayer> PlayerTPList = new ArrayList<EntityPlayer>();
	
	
	private boolean isWaitingForTeleport = false;
	private long SendTime = 0;
	
	public void TeleportAddSession(EntityPlayer playerSender, String[] PlayerReceiver, boolean TpaType, long WorldTime)
	{
	    List<EntityPlayerMP> PlayerList = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
		  if (PlayerReceiver.length != 0)
		    {
	            for(int i = 0; i < PlayerList.size(); i++) {
	                if(PlayerList.get(i).getDisplayName().equals(PlayerReceiver[0])){
	                    EntityPlayer ReceivingPlayer = PlayerList.get(i);
	                    
	            			//TPA
	            			PlayerTPList.add(playerSender);
	            			PlayerTPList.add(ReceivingPlayer);
	            			AllTPList.add(PlayerTPList);
	            		
	        	    	MsgReceivingPlayer(ReceivingPlayer);
	                }
	            }
		    }
	}
	

	
	public void TeleportAcceptSession(EntityPlayer recieving){
        for(int r = 0; r <= AllTPList.size(); r++){
            for(int c = 0; c <= PlayerTPList.size(); c++){
                if(AllTPList.get(r).get(c).equals(recieving)) {
                	EntityPlayer PlayerToTeleportTo = AllTPList.get(r).get(0);
                	
                	if(AllTPList.get(r).get(c) != PlayerToTeleportTo)
                	{
            			System.out.println(AllTPList);            	
            			System.out.println(AllTPList.get(r).get(0));
            			System.out.println(AllTPList.get(r).get(1));
            			System.out.println(PlayerToTeleportTo);
                    	TeleportPlayer(PlayerToTeleportTo, recieving);
                		AllTPList.remove(r);
                		PlayerTPList.clear();
                		//DeleteArray(AllTPList, recieving);
                		
                	}
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
	
	
	public void DeleteArray(ArrayList allTPList, EntityPlayer recieving){
        for(int r =0; r < allTPList.size(); r++){
            for(int c = 0; c < PlayerTPList.size(); c++){
                if(PlayerTPList.indexOf(recieving) == 1) {
                	//PlayerTPList.remove(r);
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
