package se.kth.iv1350.groceryStore.integration;

import se.kth.iv1350.groceryStore.model.CurrentSale;

/**
 * This is the application's inventory system which contains information about all items in the store.
 * It also retrieves and updates item information.
 */
public class ExtInventorySystem {

    ItemDTO item1 = new ItemDTO(20.0, 12345, "Milk", 200);
    ItemDTO item2 = new ItemDTO(35.0, 23456, "Bread", 150);
    ItemDTO item3 = new ItemDTO(10.0, 34567, "Cola", 500);

    private final ItemDTO[] findItemList = {item1, item2, item3};
    private boolean throwDatabaseConnectionException;

    /**
     * This method finds the item with the specified item identifier.
     * Cause is right now set to null but it could be an error code when deployed.
     *
     * @param itemID The identifier of the item to find.
     * @return The {@link ItemDTO} with the specified identifier. Null if the item is not found.
     */
    public ItemDTO findItem(int itemID) throws ItemInvalidException, DatabaseConnectionException {
        if (throwDatabaseConnectionException) {
            throw new DatabaseConnectionException("Database is not running.", null);
        }

        for (ItemDTO item : findItemList) {
            if (item.getItemIdentifier() == itemID) {
                return item;
            }
        }
        throw new ItemInvalidException("ItemID doesn't exist in database", itemID, null);
    }

    /**
     * Updates the inventory system with the specified {@link CurrentSale} object.
     *
     * @param currentSale The {@link CurrentSale} object that contains the sold items.
     */
    public void updateInventorySystem(CurrentSale currentSale) {
        // Perform the update logic here
        return;
    }

    /**
     * Set the flag to control the throwing of DatabaseConnectionException.
     *
     * @param throwException Flag to indicate whether to throw DatabaseConnectionException or not.
     */
    public void setThrowDatabaseConnectionException(boolean throwException) {
       this.throwDatabaseConnectionException = throwException;
    }
}
