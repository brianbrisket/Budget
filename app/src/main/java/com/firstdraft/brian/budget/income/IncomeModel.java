package com.firstdraft.brian.budget.income;

import android.content.Context;
import android.widget.Toast;

import com.firstdraft.brian.budget.R;

/**
 * Created by brisket on 2/14/2017.
 */
class IncomeModel implements IncomeContract.Model {

    // TODO: 2/17/2017 set up to pull from resource
    @Override
    public String[] getCategories(String recurrence) {
        if(recurrence=="Recurring") {
            return new String[]{"Primary Occupation", "Part Time Job"};
        }
//        else if(recurrence=="NonRecurring"){
            return new String[]{"Freelance Job", "Reimbursement", "Refund"};
//        }
    }

    // TODO: 2/17/2017 implement actual save to pull from db
    @Override
    public void saveIncome(Float incomeValue) {
    }

}
