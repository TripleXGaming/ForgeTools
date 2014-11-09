package TripleXGaming.ForgeTools.Commands;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;

public class CommandInfo implements ICommand {

	  private List aliases;
	  public CommandInfo()
	  {
	    this.aliases = new ArrayList();
	    this.aliases.add("info");
	  }
	  
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "info";
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
	    List<EntityPlayerMP> PlayerList = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
		 if(icommandsender instanceof EntityPlayer){
		    	EntityPlayer player = (EntityPlayer) icommandsender;
		    	if(player.worldObj.isRemote == false){

                    //create array with all online player names
                    String[] onlinePlayers = new String[PlayerList.size()];
                    int i = 0;
                    for(EntityPlayer p : PlayerList){
                        onlinePlayers[i] = p.getDisplayName();
                        i++;
                    }


			    	player.addChatMessage(new ChatComponentTranslation(ChatFormatting.GREEN + " Players Online: " + PlayerList.size() + "/" + MinecraftServer.getServer().getMaxPlayers()));
                    player.addChatMessage(new ChatComponentTranslation(ChatFormatting.GREEN + " " + Arrays.toString(onlinePlayers)));
                    //player.addChatMessage(new ChatComponentTranslation(ChatFormatting.GREEN + " " + TPS));
			    	//player.addChatMessage(new ChatComponentTranslation(ChatFormatting.GREEN + " " + PlayerList.));

			    }
		    }
		return;
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
