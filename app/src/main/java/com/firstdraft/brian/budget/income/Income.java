package com.firstdraft.brian.budget.income;

/**
 * Created by brisket on 2/14/2017.
 */
public class Income {
    // TODO: 2/14/2017 implement class
    private Float incomeValue;

    // TODO: 2/17/2017 create static enum for recurrence and consider making a separate class so that expense can access as well
    Income() {}

    Income(Float incomeValue) {
        this.incomeValue = incomeValue;
    }

    public Float getIncomeValue() {
        return incomeValue;
    }
}
