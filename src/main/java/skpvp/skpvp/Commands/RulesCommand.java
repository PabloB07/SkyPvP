package skpvp.skpvp.Commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import skpvp.skpvp.SkPvP;
import skpvp.skpvp.Utils.Utils;

public class RulesCommand implements CommandExecutor {

    private SkPvP plugin;

    public RulesCommand(SkPvP plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        if (player.hasPermission("rules.skpvp")){
            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
            player.sendMessage(Utils.list(plugin.getConfig().getStringList("RulesMessage")));
        }else{
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
            player.sendMessage(Utils.chat(plugin.getConfig().getString("Utils.prefix")) + Utils.chat(plugin.getConfig().getString("Utils.permission")));
        }
        return true;
    }
}
