package com.firstdraft.brian.budget.expense;

import android.content.ContentValues;

import com.firstdraft.brian.budget.data.BudgetProvider;

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
        ContentValues values = new ContentValues();
        values.put(BudgetProvider.COLUMN_AMOUNT, expense.getExpenseValue());
        values.put(BudgetProvider.COLUMN_RECURRENCE, expense.getRecurrence());
        values.put(BudgetProvider.COLUMN_CATEGORY, expense.getCategory());
    }
}
