
package se.kth.iv1350.groceryStore.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The receipt of a sale.
 * 
 */
public class Receipt {
    private CurrentSale currentSale;


    
    public Receipt(CurrentSale currentSale){
        this.currentSale = currentSale;
    }
    
    public String printReceipt(){ 
        StringBuilder builder = new StringBuilder();
        appendLine(builder, System.lineSeparator() + "LIDL Kista AB");
        builder.append("-------------" + System.lineSeparator()); 
        currentSale.print(builder);        
        builder.append("Runningtotal: ");
        appendLine(builder, String.valueOf(currentSale.getRunningTotal()));
        
        builder.append("VAT: ");
        appendLine (builder, String.valueOf(currentSale.getVAT())); 
        
        builder.append("Total Incl VAT: ");
        appendLine (builder, String.valueOf(currentSale.getTotalPriceInclVAT())); 
        
        LocalDateTime dateAndTime = LocalDateTime.now();
        DateTimeFormatter dateAndTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd. HH:mm:ss");
        String formatter = dateAndTime.format(dateAndTimeFormatter);
        builder.append("Date and time: ");
        appendLine(builder, formatter.toString());
        
        endSection(builder);
        
        
        return builder.toString();
    }
    
    private void appendLine(StringBuilder builder, String line){
        builder.append(line);
        builder.append(System.lineSeparator());
    }
    
    private void endSection(StringBuilder builder){
        builder.append(System.lineSeparator());
    }
}
