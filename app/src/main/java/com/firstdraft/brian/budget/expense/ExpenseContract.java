package com.firstdraft.brian.budget.expense;

/**
 * Created by brian on 1/31/2017.
 */

interface ExpenseContract {

    interface Model {
        // TODO: 2/1/2017 merge methods to have just getCategories(recurrenceType)
        String[] getRecurringCategories();
        String[] getNonRecurringCategories();
        void saveExpense(Expense expense);
    }

    interface View {
        void showMonetaryInputField();
        void showRecurrenceField();
        void showCategoryMenu(String[] list);
        void showConfirmExpenseButton();
        void showLoadingView();
        void dismissLoadingView();
        void showErrorView(String errorMessage);
        void showExpenseSavedView();
    }

    interface Presenter {
        void bindView(ExpenseContract.View view);
        void unbindView();
        void monetaryInputReceived(Float expenseValue);
        void recurrenceSelected(String recurrenceType);
        void categorySelected(String category);

        void saveExpenseButtonClicked();
    }
}
