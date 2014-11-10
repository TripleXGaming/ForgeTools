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

	public static ArrayList<ArrayList<EntityPlayer>> AllTPList = new ArrayList<ArrayList<EntityPlayer>>();
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
	public void TeleportAcceptSession(EntityPlayer Player)
	{
		System.out.println(Player);
		System.out.println(AllTPList);
		EntityPlayer PlayerToTeleportTo = scanArray(AllTPList, Player);
		System.out.println(PlayerToTeleportTo);
		int CoordX = PlayerToTeleportTo.serverPosX;
		int CoordY = PlayerToTeleportTo.serverPosY;
		int CoordZ = PlayerToTeleportTo.serverPosZ;
		ChunkCoordinates vec = PlayerToTeleportTo.getPlayerCoordinates();
		Player.setPositionAndUpdate(vec.posX, vec.posY, vec.posZ);
		DeleteArray(AllTPList, Player);
	}
	
	public EntityPlayer scanArray(ArrayList allTPList, EntityPlayer recieving){
        for(int r = 0; r <= allTPList.size(); r++){
            for(int c = 0; c <= PlayerTPList.size(); c++){
            	System.out.println(PlayerTPList.indexOf(recieving));
                if(PlayerTPList.indexOf(recieving) == 1) {
                    return PlayerTPList.get(0);
                    
                }else if(PlayerTPList.indexOf(recieving) == 0){
                    return PlayerTPList.get(1);
                }
            }
        }
        return null;
    }
	
	public void DeleteArray(ArrayList allTPList, EntityPlayer recieving){
        for(int r =0; r < allTPList.size(); r++){
            for(int c = 0; c < PlayerTPList.size(); c++){
                if(PlayerTPList.indexOf(recieving.getDisplayName()) == 1) {
                    AllTPList.remove(r);
                }else if(PlayerTPList.indexOf(recieving.getDisplayName()) == 0){
                    AllTPList.remove(r);
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
