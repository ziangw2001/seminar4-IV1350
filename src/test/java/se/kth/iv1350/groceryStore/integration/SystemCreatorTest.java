/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.groceryStore.integration;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * 
 */
public class SystemCreatorTest {
    private SystemCreator systemCreator;
   
    
    @BeforeEach
    public void setUp() {
        systemCreator = new SystemCreator();
    }
    
    @Test
    public void testGetExtInventorySystem() {
        assertNotNull(systemCreator.getExtinventorySystem());
    }

    @Test
    public void testGetAccountingSystem() {
        assertNotNull(systemCreator.getAccountingSystem());
    }
    
}
