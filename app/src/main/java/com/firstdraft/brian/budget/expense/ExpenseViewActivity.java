package com.firstdraft.brian.budget.expense;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
        addExpenseButton = (Button) findViewById(R.id.save_expense_button);

        presenter = new ExpensePresenter();
        presenter.bindView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.bindView(this);
    }

    @Override
    protected void onStop() {
        presenter.unbindView();
        super.onStop();
    }


    // TODO: 2/4/2017 write test to check against different currency locales
    // TODO: 2/4/2017 deselect input field on button click
    // TODO: 2/4/2017 change button text on edittext select
    // TODO: 2/4/2017 make button layout relative above the number pad to give user option to confirm
    @Override
    public void showMonetaryInputField() {
        expenseInputTitle.setVisibility(View.VISIBLE);
        expenseInputField.setVisibility(View.VISIBLE);
        // TODO: 2/4/2017 change name of add expense button to something more relevant
        addExpenseButton.setVisibility(View.VISIBLE);
        // TODO: 2/4/2017 add to strings.xml "saveMonetaryInputFieldTextonButton" or something like that
        addExpenseButton.setText("Confirm Amount");
        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currencySymbol = expenseInputField.getCurrency().getSymbol();
                String expenseValueWithoutSymbol = expenseInputField.getText().toString()
                        .replace(currencySymbol, "");
                presenter.monetaryInputReceived(Float.parseFloat(expenseValueWithoutSymbol));
            }
        });
    }

    // TODO: 2/4/2017 consider putting in a first time ux option to show "Select from below"
    @Override
    public void showRecurrenceField() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_recurrence_values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        recurrenceMenu.setAdapter(adapter);

        recurrenceMenuTitle.setVisibility(View.VISIBLE);
        recurrenceMenu.setVisibility(View.VISIBLE);

        addExpenseButton.setText("Confirm Recurrence");
        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.recurrenceSelected(recurrenceMenu.getSelectedItem().toString());
            }
        });
    }

    @Override
    public void showCategoryMenu(String[] list) {
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoryMenu.setAdapter(adapter);

        categoryMenuTitle.setVisibility(View.VISIBLE);
        categoryMenu.setVisibility(View.VISIBLE);

        addExpenseButton.setText("Confirm Category");
        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.categorySelected(categoryMenu.getSelectedItem().toString());
            }
        });
    }

    @Override
    public void showConfirmExpenseButton() {
        addExpenseButton.setText("Save Expense");
        addExpenseButton.setVisibility(View.VISIBLE);
        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.saveExpenseButtonClicked();
            }
        });
    }

    @Override
    public void showLoadingView() {

    }

    @Override
    public void dismissLoadingView() {

    }

    @Override
    public void showErrorView(String errorMessage) {

    }

    @Override
    public void showExpenseSavedView() {
        Toast.makeText(this, "Expense Saved!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
