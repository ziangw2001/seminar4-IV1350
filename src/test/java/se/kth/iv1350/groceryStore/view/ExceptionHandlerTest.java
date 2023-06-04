/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.groceryStore.view;


import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;


public class ExceptionHandlerTest {
    private ByteArrayOutputStream outputStream;


  @BeforeEach
    public void setup() {

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }


    @AfterEach
    public void teardown() {

        System.setOut(System.out);
        try {
            outputStream.close();
        } catch (Exception e) {

        }
    }
 @Test
    public void testHandleException() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Exception exception = new Exception("Test Exception: This is a test exception.");

        ExceptionHandler.handleException(exception);

        String printedOutput = outputStream.toString();

        String expectedOutput = "ERROR: This is a test exception.";
        assertEquals(expectedOutput.trim(), printedOutput.trim());
}
    }