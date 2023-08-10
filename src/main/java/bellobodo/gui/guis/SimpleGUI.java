package bellobodo.gui.guis;

import de.bellobodo.gui.guis.items.GUIItems;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class SimpleGUI extends ChestGUI {

    private final int size;

    public SimpleGUI(final int size, final ArrayList<Short> optionLayout, final ArrayList<ItemStack> optionItems,
                     @Nullable final InventoryHolder inventoryHolder, @Nullable final String inventoryTitle) {
        this.size = size;
        this.optionLayout = optionLayout;
        this.optionItems = optionItems;
        if (inventoryHolder != null) this.inventoryHolder = inventoryHolder;
        if (inventoryTitle != null) this.inventoryTitle = inventoryTitle;
        this.buildGUI();
    }

    @Override
    void buildGUI() {
        this.guiInventory = Bukkit.createInventory(this.inventoryHolder, this.size, this.inventoryTitle);
        int activeOptionLayout = 0;
        for (int i = 0; i < this.size; i++) {

            int activeOptionLayoutValue = -1;


            if (activeOptionLayout == optionLayout.size()) {
                activeOptionLayoutValue = -1;
            } else {
                activeOptionLayoutValue = optionLayout.get(activeOptionLayout);
            }

            if (i == activeOptionLayoutValue) {
                ItemStack itemStack;
                try {
                    itemStack = optionItems.get(activeOptionLayout);
                    activeOptionLayout++;
                } catch (ArrayIndexOutOfBoundsException exception) {
                    itemStack = GUIItems.getEmptyOptionItem();
                }

                this.guiInventory.setItem(i, itemStack);

            } else {
                this.guiInventory.setItem(i, GUIItems.getBackgroundItem());
            }
        }
    }

    @Override
    public void updateGUI() {

    }

    /**
     * Gets the corresponding number of the option Item from the Option Layout using the "event.getSlot" function.
     * @param event The inventory Click Event.
     * @return -99 if the clicked inventory isn't the GUI inventory.
     *         -1 if the clicked item in the inventory is a background item.
     *         1 ...54 if the clicked item is an option item.
     */
    @Override
    public int getInventoryClick(InventoryClickEvent event) {
        if (guiInventory.equals(event.getClickedInventory())) {
            event.setCancelled(true);

            for (int i = 0; i < optionLayout.size(); i++) {
                if (optionLayout.get(i) == event.getSlot()) {
                    return i++;
                }
            }
            return -1;
        }
        return -99;
    }
}
