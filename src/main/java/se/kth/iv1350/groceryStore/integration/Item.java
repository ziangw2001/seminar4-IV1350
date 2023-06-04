package se.kth.iv1350.groceryStore.integration;


/**
 * Represents an item in the store that can be purchased by a customer.
 * 
 */

public class Item {
    
private ItemDTO itemDTO;
private int quantity;
private double price;


/**
* Creates a new instance of an item.
* 
* @param itemDTO the DTO that contains information about the item.
* @param quantity the quantity of the item being purchased.
*/

public Item(ItemDTO itemDTO, int quantity){
    this.itemDTO = itemDTO;
    this.quantity = quantity;
    
}


/**
* Returns the DTO containing information about the item.
* 
* @return the DTO of the item.
*/

public ItemDTO getItemDTO(){
    return itemDTO;
}


/**
* Returns the quantity of the item being purchased.
* 
* @return the quantity of the item.
*/

public int getItemQuantity(){
    return quantity;
}


/**
* Returns the description of the item.
* 
* @return the description of the item.
*/

public String getItemDescription() {
    return itemDTO.getItemDescription();
}


/**
* Returns the price of a single unit of the item.
* 
* @return the price of the item.
*/

public double getItemPrice(){
    return itemDTO.getItemPrice();
}
    

/**
*
* Increases the quantity of the item being purchased and
* updates the price of the item based on the new quantity.
*/

public void increaseItemQuantity(){
    quantity++;
    price = itemDTO.getItemPrice() + itemDTO.getItemPrice();
    setItemPriceMultipleQuantity(price);
    
} 


/**
* Sets the quantity of the item being purchased.
* 
* @param quantity the new quantity of the item.
*/

public void setItemQuantity(int quantity){
    this.quantity = quantity;
}


/**
* Sets the DTO containing information about the item.
* 
* @param itemDTO the new DTO of the item.
*/

public void setItemDTO(ItemDTO itemDTO){
    this.itemDTO = itemDTO;
}


/**
* Returns a string representation of the item being purchased.
* 
* @return a string representation of the item being purchased.
*/

public String toString() {
    return "Item: " + itemDTO.getItemDescription() + ", Quantity: " + quantity + ", Price: " + itemDTO.getItemPrice();
}


private void setItemPriceMultipleQuantity(double price) {
   itemDTO.setItemPriceMultipleQuantity(price);
}

}

