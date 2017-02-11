package com.firstdraft.brian.budget.income;

import com.firstdraft.brian.budget.home.HomeContract;

import org.junit.After;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by brian on 2/8/2017.
 */
public class IncomePresenterTest {
    @Mock
    private HomeContract.Model model;
    @Mock
    private HomeContract.View view;

    private HomeContract.Presenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);


    }

    @After
    public void tearDown() throws Exception {

    }

}