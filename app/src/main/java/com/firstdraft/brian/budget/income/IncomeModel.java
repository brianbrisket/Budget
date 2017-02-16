package com.firstdraft.brian.budget.income;

import android.content.Context;

import com.firstdraft.brian.budget.R;

/**
 * Created by brisket on 2/14/2017.
 */
public class IncomeModel implements IncomeContract.Model {


    @Override
    public String[] getCategories(boolean recurrence) {
        return new String[0];
    }

    @Override
    public void saveIncome(Float incomeValue) {

    }

}
