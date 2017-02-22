package com.firstdraft.brian.budget.home;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by brian on 2/8/2017.
 */
class HomeModel implements HomeContract.Model {
    @Override
    public String getMonthAndYear() {
        DateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy", Locale.US);
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Override
    public Float getMonthBalance() {
        return 4000.25f;
    }
}
