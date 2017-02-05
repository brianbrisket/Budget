package com.firstdraft.brian.budget.expense;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by brian on 1/31/2017.
 */
public class ExpensePresenterTest {
    @Mock private ExpenseContract.Model model;
    @Mock private ExpenseContract.View view;

    private ExpenseContract.Presenter presenter;

    private String[] recurringCat, nonrecurringCat;
    private float expenseValue;
    private String recurring, nonrecurring, category;
    private Expense expense, nonRecExpense;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        presenter = new ExpensePresenter(model);
        presenter.bindView(view);

        nonrecurringCat = new String[]{"Groceries", "Gas", "Clothing"};
        recurringCat = new String[]{"Rent", "Renter's Insurance", "Car Insurance",
                "Cell Phone", "Car Payments"};

        when(model.getNonRecurringCategories())
                .thenReturn(nonrecurringCat);
        when(model.getRecurringCategories())
                .thenReturn(recurringCat);

        expenseValue = 0.99f;
        nonrecurring = "NonRecurring";
        recurring = "Recurring";
        category = nonrecurringCat[1];
        expense = new Expense(expenseValue, recurring, category);
        nonRecExpense = new Expense(expenseValue, nonrecurring, category);
        // TODO: 1/31/2017 create nonrecurring category for non rec expense object
    }

    @After
    public void tearDown() throws Exception {
        presenter.unbindView();
        model = null;
        presenter = null;
        // TODO: 1/31/2017 null all instantiated variables
    }

    // TODO: 2/5/2017 consider refactoring tests, maybe split up to avoid redundancy
    // TODO: 2/5/2017 add test for error conditions
    @Test
    public void shouldSaveExpense_givenNonRecurrence() {
        verify(view).showMonetaryInputField();

        presenter.monetaryInputReceived(expenseValue);
        verify(view).showRecurrenceField();

        presenter.recurrenceSelected(nonrecurring);
        verify(model).getNonRecurringCategories();
        verify(view).showCategoryMenu(nonrecurringCat);

        presenter.categorySelected(category);
        verify(view).showConfirmExpenseButton();

        presenter.expenseButtonClicked();
        verify(model).saveExpense(nonRecExpense);
        verify(view).showLoadingView();
        verify(view).dismissLoadingView();
        verify(view).showExpenseSavedView();
    }

    @Test
    public void shouldSaveExpense_givenRecurrence() {
        verify(view).showMonetaryInputField();

        presenter.monetaryInputReceived(expenseValue);
        verify(view).showRecurrenceField();

        presenter.recurrenceSelected(recurring);
        verify(model).getRecurringCategories();
        verify(view).showCategoryMenu(recurringCat);

        presenter.categorySelected(category);
        verify(view).showConfirmExpenseButton();

        presenter.expenseButtonClicked();
        verify(model).saveExpense(expense);
        verify(view).showLoadingView();
        verify(view).dismissLoadingView();
        verify(view).showExpenseSavedView();
    }

}