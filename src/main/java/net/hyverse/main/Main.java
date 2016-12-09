package net.hyverse.main;

import net.hyverse.main.handlers.CommandHandler;
import net.hyverse.main.handlers.RightClickHandler;
import net.hyverse.main.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public void onEnable(){
		registerListeners();
		registerCommands();
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(Utils.color("&8[&cHyverse Runes&8] &aEnabled!"));
	}
	
	public void onDisable(){
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(Utils.color("&8[&cHyverse Runes&8] &cDisabled!"));
	}
	
	public void registerListeners(){
		PluginManager manager = Bukkit.getServer().getPluginManager();
		manager.registerEvents(new Utils(this), this);
		manager.registerEvents(new RightClickHandler(this), this);
		manager.registerEvents(new CommandHandler(this), this);
	}
	
	public void registerCommands(){
		getCommand("runes").setExecutor(new CommandHandler(this));
	}

}
