/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.groceryStore.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.groceryStore.integration.ItemDTO;
/**
 *
 * 
 */
public class AddItemTest {
    
    public AddItemTest() {
    }
    private CurrentSale currentSale;
    private ItemDTO oneItem;
    private ItemDTO anotherItem;
    
    //public ItemDTO (double itemPrice, int itemIdentifier, String itemDescription, int itemQuantity)
    @BeforeEach
    public void setUp() {
        currentSale = new CurrentSale();
        oneItem = new ItemDTO(20.0, 23456, "Bread", 2);
        anotherItem = new ItemDTO(10.0, 34567, "Cola", 3);
        
        
        
    }

    @Test
    public void testAddItem() {
       currentSale.addItem(oneItem);
            assertEquals(20.0, currentSale.getRunningTotal());
            assertEquals(22.4, currentSale.getTotalPriceInclVAT(),0.001);
       
       currentSale.addItem(oneItem);
            assertEquals(40.0, currentSale.getRunningTotal());
            assertEquals(44.8, currentSale.getTotalPriceInclVAT(),0.001);
       
       currentSale.addItem(anotherItem);
            assertEquals(50.0, currentSale.getRunningTotal());
            assertEquals(56.0, currentSale.getTotalPriceInclVAT(), 0.001);
        
       currentSale.addItem(anotherItem);
            assertEquals(60.0, currentSale.getRunningTotal());
            assertEquals(67.2, currentSale.getTotalPriceInclVAT(), 0.001);
        
        currentSale.addItem(anotherItem);
            assertEquals(70.0, currentSale.getRunningTotal());
            assertEquals(78.4, currentSale.getTotalPriceInclVAT(), 0.001);
       
       
    }

    /*@Test
    public void testGetRunningTotal() {
        System.out.println("getRunningTotal");
        CurrentSale instance = new CurrentSale();
        double expResult = 0.0;
        double result = instance.getRunningTotal();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetVAT() {
        System.out.println("getVAT");
        CurrentSale instance = new CurrentSale();
        double expResult = 0.0;
        double result = instance.getVAT();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTotalPriceInclVAT() {
        System.out.println("getTotalPriceInclVAT");
        CurrentSale instance = new CurrentSale();
        double expResult = 0.0;
        double result = instance.getTotalPriceInclVAT();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPrint() {
        System.out.println("print");
        StringBuilder builder = null;
        CurrentSale instance = new CurrentSale();
        instance.print(builder);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPay() {
        System.out.println("pay");
        double amountPaid = 0.0;
        CurrentSale instance = new CurrentSale();
        instance.pay(amountPaid);
        fail("The test case is a prototype.");*/

    
}
