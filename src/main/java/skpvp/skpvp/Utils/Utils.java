package skpvp.skpvp.Utils;

import org.bukkit.ChatColor;

import java.util.List;

public class Utils {
    public static String chat(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }
    public static String list(List<String> lst){
        return ChatColor.translateAlternateColorCodes('&', String.valueOf(lst));
    }
}
