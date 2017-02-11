package com.firstdraft.brian.budget.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.firstdraft.brian.budget.R;
import com.firstdraft.brian.budget.expense.ExpenseViewActivity;

public class HomeViewActivity extends AppCompatActivity {
    private Button addExpenseButton;
    private Button addIncomeButton;
    private ImageButton reportsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);

        addExpenseButton = (Button) findViewById(R.id.home_add_expense_button);
        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ExpenseViewActivity.class));

                //addIncomeButton = (Button) findViewById(R.id.home_add_income_button);
                //startActivity(new Intent(getBaseContext(), IncomeViewActivity.class));
            }
        });
    }
}
