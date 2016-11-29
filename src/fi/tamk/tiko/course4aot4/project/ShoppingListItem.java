package fi.tamk.tiko.course4aot4.project;

/**
 * A single item in the shopping list.
 *
 * @author Eetu Kallio
 * @version 1.0
 * @since 1.0
 */
public class ShoppingListItem {

    /**
     * Amount of the item.</p>
     */
    private int itemAmount;

    /**
     * Name of the item.</p>
     */
    private String itemName;

    /**
     * Constructor with amount and name.</p>
     *
     * @param amount Amount of the item.
     * @param name Name of the item.
     */
    public ShoppingListItem(int amount, String name) {

        itemAmount = amount;
        itemName = name;
    }

    /**
     * Sets the itemAmount.</p>
     *
     * @param itemAmount Amount to be set.
     */
    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    /**
     * Sets the item name.</p>
     *
     * @param itemName Name to be set.
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Returns current amount.</p>
     *
     * @return itemAmount
     */
    public int getItemAmount() {
        return itemAmount;
    }

    /**
     * Returns current name.
     *
     * @return itemName
     */
    public String getItemName() {
        return itemName;
    }
}
