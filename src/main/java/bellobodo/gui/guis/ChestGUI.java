package bellobodo.gui.guis;

import de.bellobodo.gui.guis.items.GUIItems;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public abstract class ChestGUI extends GUI {

    /**
     * The ItemStacks of the optionItems.
     */
    ArrayList<ItemStack> optionItems;

    /**
     * The Inventory Positions of the optionItems.
     */
    ArrayList<Short> optionLayout;

    /**
     * Gets the corresponding number of the option Item from the Option Layout using the "event.getSlot" function.
     * @param event The inventory Click Event.
     * @return -99 if the clicked inventory isn't the GUI inventory.
     *         -1 if the clicked item in the inventory is a background item.
     *         1 ...54 if the clicked item is an option item.
     */
    abstract int getInventoryClick(InventoryClickEvent event);

    /**
     * Gets the optionLayout of an GUI.
     * @return The optionLayout of the GUI.
     */
    public ArrayList<Short> getOptionLayout() {
        return this.optionLayout;
    }

    /**
     * Get the optionItem Position from the optionLayout at a given index, returns null if index isn't in the optionLayout.
     * @param index The index of the resulting optionItem Position.
     * @return The optionItem Position at the given index in the optionLayout.
     */
    public short getOptionLayoutPosition(final int index) {
        return (index < this.optionLayout.size() && index >= 0) ? this.optionLayout.get(index) : null;
    }

    /**
     * Gets the optionItems ArrayList.
     * @return The optionItems ArrayList.
     */
    public ArrayList<ItemStack> getOptionItems() {
        return this.optionItems;
    }

    /**
     * Get an ItemStack at a given index in the optionItems ArrayList, returns null if index isn't in the optionItems ArrayList.
     * @param index The index in the optionItems ArrayList.
     * @return The ItemStack at the given index.
     */
    public ItemStack getOptionItem(final int index) {
        return (index < this.optionItems.size() && index >= 0) ? this.optionItems.get(index) : null;
    }

    /**
     * Set a new optionItems ArrayList, the new ArrayList have to be the same size or smaller than the optionLayout ArrayList.
     * @param optionItems The new optionItems ArrayList.
     * @return If the operation was successful.
     */
    public boolean setOptionItems(ArrayList<ItemStack> optionItems) {
        final short optionItemsSize = (short) optionItems.size();

        if (optionItemsSize > this.optionLayout.size()) return false;

        for (int i = 1; i <= this.optionLayout.size(); i++) {
            if (i > optionItemsSize) optionItems.add(GUIItems.getEmptyOptionItem());
        }

        this.optionItems = optionItems;
        return true;
    }

    /**
     * Set an ItemStack at a given index in the optionItems ArrayList, index have to be in the optionItems ArrayList.
     * @param optionItem The new optionItem at an index in the optionItems ArrayList.
     * @param index The index in the optionItems ArrayList.
     * @return If the operation was successful.
     */
    public boolean setOptionItem(final int index, final ItemStack optionItem) {
        if (index < this.optionItems.size() && index >= 0) {
            this.optionItems.set(index, optionItem);
            return true;
        }
        return false;
    }

    /**
     * Add an ItemStack to the optionItems ArrayList if there are empty slots left.
     * @param optionItem The optionItem that gets added to the optionItems ArrayList.
     * @return If the operation was successful.
     */
    public boolean addOptionItem(final ItemStack optionItem) {
        for (int index = 0; index < this.optionItems.size(); index++) {
            if (this.optionItems.get(index).getType().equals(Material.BLACK_STAINED_GLASS_PANE)) {
                this.optionItems.set(index, optionItem);
                return true;
            }
        }
        return false;
    }
}
