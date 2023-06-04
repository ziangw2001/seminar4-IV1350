package se.kth.iv1350.groceryStore.model;
import se.kth.iv1350.groceryStore.integration.ItemDTO;
import se.kth.iv1350.groceryStore.integration.Item;
import java.util.List;
import java.util.ArrayList;
import se.kth.iv1350.groceryStore.view.TotalRevenueFileOutput;
import se.kth.iv1350.groceryStore.view.TotalRevenueView;


/**
 * This class represents the current sale.
 * It contains a list of items and methods for managing and updating the current sale.
 * 
 */

public class CurrentSale{
   
    private double runningTotal;
    private double VAT;
    private double totalPriceInclVAT;
    private Payment payment;
    private final List <Item> currentSaleList;
    private CurrentSale currentSale; 
    
    private List<TotalPriceObserver> totalPriceObservers = new ArrayList<>();
    private TotalRevenueView totalRevenueView = new TotalRevenueView();
    private TotalRevenueFileOutput totalRevenueFileOutput = new TotalRevenueFileOutput();

    private boolean endSale;


    /**
    * Creates an instance of CurrentSale with an empty list of items, and sets the value of VAT to 12%.
    */

    public CurrentSale(){     
        currentSaleList = new ArrayList<Item>();     
        VAT = 0.12;    
    }
        
    public CurrentSale getCurrentSale(){
        return this.currentSale;
    }

    /**
    * Adds an item to the current sale.
    * If the item already exists in the list, its quantity is increased by 1. 
    * If the item does not exist in the list, a new item is created with quantity 1.
    * Updates the running total and total price incl. VAT.
    * @param foundItem the <code>{@link se.kth.iv1350.groceryStore.integration.ItemDTO ItemDTO}</code> to be added to the current sale
    * 
    */


    public void addItem(ItemDTO foundItem){    
        for(int count = 0; count < currentSaleList.size(); count++){
            if(currentSaleList.get(count) != null && currentSaleList.get(count).getItemDTO()== foundItem){      
                currentSaleList.get(count).increaseItemQuantity();
                runningTotal += foundItem.getItemPrice();
                totalPriceInclVAT = runningTotal + runningTotal * VAT;
                
                return;                   
            }
        }
            Item newScannadItem = new Item(foundItem,1);
            newScannadItem.setItemDTO(foundItem);
            currentSaleList.add(newScannadItem);
            runningTotal += foundItem.getItemPrice();
            totalPriceInclVAT = runningTotal + runningTotal * VAT;
            
            
    }
    

    /**
    * Returns the current running total of the sale.
    * @return the running total
    */

    public double getRunningTotal(){
        
        return this.runningTotal;
        
    }
    

    /**
    * Returns the VAT of the sale.
    * @return the VAT value
    */

    public double getVAT(){
        return this.VAT;
    }


    /**
    * Returns the total price including VAT of the sale.
    * @return the total price including VAT
    */

      public double getTotalPriceInclVAT(){
          //notifyObservers();
          return this.totalPriceInclVAT;
    }
      
    /**
     * set running total to a amount;
     * @param the running total 
     */  
      
      public void setRunningTotal(int runningTotal){
          this.runningTotal = runningTotal;
      }
   

    /**
    * Prints the list of items in the current sale to a StringBuilder.
    * @param builder the StringBuilder object used for building the output.
    */

    public void print(StringBuilder builder){
        
        for(int i = 0; i < currentSaleList.size(); i++){
            builder.append("Item: ");
            appendLine(builder, this.currentSaleList.get(i).getItemDTO().getItemDescription());
            
            builder.append("Item Price: ");
            appendLine(builder, String.valueOf(this.currentSaleList.get(i).getItemPrice())); 
 
            
            builder.append("Quantity: ");
            appendLine(builder, String.valueOf(this.currentSaleList.get(i).getItemQuantity())); 
 
            builder.append("Price: ");
            appendLine(builder, String.valueOf((this.currentSaleList.get(i).getItemQuantity()) * this.currentSaleList.get(i).getItemPrice()) + System.lineSeparator()); 
           
        }
    }
    
    private void appendLine(StringBuilder builder, String line){
        builder.append(line);
        builder.append(System.lineSeparator());
    }
    
    public void completeScan(){
        endSale = true;
        totalPriceInclVAT = runningTotal + runningTotal * VAT;
        notifyObservers();
    }

    /**
    * Processes a payment for the sale with the given amount and creates a Payment object.
    * @param amountPaid the amount paid by the customer
    */

    public void pay(double amountPaid){
        payment = new Payment();
        payment.pay(amountPaid);
    }
    
    public void notifyObservers() {
        for (TotalPriceObserver totalPriceObs : totalPriceObservers) {
            totalPriceObs.newTotalPrice(totalPriceInclVAT);
        }
    }
      
    public void addTotalPriceObserver(TotalPriceObserver totalPriceObs) {
        totalPriceObservers.add(totalPriceObs);
    }   
}