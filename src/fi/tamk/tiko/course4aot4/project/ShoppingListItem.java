package fi.tamk.tiko.course4aot4.project;

/**
 * Created by Eetu Kallio on 20.11.2016
 *
 * @author Eetu Kallio
 * @version 1.0
 */
public class ShoppingListItem {

    private int itemAmount;
    private String itemName;

    public ShoppingListItem(int amount, String name){

        itemAmount = amount;
        itemName = name;

    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public String getItemName() {
        return itemName;
    }
}
