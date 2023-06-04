
package se.kth.iv1350.groceryStore.view;

import se.kth.iv1350.groceryStore.controller.Controller;
import se.kth.iv1350.groceryStore.integration.ItemInvalidException;
import se.kth.iv1350.groceryStore.integration.DatabaseConnectionException;
import se.kth.iv1350.groceryStore.integration.WriteToLogger;



/**
 * This program currently has no view, this class is a placeholder for the entire view. It interacts with the controller class to execute.
 */

public class View {
    private final Controller contr; 
    private String item;
    private WriteToLogger writeToLogger = new WriteToLogger();


    /**
     * Creates a new instance of the View class.
     *
     * @param contr The controller that is used for all operations.
     */
     
   
    public View (Controller contr) {
        this.contr = contr;
    
    }

    /**
     * Simulates a cashier scanning items and initializing a payment. This method is used for sample execution of the program.
     * 
     */
    
    public void sampleExecution() {
        
        //Sale 1
        System.out.println("Cashier starts a new sale.");
        contr.startNewSale();
    
        itemProcessor(12345);
        itemProcessor(23412);
        itemProcessor(99999);
        itemProcessor(39481);
        itemProcessor(23456);
        contr.inizializePayment(500);
        
        //Sale 2
        System.out.println("Cashier starts a new sale.");
        contr.startNewSale();
        itemProcessor(12345);
        contr.inizializePayment(500);
        
        //Sale 3 
        System.out.println("Cashier starts a new sale.");
        contr.startNewSale();
        itemProcessor(12345);
        itemProcessor(23456);
        itemProcessor(99999);
        itemProcessor(34567);
        contr.inizializePayment(500);
    }
    

    private void itemProcessor(int itemID) {
        try {
            item = contr.scanItem(itemID);
            System.out.println("Cashier scans a " + item);
        } catch (ItemInvalidException itemInvalid) {
            ExceptionHandler.handleException(itemInvalid);
            writeToLogger.writeExceptionToFile(itemInvalid);
        } catch (DatabaseConnectionException connectionFailed) {
            ExceptionHandler.handleException(connectionFailed);
            writeToLogger.writeExceptionToFile(connectionFailed);
        } 
    }
}