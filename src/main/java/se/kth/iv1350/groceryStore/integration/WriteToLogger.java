
package se.kth.iv1350.groceryStore.integration;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The WriteToLogger class is responsible for logging exceptions to a file.
 * It implements the Logger interface.
 */

public class WriteToLogger implements Logger {
    private PrintWriter logAdd;

    /**
     * Logs an exception to the log file.
     *
     * @param exception The exception to be logged.
     */

    
    public void writeExceptionToFile(Exception exception) {
        try (PrintWriter exceptionWriter = new PrintWriter(new FileWriter("exceptionsLog.log", true))) {
            exceptionWriter.println(exception.getMessage());
        } catch (IOException e) {
            System.out.println("Failed to log exception to exceptionsLog.log.");
        }
    }
    
    /**
     * Logs the total   to the log file.
     *
     * @param totalRevenue The total revenue to be logged.
     */

    public void writeTotalRevenueToFile(String totalRenevue){
       try (PrintWriter renevueWriter = new PrintWriter(new FileWriter("log.log", true))) {
            renevueWriter.println(totalRenevue);
        } catch (IOException e) {
            System.out.println("Failed to log exception to exceptionsLog.log.");
        }
    } 

    /**
     * Logs a message to the log file.
     * This method is required by the Logger interface.
     *
     * @param message The message to be logged.
     */

    @Override
    public void log(String message) {
        logAdd.println(message);
    }
}
    