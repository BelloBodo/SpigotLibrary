package bellobodo.gui.builder;

import de.bellobodo.gui.guis.SimpleGUI;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class SimpleGUIBuilder implements GUIBuilder{

    /**
     * TODO
     * @param optionItems
     * @param inventoryHolder
     * @param inventoryTitle
     * @return
     */
    public SimpleGUI createSimpleGUI(ArrayList<ItemStack> optionItems, @Nullable final InventoryHolder inventoryHolder,
                                     @Nullable final String inventoryTitle)
            throws IllegalArgumentException {

        //Validation of the optionItems.
        if (optionItems.size() > 54)
            throw new IllegalArgumentException("There can't be over 54 optionItems.");

        final ArrayList<Short> optionLayout = defaultLayout.getSimpleGUIOptionLayout(optionItems.size());
        final int inventorySize = defaultLayout.getSimpleGUISize(optionItems.size());

        return new SimpleGUI(inventorySize, optionLayout, optionItems, inventoryHolder, inventoryTitle);
    }

    /**
     * TODO
     * @param inventorySize
     * @param optionLayout
     * @param optionItems
     * @param inventoryHolder
     * @param inventoryTitle
     * @return
     * @throws IllegalArgumentException
     */
    public SimpleGUI createSimpleGUI(final int inventorySize, final ArrayList<Short> optionLayout, final ArrayList<ItemStack> optionItems,
                                     @Nullable final InventoryHolder inventoryHolder, @Nullable final String inventoryTitle)
            throws IllegalArgumentException {

        //Validation of the optionItems.
        if (optionItems.size() > optionLayout.size())
            throw new IllegalArgumentException("There can't be more optionItems than optionLayout Entries.");
        else if (optionItems.size() > 54)
            throw new IllegalArgumentException("There can't be over 54 optionItems.");
        //Validation of the inventorySize.
        if (!(inventorySize % 9 == 0) || inventorySize > 54)
            throw new IllegalArgumentException("The Size of the Inventory is Invalid.");
        //Validation of the optionLayout.
        {
            int maxValue = -1;
            int currentValue;
            for (int i = 0; i < optionLayout.size(); i++) {
                currentValue = optionLayout.get(i);
                if (currentValue <= maxValue || currentValue >= inventorySize)
                    throw new IllegalArgumentException("The optionLayout is invalid at index: " + i);
                else maxValue = currentValue;
            }
        }

        return new SimpleGUI(inventorySize, optionLayout, optionItems, inventoryHolder, inventoryTitle);
    }
}
