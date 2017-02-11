package com.firstdraft.brian.budget.home;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by brian on 2/6/2017.
 */
public class HomePresenterTest {
    @Mock
    private HomeContract.Model model;
    @Mock
    private HomeContract.View view;

    private HomeContract.Presenter presenter;

    private String date;
    private Float balance;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        presenter = new HomePresenter(model);

        date = "February 2017";
        when(model.getMonthAndYear()).thenReturn(date);

        balance = 4000.25f;
        when(model.getMonthBalance()).thenReturn(balance);
    }

    @After
    public void tearDown() throws Exception {
        presenter.unbindView();
        model = null;
        presenter = null;
    }

    @Test
    public void shouldNavigateToExpenseView_givenAddExpenseButtonClicked() {
        presenter.bindView(view);
        verify(model).getMonthAndYear();
        verify(view).showDate(date);
        verify(model).getMonthBalance();
        verify(view).showMonthBalance(balance);

        presenter.addExpenseButtonClicked();
        verify(view).navigateToAddExpenseView();
    }

    @Test
    public void shouldNavigateToIncomeView_givenAddIncomeButtonClicked() {
        presenter.bindView(view);
        verify(model).getMonthAndYear();
        verify(view).showDate(date);
        verify(model).getMonthBalance();
        verify(view).showMonthBalance(balance);

        presenter.addIncomeButtonClicked();
        verify(view).navigateToAddIncomeView();
    }

    @Test
    public void shouldNavigateToReportsView_givenReportsButtonClicked() {
        presenter.bindView(view);
        verify(model).getMonthAndYear();
        verify(view).showDate(date);
        verify(model).getMonthBalance();
        verify(view).showMonthBalance(balance);

        presenter.reportsButtonClicked();
        verify(view).navigateToReportsView();
    }
}