package com.firstdraft.brian.budget.home;

/**
 * Created by brian on 2/6/2017.
 */
class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;
    private HomeContract.Model model;

    HomePresenter() {
    }

    HomePresenter(HomeContract.Model model) {
        this.model = model;
    }

    @Override
    public void bindView(HomeContract.View view) {
        this.view = view;
        view.showDate(model.getMonthAndYear());
        view.showMonthBalance(model.getMonthBalance());
    }

    @Override
    public void unbindView() {
        view = null;
    }

    @Override
    public void addExpenseButtonClicked() {
        view.navigateToAddExpenseView();
    }

    @Override
    public void addIncomeButtonClicked() {
        view.navigateToAddIncomeView();
    }

    @Override
    public void reportsButtonClicked() {
        view.navigateToReportsView();
    }
}
