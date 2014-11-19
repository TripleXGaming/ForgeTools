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
		    		
		    		byte[] PlayerHome = new byte[28];
		    				
		    		byte[] PlayerHomeX = new byte[8];
		    		byte[] PlayerHomeY = new byte[8];
		    		byte[] PlayerHomeZ = new byte[8];
		    		byte[] PlayerPitch = new byte[8];
		    		byte[] PlayerYaw = new byte[4];
		    		
		    		
		    		PlayerHomeX = doubletoByteArray(player.posX);
		    		PlayerHomeY = doubletoByteArray(player.posY);
		    		PlayerHomeZ = doubletoByteArray(player.posZ);
		    		PlayerYaw = floattoByteArray(player.getRotationYawHead()); 
		    		
		    		for(int i = 0; i < 28; i++)
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
		    			if(i < 31 && i > 23)
		    			{
		    				PlayerHome[i] = PlayerYaw[i - 24];
		    			}

		    			//TODO Rotation
		    		}
		    		System.out.println(player.getRotationYawHead());
		    		player.getEntityData().setByteArray("Home", PlayerHome);
		    		
		    	}
		    	else
		    	{
		    		
		    		byte[] PlayerHome = new byte[28];
    				
		    		byte[] PlayerHomeX = new byte[8];
		    		byte[] PlayerHomeY = new byte[8];
		    		byte[] PlayerHomeZ = new byte[8];
		    		byte[] PlayerYaw = new byte[4];
		 
		    		
		    		PlayerHomeX = doubletoByteArray(player.posX);
		    		PlayerHomeY = doubletoByteArray(player.posY);
		    		PlayerHomeZ = doubletoByteArray(player.posZ);
		    		PlayerYaw = floattoByteArray(player.getRotationYawHead()); 
		    		//PlayerPitch = toByteArray(player.get); 
		    		
		    		for(int i = 0; i < 28; i++)
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
		    			if(i < 31 && i > 23)
		    			{
		    				PlayerHome[i] = PlayerYaw[i - 24];
		    			}
			    		System.out.println(player.getRotationYawHead());
		    			//TODO Rotation
		    		}
		    		player.getEntityData().setByteArray("Home", PlayerHome);
		    	}
		    	EntityPlayerMP thePlayer = (EntityPlayerMP) player;    	
		    	//List<EntityPlayerMP> thePlayer = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
		    }
	    }
	}

	
	public byte[] doubletoByteArray(double value) {
	    byte[] bytes = new byte[8];
	    ByteBuffer.wrap(bytes).putDouble(value);
	    return bytes;
	}
	public byte[] floattoByteArray(float value) {
	    byte[] bytes = new byte[4];
	    ByteBuffer.wrap(bytes).putFloat(value);
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
