package bellobodo.gui.guis;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public abstract class GUI {
    Inventory guiInventory;

    InventoryHolder inventoryHolder = null;

    String inventoryTitle = "GUI";

    abstract void buildGUI();

    abstract void updateGUI();

    /**
     * Gets the Inventory of the GUI.
     * @return The current Inventory of the GUI.
     */
    public Inventory getGUIInventory() {
        return this.guiInventory;
    }

}

