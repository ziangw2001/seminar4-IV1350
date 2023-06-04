
package se.kth.iv1350.groceryStore.integration;
import java.lang.Exception;

/**
 * The {@link ItemInvalidException} class is an exception that is thrown when an item is invalid or not found.
 */

public class ItemInvalidException extends Exception {
    private int itemID;


/**
     * Constructs a new {@link ItemInvalidException} with the specified error message and cause.
     *
     * @param message The error message describing the reason for the exception.
     * @param cause   The cause of the exception.
     */

     public ItemInvalidException(String message, int itemID, Throwable cause) {
        super(message, cause);
 
    }
     
     public int getItemID() {
         return itemID;
     }
}
   





