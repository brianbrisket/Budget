package com.firstdraft.brian.budget.income;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by brian on 2/8/2017.
 */
public class IncomePresenterTest {
    @Mock
    private IncomeContract.Model model;
    @Mock
    private IncomeContract.View view;

    private IncomeContract.Presenter presenter;

    private Float incomeValue;
    private boolean recurrence;
    private String[] nonRecurringCategories;
    private String nonRecurringCat;
    private String[] recurringCategories;
    private String recurringCat;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        presenter = new IncomePresenter(model);

        incomeValue = 2000f;

        nonRecurringCategories = new String[]{"FreelanceJob", "Reimbursement", "Other"};
        when(model.getCategories(recurrence = false)).thenReturn(nonRecurringCategories);
        nonRecurringCat = nonRecurringCategories[0];

        recurringCategories = new String[]{"DayJob", "PartTimeJob", "Other"};
        when(model.getCategories(recurrence = true)).thenReturn(recurringCategories);
        recurringCat = recurringCategories[0];
    }

    @After
    public void tearDown() throws Exception {
        presenter.unbindView();
        model = null;
        view = null;
        incomeValue = null;
        nonRecurringCategories = null;
        nonRecurringCat = null;
        recurringCategories = null;
        recurringCat = null;
    }

    @Test
    public void shouldShowNonRecurringCategories_givenFalseRecurrence() {
        presenter.bindView(view);
        verify(view).showMonetaryInputField();

        presenter.monetaryInputReceived(incomeValue);
        verify(view).showRecurrenceSpinner();

        presenter.recurrenceSelected(recurrence = false);
        verify(model).getCategories(recurrence);
        verify(view).showCategoriesSpinner(nonRecurringCategories);

        presenter.categorySelected(nonRecurringCat);
        verify(view).showConfirmIncomeButton();

        presenter.saveIncomeButtonClicked();
        verify(view).showLoadingView();
        verify(view).dismissLoadingView();
        verify(view).showIncomeSavedView();
    }

    @Test
    public void shouldShowRecurringCategories_givenTrueRecurrence() {
        presenter.bindView(view);
        verify(view).showMonetaryInputField();

        presenter.monetaryInputReceived(incomeValue);
        verify(view).showRecurrenceSpinner();

        presenter.recurrenceSelected(recurrence = true);
        verify(model).getCategories(recurrence);
        verify(view).showCategoriesSpinner(recurringCategories);

        presenter.categorySelected(recurringCat);
        verify(view).showConfirmIncomeButton();

        presenter.saveIncomeButtonClicked();
        verify(view).showLoadingView();
        verify(view).dismissLoadingView();
        verify(view).showIncomeSavedView();
    }
}