package com.firstdraft.brian.budget.expense;

/**
 * Created by brian on 1/31/2017.
 */
class ExpensePresenter implements ExpenseContract.Presenter {
    private float expenseValue;
    // TODO: 2/1/2017 change recurreneType to bool
    private String recurrenceType;
    private String category;

    private ExpenseContract.View view;
    private ExpenseContract.Model model;

    ExpensePresenter() {
        this(new ExpenseModel());
    }

    ExpensePresenter(ExpenseContract.Model model) {
        this.model = model;
    }

    @Override
    public void bindView(ExpenseContract.View view) {
        this.view = view;
        view.showMonetaryInputField();
    }

    @Override
    public void unbindView() {
        view = null;
    }

    @Override
    public void monetaryInputReceived(Float expenseValue) {
        this.expenseValue = expenseValue;
        view.showRecurrenceField();
    }

    @Override
    public void recurrenceSelected(String recurrenceType) {
        String[] categories;
        this.recurrenceType = recurrenceType;

        if (recurrenceType.equals("NonRecurring")){
            categories = model.getNonRecurringCategories();
        } else {
            categories = model.getRecurringCategories();
        }
        view.showCategoryMenu(categories);
    }

    @Override
    public void categorySelected(String category) {
        this.category = category;
        view.showConfirmExpenseButton();
    }

    @Override
    public void expenseButtonClicked() {
        model.saveExpense(new Expense(expenseValue, recurrenceType, category));
    }
}
