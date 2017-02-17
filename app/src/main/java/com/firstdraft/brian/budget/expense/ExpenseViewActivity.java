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
    private Spinner recurrenceMenuSpinner;
    private TextView categoryMenuTitle;
    private Spinner categoryMenu;
    private Button expenseDoneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_view);

        expenseInputTitle = (TextView) findViewById(R.id.add_expense_title);
        expenseInputField = (CurrencyEditText) findViewById(R.id.expense_input_field);
        recurrenceMenuTitle = (TextView) findViewById(R.id.recurrence_menu_title);
        recurrenceMenuSpinner = (Spinner) findViewById(R.id.recurrence_menu);
        categoryMenuTitle = (TextView) findViewById(R.id.category_menu_title);
        categoryMenu = (Spinner) findViewById(R.id.category_menu);
        expenseDoneButton = (Button) findViewById(R.id.save_expense_button);

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
        expenseDoneButton.setVisibility(View.VISIBLE);
        expenseDoneButton.setText(R.string.confirm_amount_button);
        expenseDoneButton.setOnClickListener(new View.OnClickListener() {
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
        recurrenceMenuSpinner.setAdapter(adapter);

        recurrenceMenuTitle.setVisibility(View.VISIBLE);
        recurrenceMenuSpinner.setVisibility(View.VISIBLE);

        expenseDoneButton.setText(R.string.confirm_recurrence_button);
        expenseDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.recurrenceSelected(recurrenceMenuSpinner.getSelectedItem().toString());
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

        expenseDoneButton.setText(R.string.confirm_category_button);
        expenseDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.categorySelected(categoryMenu.getSelectedItem().toString());
            }
        });
    }

    @Override
    public void showConfirmExpenseButton() {
        expenseDoneButton.setText(R.string.save_expense_button);
        expenseDoneButton.setVisibility(View.VISIBLE);
        expenseDoneButton.setOnClickListener(new View.OnClickListener() {
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

    // TODO: 2/17/2017 actually implement the save to some db
    @Override
    public void showExpenseSavedView() {
        Toast.makeText(this, "Expense Saved!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
