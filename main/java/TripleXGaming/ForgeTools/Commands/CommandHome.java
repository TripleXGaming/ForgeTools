package triplexgaming.forgetools.commands;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;

public class CommandHome implements ICommand
{
  private List aliases;
  public CommandHome()
  {
    this.aliases = new ArrayList();
    this.aliases.add("home");
  }

  @Override
  public String getCommandName()
  {
    return "home";
  }

  @Override
  public String getCommandUsage(ICommandSender icommandsender)
  {
    return "home <home name>";
  }

  @Override
  public List getCommandAliases()
  {
    return this.aliases;
  }

  @Override
  public void processCommand(ICommandSender icommandsender, String[] astring){
  //  if(astring.length == 0){
   //   icommandsender.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + "/home <home name>"));
   //   return;
  //  }
    
    if(icommandsender instanceof EntityPlayer){

    	EntityPlayer player = (EntityPlayer) icommandsender;
    	if(player.worldObj.isRemote == false){
    		
    		if(player.getEntityData().hasKey("Home"))
	    	{
	    		byte[] PlayerCoords = new byte[24];
	    		PlayerCoords = player.getEntityData().getByteArray("Home"); 
	    		
	    		byte[] PlayerX = new byte[8];
	    		byte[] PlayerY = new byte[8];
	    		byte[] PlayerZ = new byte[8];
	    		
	    		for(int i = 0; i < 23; i++)
	    		{
	    			//Position
	    			if(i < 8)
	    			{
	    				PlayerX[i] = PlayerCoords[i];
	    			}
	    			if(i < 16 && i > 7)
	    			{
	    				PlayerY[i - 8] = PlayerCoords[i];
	    			}
	    			if(i < 24 && i > 15)
	    			{
	    				PlayerZ[i - 16] = PlayerCoords[i];
	    			}
	    				
	    			//TODO Rotation
	    		}
	    		
	    		double PosX = ByteBuffer.wrap(PlayerX).getDouble();
	    		double PosY = ByteBuffer.wrap(PlayerY).getDouble();
	    		double PosZ = ByteBuffer.wrap(PlayerZ).getDouble();
	    		player.setPositionAndUpdate(PosX,PosY, PosZ);
	    	}
	    	else
	    	{
    			player.addChatMessage(new ChatComponentTranslation("No Home Set - use /sethome"));

	    	}
	    	EntityPlayerMP thePlayer = (EntityPlayerMP) player;    	
	    	//List<EntityPlayerMP> thePlayer = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
	    }
    }
  }
  
  
  @Override
  public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
  {
    return true;
  }

  @Override
  public List addTabCompletionOptions(ICommandSender icommandsender,
      String[] astring)
  {
    return null;
  }

  @Override
  public boolean isUsernameIndex(String[] astring, int i)
  {
    return false;
  }

  @Override
  public int compareTo(Object o)
  {
    return 0;
  }
  
}