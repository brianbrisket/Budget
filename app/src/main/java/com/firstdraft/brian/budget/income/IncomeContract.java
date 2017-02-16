package com.firstdraft.brian.budget.income;

/**
 * Created by brian on 2/8/2017.
 */

public interface IncomeContract {

    interface Model {
        String[] getCategories(boolean recurrence);
        void saveIncome(Float incomeValue);
    }

    interface View {
        void showMonetaryInputField();
        void showRecurrenceSpinner();
        void showCategoriesSpinner(String[] list);
        void showConfirmIncomeButton();
        void showLoadingView();
        void dismissLoadingView();
        void showErrorView(String errorMessage);
        void showIncomeSavedView();
    }

    interface Presenter {
        void bindView(IncomeContract.View view);
        void unbindView();
        void monetaryInputReceived(Float incomeValue);
        void recurrenceSelected(boolean recurrence);
        void categorySelected(String category);
        void saveIncomeButtonClicked();
    }
}