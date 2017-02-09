package com.firstdraft.brian.budget.home;

/**
 * Created by brian on 2/5/2017.
 */

public interface HomeContract {

    interface Model {
        String getMonthandYear();

        Float getMonthBalance();
    }

    interface View {
        void showDate();

        void showMonthBalance();
    }

    interface Presenter {
        void bindView(HomeContract.View view);

        void unbindView();

        void clickedAddExpenseButton();

        void clickedAddIncomeButton();

        void clickedReportButton();
    }
}
