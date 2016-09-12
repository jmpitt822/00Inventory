/**
 * Created by jeremypitt on 9/6/16.
 */
public abstract class InventoryItem {
    private String name;
    private int quantity = 0;
    private String category;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public InventoryItem(){

    }

    public InventoryItem (String name){
        this.name = name;
    }

    public InventoryItem (String name, int quantity, String category){
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }
}
