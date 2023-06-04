  package se.kth.iv1350.groceryStore.view;

/**
 * The <code>TotalRevenueView</code> class is an implementation of the <code>TotalIncomeObserverTemplate</code> abstract class (template pattern).
 * It represents a component in the view that displays the total revenue of all sales made since the program started. 
 * 
 */

public class TotalRevenueView extends TotalIncomeObserverTemplate {

    private double totalRevenue;

    
    @Override
    protected void calculateTotalIncome(double totalPrice) {
        totalRevenue += totalPrice;
    }

    @Override
    protected void doShowTotalIncome() throws Exception {
        System.out.println("Total revenue observer: " + totalRevenue);
    }

    @Override
    protected void handleErrors(Exception e) {
        e.printStackTrace();
    }
}

