/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.groceryStore.integration;

import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;


public class WriteToLoggerTest {

    @Test
    public void testWriteExceptionToFile() {
        System.out.println("Running testWriteExceptionToFile...");

        String exceptionMessage = "ItemID 23412 cannot be found in inventory.";
        Exception exception = new Exception(exceptionMessage);

        WriteToLogger logger = new WriteToLogger();
        logger.writeExceptionToFile(exception);

        // Verify that the exception message is logged to the file
        try (BufferedReader reader = new BufferedReader(new FileReader("exceptionsLog.log"))) {
            String loggedMessage = reader.readLine();
            assertEquals(exceptionMessage, loggedMessage);
        } catch (IOException e) {
            fail("Failed to read the log file.");
        }

        System.out.println("Test completed successfully!");
    }
@Test
    public void testWriteTotalRevenueToFile() {
        System.out.println("Running testWriteTotalRevenueToFile...");

        String totalRevenue = "Current income: 61.6 kr";

        WriteToLogger logger = new WriteToLogger();
        logger.writeTotalRevenueToFile(totalRevenue);

        // Verify that the total revenue is logged to the file
        try (BufferedReader reader = new BufferedReader(new FileReader("log.log"))) {
            String loggedRevenue = reader.readLine();
            assertEquals(totalRevenue, loggedRevenue);
        } catch (IOException e) {
            fail("Failed to read the log file.");
        }

        System.out.println("Test completed successfully!");
    }
}