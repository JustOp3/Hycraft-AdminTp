package fr.justop.listeners;

import fr.justop.AdminTP;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class InventoryPlayer implements Listener {
	private Inventory inv = Bukkit.createInventory(null, 54, "§a§lMenu des époques");
	private int[] FILLER_CARRE = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 17, 18, 26, 27, 35, 36, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53};

	private ItemStack PREHISTOIRE = new ItemStack(Material.SPRUCE_LEAVES);
	private ItemStack ANTIQUITE = new ItemStack(Material.CHISELED_SANDSTONE);
	private ItemStack MOYENAGE = new ItemStack(Material.STONE_BRICKS);
	private ItemStack TEMPSMODERNES = new ItemStack(Material.OXIDIZED_COPPER);
	private ItemStack EC = new ItemStack(Material.BRICK_WALL);
	private ItemStack MINAGE = new ItemStack(Material.NETHERITE_PICKAXE);
	private ItemStack SURVIE = new ItemStack(Material.AMETHYST_BLOCK);

	private ItemStack FILLER1 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
	private ItemStack FILLER2 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
	private ItemStack FILLER3 = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);

	public void buildItems() {
		ItemMeta meta1 = PREHISTOIRE.getItemMeta();
		meta1.setDisplayName("§a§lPréhistoire");
		meta1.setLore(Arrays.asList("§b----------------", "§6Clic gauche sur", "§6l'item pour vous ", "§6téléporter à la", "§aPréhostoire"));
		PREHISTOIRE.setItemMeta(meta1);
		ItemMeta meta2 = ANTIQUITE.getItemMeta();
		meta2.setDisplayName("§a§lAntiquité");
		meta2.setLore(Arrays.asList("§b----------------", "§6Clic gauche sur", "§6l'item pour vous ", "§6téléporter à l'", "§aAntiquité"));
		ANTIQUITE.setItemMeta(meta2);
		ItemMeta meta3 = MOYENAGE.getItemMeta();
		meta3.setDisplayName("§a§lMoyen-âge");
		meta3.setLore(Arrays.asList("§b----------------", "§6Clic gauche sur", "§6l'item pour vous ", "§6téléporter au", "§aMoyen-âge"));
		MOYENAGE.setItemMeta(meta3);
		ItemMeta meta4 = TEMPSMODERNES.getItemMeta();
		meta4.setDisplayName("§a§lTemps modernes");
		meta4.setLore(Arrays.asList("§b----------------", "§6Clic gauche sur", "§6l'item pour vous ", "§6téléporter aux", "§aTemps modernes"));
		TEMPSMODERNES.setItemMeta(meta4);
		ItemMeta meta5 = EC.getItemMeta();
		meta5.setDisplayName("§a§lEpoque contemporaine");
		meta5.setLore(Arrays.asList("§b----------------", "§6Clic gauche sur", "§6l'item pour vous ", "§6téléporter à l'", "§aEpoque contemporaine"));
		EC.setItemMeta(meta5);
		ItemMeta meta6 = MINAGE.getItemMeta();
		meta6.setDisplayName("§e§lMinage");
		meta6.setLore(Arrays.asList("§b----------------", "§6Clic gauche sur", "§6l'item pour vous ", "§6téléporter au", "§eMinage"));
		MINAGE.setItemMeta(meta6);
		ItemMeta meta7 = SURVIE.getItemMeta();
		meta7.setDisplayName("§e§lSurvie");
		meta7.setLore(Arrays.asList("§b----------------", "§6Clic gauche sur", "§6l'item pour vous ", "§6téléporter à la", "§eSurvie"));
		SURVIE.setItemMeta(meta7);
		ItemMeta meta8 = FILLER1.getItemMeta();
		meta8.setDisplayName("null item");
		meta8.setLore(null);
		FILLER1.setItemMeta(meta8);
		ItemMeta meta9 = FILLER2.getItemMeta();
		meta9.setDisplayName("null item");
		meta9.setLore(null);
		FILLER2.setItemMeta(meta9);
		ItemMeta meta10 = FILLER3.getItemMeta();
		meta10.setDisplayName("null item");
		meta10.setLore(null);
		FILLER3.setItemMeta(meta10);
	}

	public void openInventory(Player player) {
		for (int fill = 0; fill < 54; fill++) {
			inv.setItem(fill, FILLER1);
		}

		for (int slot : FILLER_CARRE) {
			inv.setItem(slot, FILLER2);
		}

		inv.setItem(20, PREHISTOIRE);
		inv.setItem(21, ANTIQUITE);
		inv.setItem(22, MOYENAGE);
		inv.setItem(29, TEMPSMODERNES);
		inv.setItem(30, EC);
		inv.setItem(31, FILLER3);

		inv.setItem(24, MINAGE);
		inv.setItem(33, SURVIE);

		player.openInventory(inv);
	}

	@EventHandler
	public void onClickInventory(InventoryClickEvent event) {
		ItemStack clickedItem = event.getCurrentItem();

		if (event.getView().getTitle() == "§a§lMenu des époques") {
			Player player = (Player) event.getWhoClicked();

			event.setCancelled(true);

			if (event.getClickedInventory() == null || clickedItem == null || clickedItem.getType() == Material.BLUE_STAINED_GLASS_PANE
					|| clickedItem.getType() == Material.GREEN_STAINED_GLASS_PANE
					|| clickedItem.getType() == Material.YELLOW_STAINED_GLASS_PANE) return;

			switch (clickedItem.getItemMeta().getDisplayName()) {
				case "§a§lPréhistoire":
					player.teleport(new Location(Bukkit.getWorld("Prehistoire"), -47.0, 67.0, -42.0, 90.0f, 0.0f));
					player.sendMessage(AdminTP.PREFIX + "§eVous avez été téléporté à la §bPréhistoire");
					break;

				case "§a§lAntiquité":
					player.teleport(new Location(Bukkit.getWorld("Antiquite"), -68.0, 48.0, -26.0, 90.0f, 0.0f));
					player.sendMessage(AdminTP.PREFIX + "§eVous avez été téléporté à l'§bAntiquité");
					break;

				case "§a§lMoyen-âge":
					player.teleport(new Location(Bukkit.getWorld("Moyen-age"), -129.0, -8.0, -89.0, 90.0f, 0.0f));
					player.sendMessage(AdminTP.PREFIX + "§eVous avez été téléporté au §bMoyen-âge");
					break;

				case "§a§lTemps modernes":
					player.teleport(new Location(Bukkit.getWorld("Tempsmodernes"), 1.0, -60.0, 70.0, 0.0f, 0.0f));
					player.sendMessage(AdminTP.PREFIX + "§eVous avez été téléporté aux §bTemps modernes");
					break;

				case "§a§lEpoque contemporaine":
					player.teleport(new Location(Bukkit.getWorld("epoquecontemporaine"), -73.0, 96.0, 34.0, -90.0f, 0.0f));
					player.sendMessage(AdminTP.PREFIX + "§eVous avez été téléporté à l'§bEpoque contemporaine");
					break;

				case "§e§lMinage":
					player.teleport(new Location(Bukkit.getWorld("Minage"), 144.0, 85.0, 64.0, 0.0f, 0.0f));
					player.sendMessage(AdminTP.PREFIX + "§eVous avez été téléporté au §bMinage");
					break;

				case "§e§lSurvie":
					player.teleport(new Location(Bukkit.getWorld("mondesurvie"), 550.0, 184.0, 647.0, 0.0f, 60.0f));
					player.sendMessage(AdminTP.PREFIX + "§eVous avez été téléporté au §bMonde survie");
					break;

			}

			player.closeInventory();
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.setGameMode(GameMode.CREATIVE);

		player.teleport(new Location(Bukkit.getWorld("Lobby_Japon"), -2.0, 160.0, 0.0, 90.0f, 0.0f));
		event.setJoinMessage("§c" + player.getDisplayName() + "§e a rejoint le serveur. Souhaitons lui un bon jeu !");
	}
}
