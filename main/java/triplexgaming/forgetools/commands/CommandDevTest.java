package triplexgaming.forgetools.commands;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;

public class CommandDevTest implements ICommand {

	public String IpToPing = "64.15.120.59";
	
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "devtest";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		// TODO Auto-generated method stub
		return "devtest";
	}

	@Override
	public List getCommandAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processCommand(ICommandSender p_71515_1_, String[] p_71515_2_) {
		Socket socket = null;
		boolean reachable = false;
		try {
		    socket = new Socket(IpToPing, 80);
		    reachable = true;
			System.out.println(reachable);
		} 
		catch (IOException exception) {
			System.out.println(exception);
	    }
		finally {            
		    if (socket != null) try { 
		    	socket.close();
			    reachable = false;
		    	} 
		    catch(IOException e) {}
			System.out.println(reachable);
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
