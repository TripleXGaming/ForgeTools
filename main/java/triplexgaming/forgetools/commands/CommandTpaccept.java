package triplexgaming.forgetools.commands;

import java.util.List;

import triplexgaming.forgetools.Teleport;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class CommandTpaccept implements ICommand {
	
	Teleport Tpa;
	
	public CommandTpaccept(Teleport teleport) {
		Tpa = teleport;	
		}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "Tpaccept";
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
	  public void processCommand(ICommandSender icommandsender, String[] astring){
	    if(icommandsender instanceof EntityPlayer){

	    	EntityPlayer player = (EntityPlayer) icommandsender;
	    	if(player.worldObj.isRemote == false){
	    		Tpa.TeleportAcceptSession(player);

	    		}
	    }
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
