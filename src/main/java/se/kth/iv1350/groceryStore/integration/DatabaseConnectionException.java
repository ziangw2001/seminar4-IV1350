package se.kth.iv1350.groceryStore.integration;

/**
 * The exception that is thrown when a database connection error occurs.
 */

public class DatabaseConnectionException extends Exception{
    public DatabaseConnectionException(String message, Throwable cause){
        super(message,cause); 
    }
}