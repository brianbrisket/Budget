package com.firstdraft.brian.budget.income;

/**
 * Created by brisket on 2/14/2017.
 */
class Income {
    // TODO: 2/14/2017 implement class
    private Float incomeValue;
    private String recurrence;
    private String category;

    // TODO: 2/17/2017 create static enum for recurrence and consider making a separate class so that expense can access as well
    Income() {}

    Income(Float incomeValue) {
        this.incomeValue = incomeValue;
    }

    public Float getIncomeValue() {
        return incomeValue;
    }
}
