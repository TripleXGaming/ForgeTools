package triplexgaming.forgetools.commands;

import java.util.ArrayList;
import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;

public class CommandHeal implements ICommand {

	  private List aliases;
	  public CommandHeal()
	  {
	    this.aliases = new ArrayList();
	    this.aliases.add("heal");
	  }

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		return "heal";
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
		   
		  
	    if(astring.length == 0){
	    //  icommandsender.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + "/heal <Player Name>"));
	    if(icommandsender instanceof EntityPlayer){
	    	EntityPlayer player = (EntityPlayer) icommandsender;
	    	if(player.worldObj.isRemote == false){
	    		
		    	player.addChatMessage(new ChatComponentTranslation(ChatFormatting.GREEN + "You suddenly Feel a rush of life"));
		    	player.setHealth(20f);
		    //	player.setAbsorptionAmount(20f);
		    	player.getFoodStats().setFoodLevel(20);
		    }
	    }
	    	return;
	    }
	    if (astring.length != 0)
	    {
	    	
            for(int i = 0; i < PlayerList.size(); i++) {
                if(PlayerList.get(i).getDisplayName().equals(astring[0])){
                    EntityPlayer player = PlayerList.get(i);
        	    	System.out.println(player);
        	    	if(player.worldObj.isRemote == false){
        	    		
        		    	player.addChatMessage(new ChatComponentTranslation(ChatFormatting.GREEN + "You suddenly Feel a rush of life"));
        		    	player.setHealth(20f);
        		    	player.setAbsorptionAmount(20f);
        		    	
        		    	player.getFoodStats().setFoodLevel(50);
        		    }
                }
                else
                {
                	if(icommandsender instanceof EntityPlayer){
            	    	EntityPlayer player = (EntityPlayer) icommandsender;
            	    	if(player.worldObj.isRemote == false){
            	    		player.addChatMessage(new ChatComponentTranslation(ChatFormatting.RED + "/heal <Player Name>"));
            		    }
            	    }
            	    	return;
            	   }
                }
	    	
            }
	  
	  }

	  @Override
	  public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
	  {
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
