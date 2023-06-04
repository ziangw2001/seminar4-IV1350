package se.kth.iv1350.groceryStore.view;

import se.kth.iv1350.groceryStore.integration.WriteToLogger;
import se.kth.iv1350.groceryStore.view.TotalIncomeObserverTemplate;

//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;

/**
 * The TotalRevenueFileOutput class tracks and displays the total revenue from sales. 
 *
 */

public class TotalRevenueFileOutput extends TotalIncomeObserverTemplate {

    private double totalRevenue = 0;
    private WriteToLogger writeToLogger = new WriteToLogger();


/**
 * Creates an instance of TotalRevenueFileOutput and initializes the WriteToLogger object.
 * 
 */

    public TotalRevenueFileOutput() {
        writeToLogger = new WriteToLogger();
    }

    @Override
    protected void calculateTotalIncome(double totalPrice) {
        totalRevenue += totalPrice;
        
    }

    @Override
    protected void doShowTotalIncome() throws Exception {
        writeToLogger.writeTotalRevenueToFile("Current income: " + String.valueOf(totalRevenue) + " kr");
    }

    @Override
    protected void handleErrors(Exception e) {
        System.out.println("Failed to log exception to exceptionsLog.log.");
        e.printStackTrace();
    }
    
    public double getRevenue(){
        return this.totalRevenue;
    }
}
