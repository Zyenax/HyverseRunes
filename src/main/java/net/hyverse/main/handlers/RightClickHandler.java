package net.hyverse.main.handlers;

import java.util.Arrays;

import net.hyverse.main.Main;
import net.hyverse.main.utils.Utils;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RightClickHandler implements Listener {
	@SuppressWarnings("unused")
	private Main plugin;

	public RightClickHandler(Main hub) {
		this.plugin = hub;
	}

	@EventHandler
	public void strengthRune(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getPlayer().getItemInHand() != null) {
				if (e.getPlayer().getItemInHand().getType() == Material.BLAZE_POWDER) {
					if(e.getPlayer().getItemInHand().hasItemMeta()){
						if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(Utils.color("&c&lStrength Rune"))){
							if(!e.getPlayer().hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)){
								PotionEffect potion = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 10, 2);
								e.getPlayer().addPotionEffect(potion);
								e.getPlayer().getInventory().removeItem(Utils.createItem(Material.BLAZE_POWDER, 1, 0, Utils.color("&c&lStrength Rune"), Arrays.asList(Utils.color("&7Gives you a strength 3 boost!"))));
							}else{
								e.getPlayer().sendMessage(Utils.color("&a&lRUNES&b&l: &cYou already have that active rune!"));
							}
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void speedRune(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getPlayer().getItemInHand() != null) {
				if (e.getPlayer().getItemInHand().getType() == Material.SUGAR) {
					if(e.getPlayer().getItemInHand().hasItemMeta()){
						if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(Utils.color("&b&lSpeed Rune"))){
							if(!e.getPlayer().hasPotionEffect(PotionEffectType.SPEED)){
								PotionEffect potion = new PotionEffect(PotionEffectType.SPEED, 20 * 10, 2);
								e.getPlayer().addPotionEffect(potion);
								e.getPlayer().getInventory().removeItem(Utils.createItem(Material.SUGAR, 1, 0, Utils.color("&b&lSpeed Rune"), Arrays.asList(Utils.color("&7Gives you a speed 3 boost!"))));
							}else{
								e.getPlayer().sendMessage(Utils.color("&a&lRUNES&b&l: &cYou already have that active rune!"));
							}
						}
					}
				}
			}
		}
	}
}