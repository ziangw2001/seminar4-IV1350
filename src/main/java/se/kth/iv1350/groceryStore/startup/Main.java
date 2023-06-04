package se.kth.iv1350.groceryStore.startup;
import se.kth.iv1350.groceryStore.integration.SystemCreator;
import se.kth.iv1350.groceryStore.integration.Printer;
import se.kth.iv1350.groceryStore.view.View;
import se.kth.iv1350.groceryStore.controller.Controller;


/**
 *
 * The Main class contains the <code>main</code> method and performs all startup by creating new instances of 
 * SystemCreator, Printer, Controller, and View classes, and executes a sample execution.
 */

public class Main {
   

    /**
     *
     * The main method starts the application by creating new instances of SystemCreator, Printer, Controller,
     * and View classes. It executes a sample execution of the program by using the View class.
     *
     * @param args The application does not take any command line parameters.
     * 
     */
    
     public static void main(String[] args){

        SystemCreator creator = new SystemCreator();
        Printer printer = new Printer();
        Controller contr = Controller.getControllerInstance(creator,printer);
        View view = new View(contr);      
        view.sampleExecution(); 
    }
    
}

