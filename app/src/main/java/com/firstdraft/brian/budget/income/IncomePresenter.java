package com.firstdraft.brian.budget.income;

/**
 * Created by brian on 2/11/2017.
 */
public class IncomePresenter implements IncomeContract.Presenter {
    private IncomeContract.View view;
    private IncomeContract.Model model;

    private Float incomeValue;

    IncomePresenter () {}

    IncomePresenter (IncomeContract.Model model) {
        this.model = model;
    }

    @Override
    public void bindView(IncomeContract.View view) {
        this.view = view;
        view.showMonetaryInputField();
    }

    @Override
    public void unbindView() {
        view = null;
    }

    @Override
    public void receivedMonetaryInput(Float incomeValue) {
        this.incomeValue = incomeValue;
        view.showRecurrenceSpinner();
    }

    @Override
    public void receivedRecurrence(boolean recurrence) {
        view.showCategoriesSpinner(model.getCategories(recurrence));
    }

    @Override
    public void receivedCategory(String category) {
        view.showConfirmIncomeButton();
    }

    @Override
    public void saveIncomeButtonClicked() {
        view.showLoadingView();
        view.dismissLoadingView();
        view.showIncomeSavedView();
    }
}
