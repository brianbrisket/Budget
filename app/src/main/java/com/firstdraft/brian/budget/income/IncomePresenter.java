package com.firstdraft.brian.budget.income;

/**
 * Created by brian on 2/11/2017.
 */
public class IncomePresenter implements IncomeContract.Presenter {
    private IncomeContract.View view;
    private IncomeContract.Model model;

    private Float incomeValue;

    IncomePresenter () { this(new IncomeModel());}

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
    public void monetaryInputReceived(Float incomeValue) {
        this.incomeValue = incomeValue;
        view.showRecurrenceSpinner();
    }

    @Override
    public void recurrenceSelected(boolean recurrence) {
        view.showCategoriesSpinner(model.getCategories(recurrence));
    }

    @Override
    public void categorySelected(String category) {
        view.showConfirmIncomeButton();
    }

    @Override
    public void saveIncomeButtonClicked() {
        view.showLoadingView();
        model.saveIncome(incomeValue);
        view.dismissLoadingView();
        view.showIncomeSavedView();
    }
}
