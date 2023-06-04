/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.groceryStore.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class ItemInvalidExceptionTest {

      @Test
    public void testItemInvalidExceptionWithMessageAndCause() {
        System.out.println("Running testItemInvalidExceptionWithMessageAndCause...");

        String errorMessage = "Item is invalid or not found.";
        Throwable cause = new RuntimeException("Invalid item ID.");

        ItemInvalidException exception = new ItemInvalidException(errorMessage, 0 ,cause);

        assertNotNull(exception);
        assertEquals(errorMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());

        System.out.println("Test completed succefully!!!");
    }

}