package com.firstdraft.brian.budget.expense;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.blackcat.currencyedittext.CurrencyEditText;
import com.firstdraft.brian.budget.R;

public class ExpenseViewActivity extends AppCompatActivity implements ExpenseContract.View {

    private ExpenseContract.Presenter presenter;

    private TextView expenseInputTitle;
    private CurrencyEditText expenseInputField;
    private TextView recurrenceMenuTitle;
    private Spinner recurrenceMenu;
    private TextView categoryMenuTitle;
    private Spinner categoryMenu;
    private Button addExpenseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_view);

        expenseInputTitle = (TextView) findViewById(R.id.add_expense_title);
        expenseInputField = (CurrencyEditText) findViewById(R.id.expense_input_field);
        recurrenceMenuTitle = (TextView) findViewById(R.id.recurrence_menu_title);
        recurrenceMenu = (Spinner) findViewById(R.id.recurrence_menu);
        categoryMenuTitle = (TextView) findViewById(R.id.category_menu_title);
        categoryMenu = (Spinner) findViewById(R.id.category_menu);
        addExpenseButton = (Button) findViewById(R.id.add_expense_button);

        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(), expenseInputField.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        presenter = new ExpensePresenter();
        presenter.bindView(this);
    }

    // TODO: 2/2/2017 create presenter in the oncreate method and do the bind view and implement the flow
    @Override
    public void showMonetaryInputField() {
        expenseInputTitle.setVisibility(View.VISIBLE);
        expenseInputField.setVisibility(View.VISIBLE);
    }

    @Override
    public void showRecurrenceField() {
        recurrenceMenuTitle.setVisibility(View.VISIBLE);
        recurrenceMenu.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCategoryMenu(String[] list) {
        categoryMenuTitle.setVisibility(View.VISIBLE);
        categoryMenu.setVisibility(View.VISIBLE);

    }

    @Override
    public void showConfirmExpenseButton() {
        addExpenseButton.setVisibility(View.VISIBLE);
    }
}
