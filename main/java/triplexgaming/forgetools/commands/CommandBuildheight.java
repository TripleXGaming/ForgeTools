package triplexgaming.forgetools.commands;

import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;

public class CommandBuildheight implements ICommand {

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "buildheight";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		// TODO Auto-generated method stub
		return "buildheight [get|Set] [0 - 255]";
	}

	@Override
	public List getCommandAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {

		int buildheight;

		if(astring.length == 1)
		{
			if(icommandsender instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) icommandsender;
				if(astring[0].equals("get"))
				{
					int SetBuildHeight = MinecraftServer.getServer().getBuildLimit();
					player.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + " BuildHeight is set to " + SetBuildHeight));
					return;
				}
				else
				{
					player.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + "Type /buildheight help for more info"));
					return;
				}
			}
		}
		else if (astring.length == 2)
		{
			if(icommandsender instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) icommandsender;
				if(player.worldObj.isRemote == false)
				{
					if(astring[0].equals("set"))
					{ 
						try { 
							buildheight = Integer.parseInt(astring[1]);
						} catch(NumberFormatException e) { 
							player.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + "/buildheight set <0 - 255>"));
							return; 
						}
						if(buildheight > 255 || buildheight < 0)
						{
							player.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + "Please Type a number between 0 - 255"));
							return;
						}

						MinecraftServer.getServer().setBuildLimit(buildheight);
						player.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + "You set build height to " + astring[1]));
					}
					else
					{
						player.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + "Type /buildheight help for more info"));
						return;
					}

					//Please Type a number between 0 - 255

				}
			}
		}
		if(astring.length != 2){
			if(icommandsender instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) icommandsender;
				if(player.worldObj.isRemote == false)
				{
					player.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + "Type /buildheight help for more info"));
					return;
				}
			}
			return;
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		// TODO Auto-generated method stub
		return false;
	}

}
