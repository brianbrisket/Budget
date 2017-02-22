package com.firstdraft.brian.budget.expense;

/**
 * Created by brian on 2/1/2017.
 */
class ExpenseModel implements ExpenseContract.Model {

    ExpenseModel() {}

    @Override
    public String[] getRecurringCategories() {
        return new String[]{"Rent", "Renter's Insurance", "Car Insurance",
                "Cell Phone", "Car Payments"};
    }

    @Override
    public String[] getNonRecurringCategories() {
        return new String[]{"Groceries", "Gas", "Clothing"};
    }

    @Override
    public void saveExpense(Expense expense) {
        // TODO: 2/1/2017 save to local db
    }
}
