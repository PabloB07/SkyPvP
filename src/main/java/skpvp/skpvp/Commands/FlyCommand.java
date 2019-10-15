package skpvp.skpvp.Commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import skpvp.skpvp.SkPvP;
import skpvp.skpvp.Utils.Utils;

public class FlyCommand implements CommandExecutor {
    private SkPvP plugin;

    public FlyCommand(SkPvP plugin){
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            Player player = (Player) sender;
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("Utils.prefix")) + Utils.chat(plugin.getConfig().getString("Utils.console_message")));
            return true;
        }
        Player player = (Player) sender;
        if (player.hasPermission("fly.skpvp")){
            if (player.isFlying()){
                player.setGlowing(false);
                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK, 1, 1);
                player.setAllowFlight(false);
                player.setFlying(false);
                player.sendMessage(Utils.chat(plugin.getConfig().getString("Utils.prefix")) + Utils.chat(plugin.getConfig().getString("Commands.fly_disable")));
            }else{
                player.setGlowing(true);
                player.playSound(player.getLocation(),Sound.UI_BUTTON_CLICK, 1, 1);
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendMessage(Utils.chat(plugin.getConfig().getString("Utils.prefix")) + Utils.chat(plugin.getConfig().getString("Commands.fly_enable")));
                return true;
            }
        }else{
            player.sendMessage(Utils.chat(plugin.getConfig().getString("Utils.prefix")) + Utils.chat(plugin.getConfig().getString("Utils.permission")));
        }
        return true;
    }
}
