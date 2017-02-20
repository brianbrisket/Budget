package com.firstdraft.brian.budget.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.firstdraft.brian.budget.R;
import com.firstdraft.brian.budget.expense.ExpenseViewActivity;
import com.firstdraft.brian.budget.income.IncomeViewActivity;

public class HomeViewActivity extends AppCompatActivity implements HomeContract.View {

    private HomeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);

        presenter = new HomePresenter();
        presenter.bindView(this);

        Button addExpenseButton = (Button) findViewById(R.id.home_add_expense_button);
        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeViewActivity.this, ExpenseViewActivity.class));
            }
        });

        Button addIncomeButton = (Button) findViewById(R.id.home_add_income_button);
        addIncomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeViewActivity.this, IncomeViewActivity.class));
            }
        });

        ImageButton reportsButton = (ImageButton) findViewById(R.id.home_reports_image_button);
        reportsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2/14/2017 Create Reports package
            }
        });
    }

    @Override
    public void showMonthAndYear(String date) {

    }

    @Override
    public void showMonthBalance(Float balance) {

    }

    @Override
    public void navigateToAddExpenseView() {

    }

    @Override
    public void navigateToAddIncomeView() {

    }

    @Override
    public void navigateToReportsView() {

    }
}
