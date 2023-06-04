package se.kth.iv1350.groceryStore.view;

import se.kth.iv1350.groceryStore.model.TotalPriceObserver;

/**
 * This abstract class is a template the observers. It implements the TotalPriceObserver interface
 * and provides a template method for calculating and showing the total income.
 * 
 */

public abstract class TotalIncomeObserverTemplate implements TotalPriceObserver {

    @Override
    public void newTotalPrice(double totalPrice) {
        calculateTotalIncome(totalPrice);
        showTotalIncome();
    }

    private void showTotalIncome() {
        try {
            doShowTotalIncome();
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    protected abstract void calculateTotalIncome(double totalPrice);

    protected abstract void doShowTotalIncome() throws Exception;

    protected abstract void handleErrors(Exception e);
}
