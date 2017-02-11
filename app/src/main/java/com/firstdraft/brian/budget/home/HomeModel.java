package com.firstdraft.brian.budget.home;

/**
 * Created by brian on 2/8/2017.
 */
public class HomeModel implements HomeContract.Model {
    @Override
    public String getMonthAndYear() {
        return "February 2017";
    }

    @Override
    public Float getMonthBalance() {
        return 4000.25f;
    }
}
