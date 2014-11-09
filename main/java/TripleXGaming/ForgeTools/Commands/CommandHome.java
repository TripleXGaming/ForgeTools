package triplexgaming.forgetools.commands;
import java.util.ArrayList;
import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentTranslation;

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
    if(astring.length == 0){
      icommandsender.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + "/home <home name>"));
      return;
    }
    
    if(icommandsender instanceof EntityPlayer){

    	EntityPlayer player = (EntityPlayer) icommandsender;
    	if(player.worldObj.isRemote == false){
    		
	    	player.addChatMessage(new ChatComponentTranslation("warping to home: [" + astring[0] + "]"));
	    	
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