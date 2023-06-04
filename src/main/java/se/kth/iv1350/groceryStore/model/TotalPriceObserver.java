  package se.kth.iv1350.groceryStore.model;

/**
 * The TotalPriceObserver interface represents an observer that receives updates from {@link Controller}
 * when a new total price (including VAT) is calculated.
 */

public interface TotalPriceObserver {
      
    void newTotalPrice(double totalPriceInclVAT);
    
}
