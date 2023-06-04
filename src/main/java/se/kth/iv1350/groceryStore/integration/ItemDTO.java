package se.kth.iv1350.groceryStore.integration;


/**
 * Contains information about one particular item's price, identifier, description, and quantity.
 */


public final class ItemDTO {
    private  double itemPrice;
    private  double itemPriceMultipleQuantity;
    private  int    itemIdentifier;
    private  String itemDescription;
    private  int    itemQuantity;
    

    /**
     * Creates a new instance of ItemDTO.
     * 
     * @param itemPrice         The price of the item.
     * @param itemIdentifier    The identifier of the item.
     * @param itemDescription   The description of the item.
     * @param itemQuantity      The quantity of the item.
     */
    
    public ItemDTO (double itemPrice, int itemIdentifier, String itemDescription, int itemQuantity)
    {
        this.itemPrice = itemPrice;
        this.itemIdentifier = itemIdentifier;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
    }
    
    
    /**
     * Returns the identifier of the item.
     * 
     * @return the identifier of the item
     */

    public int getItemIdentifier(){
        return itemIdentifier;
    }
    

     /**
     * Returns the quantity of the item.
     * 
     * @return the quantity of the item
     */

    public int getItemQuantity(){
        return itemQuantity;
    }


    /**
     * Returns the description of the item.
     * 
     * @return the description of the item
     */
    
    public String getItemDescription(){
        return itemDescription;
    }


    /**
    * Returns the price of the item.
    * 
    * @return the price of the item
    */

    public double getItemPrice(){
        return itemPrice;
    }
    

    /**
    * Returns the price of the item multiplied by the quantity.
    * 
    * @return the price of the item multiplied by the quantity
    */

    public double getItemPriceMultipleQuantity(){
        return itemPriceMultipleQuantity;
    }
    

    /**
     * Sets the identifier of the item.
     * 
     * @param id the identifier of the item
     */

    public void setItemIdentifier(int id){
        itemIdentifier = id;
    }
    

    /**
     * Sets the quantity of the item.
     * 
     * @param quantity the quantity of the item
     */

    public void setItemQuantity(int quantity){
        itemQuantity = quantity;
    }
    

    /**
     * Sets the price of the item.
     * 
     * @param itemPrice the price of the item
     */

    public void setItemPrice(double itemPrice){
        this.itemPrice = itemPrice;
    }
    

    /**
     * Sets the price of the item multiplied by the quantity.
     * 
     * @param itemPrice the price of the item multiplied by the quantity
     */

    public void setItemPriceMultipleQuantity(double itemPriceMultipleQuantity){
        this.itemPriceMultipleQuantity = itemPriceMultipleQuantity;
    }

    /**
     *
     * @param obj
     * @return
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ItemDTO other = (ItemDTO) obj;
        return Double.compare(other.itemPrice, itemPrice) == 0
                && Double.compare(other.itemPriceMultipleQuantity, itemPriceMultipleQuantity) == 0
                && itemIdentifier == other.itemIdentifier
                && itemQuantity == other.itemQuantity
                && itemDescription.equals(other.itemDescription);
    }
}
  
