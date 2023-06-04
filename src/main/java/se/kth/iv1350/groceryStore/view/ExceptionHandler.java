package se.kth.iv1350.groceryStore.view; 

/**
 * The <code>ExceptionHandler</code> class is responsible for handling exceptions and displaying error messages.
 */


public class ExceptionHandler {

    /**
     * Handles the given exception by extracting the error message and cause, and printing them to the console.
     *
     * @param exception The exception to handle.
     */

    public static void handleException(Exception exception) {
        String exceptionMessage = exception.getMessage();
        int index = exceptionMessage.lastIndexOf(':');
        if (index != -1) {
            exceptionMessage = exceptionMessage.substring(index + 2);
        }

        Throwable cause = exception.getCause();

            System.out.println("ERROR: " + exceptionMessage);
            if (cause != null) {
            System.out.println("Cause: " + cause.getMessage());
        }
    }
}