package com.firstdraft.brian.budget.expense;

/**
 * Created by brian on 1/31/2017.
 */
class Expense {
    // TODO: 1/31/2017 add static recurrence variable
    private Float expenseValue;
    private String recurrence;
    private String category;

    Expense() {}

    Expense(Float expenseValue, String recurrence, String category) {
        this.expenseValue = expenseValue;
        this.recurrence = recurrence;
        this.category = category;
    }

    public Float getExpenseValue() {
        return expenseValue;
    }

    public void setExpenseValue(float expenseValue) {
        this.expenseValue = expenseValue;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Expense) {
            Expense that = (Expense) o;
            return (this.expenseValue.compareTo(that.getExpenseValue()) == 0)
                    && (this.recurrence.equals(that.getRecurrence()))
                    && (this.category.equals(that.getCategory()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.expenseValue.hashCode();
        h *= 1000003;
        h ^= this.recurrence.hashCode();
        h *= 1000003;
        h ^= this.category.hashCode();

        return h;
    }
}
