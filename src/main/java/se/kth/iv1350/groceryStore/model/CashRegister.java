package se.kth.iv1350.groceryStore.model;

/**
 * This class represents a cash register in the store. 
 * It keeps track of the amount of money in the cash register, and handles payments for the current sale.
 * 
 */

public class CashRegister {   
    private CurrentSale currentSale;        
    private double cashRegister;
    private double change;
    

    /**
    * Creates an instance of CashRegister with an initial amount of 9000 SEK.
    */

    public CashRegister (){
        cashRegister = 9000;
    }
    

    /**
    * Adds the payment to the cash register and returns the change.
    * If the amount paid is equal to the total price of the current sale, no change is given.
    * If the amount paid is greater than the total price of the current sale, the change is calculated and returned.
    * If the amount paid is less than the total price of the current sale, an IllegalArgumentException is thrown with information about the invalid payment amount and the amount remaining to be paid.
    * @param amountPaid the amount paid by the customer
    * @param currentSale the current sale being paid for
    * @return the change (if any)
    * @throws IllegalArgumentException if the amount paid is less than the total price of the current sale
    */


    public double addPayment(double amountPaid, CurrentSale currentSale){
        cashRegister += amountPaid;
       
        if (amountPaid == currentSale.getTotalPriceInclVAT()){ 
            change = 0;
            return change;
        }
        if (amountPaid > currentSale.getTotalPriceInclVAT()){
            change = amountPaid - currentSale.getTotalPriceInclVAT();
            cashRegister -= change;
            return change;
        }
        else{
            double amountToPay = currentSale.getTotalPriceInclVAT() - amountPaid;
            throw new IllegalArgumentException("Invalid amount paid: " + amountPaid + " Amount cash to pay: " + amountToPay);  
        }

    }

    /**
    * Returns the amount of change for this current payment.
    * @return the change
    */

    public double getChange(){
        return change;
    }
}