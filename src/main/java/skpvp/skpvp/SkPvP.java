package skpvp.skpvp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import skpvp.skpvp.Commands.FlyCommand;
import skpvp.skpvp.Commands.RulesCommand;
import skpvp.skpvp.Economy.EconomyCommand;
import skpvp.skpvp.Economy.EconomyImplements;
import skpvp.skpvp.Economy.VaultHook;
import skpvp.skpvp.Menu.MenuClass;

import java.util.HashMap;
import java.util.UUID;

public final class SkPvP extends JavaPlugin {

    public static SkPvP getInstance;
    public EconomyImplements economyImplementer;
    private VaultHook vaultHook;

    public final HashMap<UUID,Double> playerBank = new HashMap<>();

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin activated!");
        // Plugin startup logic
        onCommands();
        onEvents();
        saveDefaultConfig();
        saveConfig();
        runOnEnable();
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        vaultHook.unhook();
    }
    private void onCommands(){
        getCommand("fly").setExecutor(new FlyCommand(this));
        getCommand("gmp").setExecutor(new MenuClass(this));
        getCommand("rules").setExecutor(new RulesCommand(this));
    }
    private void onEvents(){
        Bukkit.getPluginManager().registerEvents(new MenuClass(this),this);

    }
    private void instanceClasses() {
        getInstance = this;
        economyImplementer = new EconomyImplements();
        vaultHook = new VaultHook();
    }

    public void runOnEnable(){
        instanceClasses();
        vaultHook.hook();
        this.getCommand("token").setExecutor(new EconomyCommand());
    }
}
