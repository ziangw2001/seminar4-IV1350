package se.kth.iv1350.groceryStore.integration;

 /**
 * Responsible for instantiating the systems required for basic and alternative flows.
 * This includes an external inventory system and an external accounting system.
 */

public class SystemCreator {
    ExtInventorySystem inventorySystem = new ExtInventorySystem();
    ExtAccountingSystem accountingSystem = new ExtAccountingSystem();
    

    /**
     * Getter method for the external inventory system.
     * @return the external inventory system
     */

    public ExtInventorySystem getExtinventorySystem(){
        return inventorySystem;
    } 
    
     /**
     * Getter method for the external accounting system.
     * @return the external accounting system
     */

    public ExtAccountingSystem getAccountingSystem(){
        return accountingSystem;
    }
}