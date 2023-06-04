/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.groceryStore.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DatabaseConnectionExceptionTest {
@Test
    public void testDatabaseConnectionExceptionWithMessageAndCause() {
        System.out.println("Running testDatabaseConnectionExceptionWithMessageAndCause...");

        String errorMessage = "Failed to establish a database connection.";
        Throwable cause = new RuntimeException("Connection timeout.");

        DatabaseConnectionException exception = new DatabaseConnectionException(errorMessage, cause);

        assertNotNull(exception);
        assertEquals(errorMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());

        System.out.println("Test completed successfully!!!");
    }
}