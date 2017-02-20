package com.firstdraft.brian.budget.home;

/**
 * Created by brian on 2/5/2017.
 */

public interface HomeContract {

    interface Model {
        String getMonthAndYear();
        Float getMonthBalance();
    }

    interface View {
        void showMonthAndYear(String date);
        void showMonthBalance(Float balance);
        void navigateToAddExpenseView();
        void navigateToAddIncomeView();
        void navigateToReportsView();
    }

    interface Presenter {
        void bindView(HomeContract.View view);
        void unbindView();
        void addExpenseButtonClicked();
        void addIncomeButtonClicked();
        void reportsButtonClicked();
    }
}
