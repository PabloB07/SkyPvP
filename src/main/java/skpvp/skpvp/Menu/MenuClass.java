package skpvp.skpvp.Menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import skpvp.skpvp.SkPvP;
import skpvp.skpvp.Utils.Utils;

public class MenuClass implements CommandExecutor, Listener {

    private SkPvP plugin;

    public MenuClass(SkPvP plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Inventory gui = Bukkit.createInventory(null, 9 , "GameMode Panel");
        ItemStack survival = new ItemStack (Material.WOODEN_HOE);
        ItemMeta survivalMeta = survival.getItemMeta();

        survival.setItemMeta(survivalMeta);

        if (player.hasPermission("gamepanel.skpvp")){
            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
            player.openInventory(gui);
        }else{
            player.sendMessage(Utils.chat(plugin.getConfig().getString("Utils.prefix")) + Utils.chat(plugin.getConfig().getString("Utils.permission")));
        }

        gui.setItem(0, survival);
        gui.setItem(1, survival);
        gui.setItem(2, survival);
        gui.setItem(3, survival);
        gui.setItem(4, survival);
        gui.setItem(5, survival);
        gui.setItem(6, survival);
        gui.setItem(6, survival);
        gui.setItem(7, survival);
        gui.setItem(8, survival);


        return false;
    }
}
