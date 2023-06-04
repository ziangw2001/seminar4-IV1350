package se.kth.iv1350.groceryStore.controller;


import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.groceryStore.integration.Printer;
import se.kth.iv1350.groceryStore.integration.SystemCreator;
import se.kth.iv1350.groceryStore.model.CashRegister;
import se.kth.iv1350.groceryStore.integration.ItemDTO;
import se.kth.iv1350.groceryStore.integration.ItemInvalidException;
import se.kth.iv1350.groceryStore.integration.DatabaseConnectionException;
import se.kth.iv1350.groceryStore.model.TotalPriceObserver;
import se.kth.iv1350.groceryStore.view.TotalRevenueFileOutput;
import se.kth.iv1350.groceryStore.model.CurrentSale;
import se.kth.iv1350.groceryStore.model.Receipt;
import se.kth.iv1350.groceryStore.view.TotalRevenueView;


/**
 *
 * This is the application's only controller class. All calls to the model pass through here.
 */

public class Controller {
    private CashRegister cashregister = new CashRegister();
    private CurrentSale currentSale;
    private SystemCreator creator;
    private Printer printer;
    private Receipt receipt;
    private static Controller instance;
    private List<TotalPriceObserver> totalPriceObservers = new ArrayList<>();
    private TotalRevenueView totalRevenueView = new TotalRevenueView();
    private TotalRevenueFileOutput totalRevenueFileOutput = new TotalRevenueFileOutput();



     public Controller(SystemCreator creator, Printer printer) {
        this.creator = creator;
        this.printer = printer;
        }

    /**
     * Retrieves an instance of the Controller class (singleton pattern).
     *
     * @param creator Used to get all classes that handle database calls. (InventorySystem, AccountingSystem)
     * @param printer Printer is used to print out the receipt.
     * @return The Controller instance.
     */

    public static Controller getControllerInstance(SystemCreator creator, Printer printer) {
        if (instance == null) {
            instance = new Controller(creator, printer);
        }
        return instance;
    }
    
    /**
     * Starts a new sale by initializing the current sale and setting the running total to 0.
     */

    public void startNewSale(){
        currentSale = new CurrentSale();
        currentSale.setRunningTotal(0);
        currentSale.addTotalPriceObserver(totalRevenueView);
        currentSale.addTotalPriceObserver(totalRevenueFileOutput);
    }
    
    /**
     * Adds an item to the current sale by finding the item with the specified item ID.
     * Original cause of exceptions (for example error codes) can be displayed to the developer by including the omitted print lines.
     * Now the cause it set to null.
     * 
     * @param itemID The item identifier for the scanned item.
     * @return The description of the scanned item.
     * @throws ItemInvalidException       If the item is not found in the inventory.
     * @throws DatabaseConnectionException If an error occurs while accessing the database.
     */
    

public String scanItem(int itemID) throws ItemInvalidException, DatabaseConnectionException {
    try {
        ItemDTO foundItem = creator.getExtinventorySystem().findItem(itemID);
        
        currentSale.addItem(foundItem);
        return foundItem.getItemDescription();
    } catch (ItemInvalidException itemInvalidException) {

        //System.out.println(itemInvalidException.getCause());
        //System.out.println(itemInvalidException.getMessage());

       //throw new ItemInvalidException("ItemID " + itemID + " cannot be found in inventory.", itemInvalidException);
       throw new ItemInvalidException("ItemID " + itemID + " cannot be found in inventory.", itemID, itemInvalidException);
       
    } catch (DatabaseConnectionException connectionError) {

        //System.out.println(connectionError.getCause());
        //System.out.println(connectionError.getMessage());
        
        throw new DatabaseConnectionException("An error occurred while accessing the database.", connectionError);
    }
}

/**
* The method initializes the payment. It passes the payment amount to the currentSale instance and CashRegister, 
* updates the inventory and accounting systems with the currentSale object, and then creates a receipt using the 
* currentSale object. Finally, the receipt is printed using the {@link Printer} instance.
*
* @param amountPaid The amount paid by the customer.
*/


    public void inizializePayment(double amountPaid){
        currentSale.completeScan();
        currentSale.pay(amountPaid);
        creator.getExtinventorySystem().updateInventorySystem(currentSale);
        creator.getAccountingSystem().updateAccountingSystem(currentSale); 
        cashregister.addPayment(amountPaid,currentSale);
        receipt = new Receipt(currentSale);
        printer.printReceipt(receipt);
    }

    
    public void addTotalPriceObserver(TotalPriceObserver totalPriceObs){
        totalPriceObservers.add(totalPriceObs);
    }
}