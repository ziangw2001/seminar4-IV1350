package se.kth.iv1350.groceryStore.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.groceryStore.controller.Controller;
import se.kth.iv1350.groceryStore.integration.ExtInventorySystem;
import se.kth.iv1350.groceryStore.integration.ItemDTO;
import se.kth.iv1350.groceryStore.integration.ItemInvalidException;
import se.kth.iv1350.groceryStore.integration.DatabaseConnectionException;
import se.kth.iv1350.groceryStore.integration.Printer;
import se.kth.iv1350.groceryStore.integration.SystemCreator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ScanItemTestWithExceptions {
    private Controller controller;
    private SystemCreator mockSystemCreator;

    @BeforeEach
    public void setUp() {
        mockSystemCreator = new SystemCreator() {
            @Override
            public ExtInventorySystem getExtinventorySystem() {
                return new ExtInventorySystem() {
                    @Override
                    public ItemDTO findItem(int itemID) throws ItemInvalidException, DatabaseConnectionException {
                        if (itemID == 12345) {
                            return new ItemDTO(20.0, 12345, "Milk", 200);
                        } else {
                            throw new ItemInvalidException("Item not found", itemID, null);
                        }
                    }
                };
            }
        };

        controller = new Controller(mockSystemCreator, new Printer());
        controller.startNewSale();
    }

    @Test
    public void testScanItem() {
        int validItemID = 12345; 
        String expectedDescription = "Milk";

        try {
            String actualDescription = controller.scanItem(validItemID);
            assertEquals(expectedDescription, actualDescription);
        } catch (ItemInvalidException | DatabaseConnectionException e) {
            fail("Unexpected exception occurred: " + e.getMessage());
        }
    }
}