package bellobodo.gui.guis.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUIItems {

    private static ItemStack emptyOptionItem;

    public static ItemStack getEmptyOptionItem() {
        if (emptyOptionItem == null) {
            emptyOptionItem = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            ItemMeta itemMeta = emptyOptionItem.getItemMeta();
            itemMeta.setDisplayName(ChatColor.BLACK + "");
            emptyOptionItem.setItemMeta(itemMeta);
        }
        return emptyOptionItem;
    }

    private static ItemStack backgroundItem;

    public static ItemStack getBackgroundItem() {
        if (backgroundItem == null) {
            backgroundItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta itemMeta = backgroundItem.getItemMeta();
            itemMeta.setDisplayName(ChatColor.BLACK + "");
            backgroundItem.setItemMeta(itemMeta);
        }
        return backgroundItem;
    }
}
