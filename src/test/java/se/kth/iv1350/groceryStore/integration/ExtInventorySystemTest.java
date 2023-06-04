/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.groceryStore.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.groceryStore.integration.DatabaseConnectionException;
import se.kth.iv1350.groceryStore.integration.ExtInventorySystem;
import se.kth.iv1350.groceryStore.integration.ItemDTO;
import se.kth.iv1350.groceryStore.integration.ItemInvalidException;

import static org.junit.jupiter.api.Assertions.*;

public class ExtInventorySystemTest {
    private ExtInventorySystem inventorySystem;

    @BeforeEach
    public void setUp() {
        inventorySystem = new ExtInventorySystem();
    }

    @Test
    public void testFindExistingItem() {
        int validItemID = 12345; 
        ItemDTO expectedItem = new ItemDTO(20.0, 12345, "Milk", 200);

        try {
            ItemDTO actualItem = inventorySystem.findItem(validItemID);
            assertEquals(expectedItem, actualItem);
        } catch (ItemInvalidException | DatabaseConnectionException e) {
            fail("Unexpected exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testFindNonExistingItem() {
        int invalidItemID = 999; 

        assertThrows(ItemInvalidException.class, () -> {
            inventorySystem.findItem(invalidItemID);
        });
    }

    @Test
    public void testFindItemWithDatabaseConnectionError() {
        inventorySystem.setThrowDatabaseConnectionException(true); 

        int validItemID = 12345; 

        assertThrows(DatabaseConnectionException.class, () -> {
            inventorySystem.findItem(validItemID);
        });
    }
}