package triplexgaming.forgetools.commands;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;

public class CommandSetHome implements ICommand {

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "sethome";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getCommandAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
	    if(icommandsender instanceof EntityPlayer){

	    	EntityPlayer player = (EntityPlayer) icommandsender;  		
    		
	    	if(player.worldObj.isRemote == false){
	    		
		    	if(player.getEntityData().hasKey("Home"))
		    	{
		    		
		    		byte[] PlayerHome = new byte[24];
		    				
		    		byte[] PlayerHomeX = new byte[8];
		    		byte[] PlayerHomeY = new byte[8];
		    		byte[] PlayerHomeZ = new byte[8];
		 
		    		PlayerHomeX = toByteArray(player.posX);
		    		PlayerHomeY = toByteArray(player.posY);
		    		PlayerHomeZ = toByteArray(player.posZ);
		  
		    		for(int i = 0; i < 23; i++)
		    		{
		    			//Positon
		    			if(i < 8)
		    			{
			    			PlayerHome[i] = PlayerHomeX[i];
		    			}
		    			if(i < 16 && i > 7)
		    			{
		    				PlayerHome[i] = PlayerHomeY[i - 8];
		    			}
		    			if(i < 24 && i > 15)
		    			{
		    				PlayerHome[i] = PlayerHomeZ[i - 16];
		    			}
		    				
		    			//TODO Rotation
		    		}
		    		player.getEntityData().setByteArray("Home", PlayerHome);
		    		
		    	}
		    	else
		    	{
	    			player.addChatMessage(new ChatComponentTranslation("Home Set"));
		    		ChunkCoordinates Vector = player.getPlayerCoordinates();
		    		int[] PlayerCoords = new int[4];
		    		PlayerCoords[1] = Vector.posX;
		    		PlayerCoords[2] = Vector.posY;
		    		PlayerCoords[3] = Vector.posZ;
		    		//PlayerCoords[4] = player.getd;
		    		player.getEntityData().setIntArray("Home", PlayerCoords);

		    	}
		    	EntityPlayerMP thePlayer = (EntityPlayerMP) player;    	
		    	//List<EntityPlayerMP> thePlayer = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
		    }
	    }
	}

	
	public byte[] toByteArray(double value) {
	    byte[] bytes = new byte[8];
	    ByteBuffer.wrap(bytes).putDouble(value);
	    return bytes;
	}

	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender p_71516_1_,
			String[] p_71516_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		// TODO Auto-generated method stub
		return false;
	}

}
