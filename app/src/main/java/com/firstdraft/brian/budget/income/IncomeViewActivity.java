package com.firstdraft.brian.budget.income;

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

/**
 * Created by brisket on 2/13/2017.
 */
public class IncomeViewActivity extends AppCompatActivity implements IncomeContract.View {

    private IncomeContract.Presenter presenter;

    private TextView incomeInputTitle;
    private CurrencyEditText currencyInputField;
    private TextView recurrenceMenuTitle;
    private Spinner recurrenceMenuSpinner;
    private TextView categoryMenuTitle;
    private Spinner categoryMenuSpinner;
    private Button incomeDoneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_view);

        incomeInputTitle = (TextView) findViewById(R.id.add_income_title);
        currencyInputField = (CurrencyEditText) findViewById(R.id.income_input_field);
        recurrenceMenuTitle = (TextView) findViewById(R.id.recurrence_menu_title);
        recurrenceMenuSpinner = (Spinner) findViewById(R.id.recurrence_menu);
        categoryMenuTitle = (TextView) findViewById(R.id.category_menu_title);
        categoryMenuSpinner = (Spinner) findViewById(R.id.category_menu);
        incomeDoneButton = (Button) findViewById(R.id.save_income_button);

        presenter = new IncomePresenter();
        presenter.bindView(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.bindView(this);
    }

    @Override
    public void onStop() {
        presenter.unbindView();
        super.onStop();
    }

    @Override
    public void showMonetaryInputField() {
        incomeInputTitle.setVisibility(View.VISIBLE);
        currencyInputField.setVisibility(View.VISIBLE);
        incomeDoneButton.setVisibility(View.VISIBLE);

        incomeDoneButton.setText(R.string.confirm_amount_button);
        incomeDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currencySymbol = currencyInputField.getCurrency().getSymbol();
                String incomeValueWithoutSymbol = currencyInputField.getText().toString()
                        .replace(currencySymbol, "");

                presenter.monetaryInputReceived(Float.parseFloat(incomeValueWithoutSymbol));
            }
        });
    }

    @Override
    public void showRecurrenceSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_recurrence_values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        recurrenceMenuSpinner.setAdapter(adapter);

        recurrenceMenuTitle.setVisibility(View.VISIBLE);
        recurrenceMenuSpinner.setVisibility(View.VISIBLE);

        incomeDoneButton.setText(R.string.confirm_recurrence_button);
        incomeDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.recurrenceSelected(recurrenceMenuSpinner.getSelectedItem().toString());
            }
            // TODO: 2/14/2017 create enum for recurrence - nonrecurrence 0, recurrence 1
        });

    }

    @Override
    public void showCategoriesSpinner(String[] list) {
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoryMenuSpinner.setAdapter(adapter);

        categoryMenuTitle.setVisibility(View.VISIBLE);
        categoryMenuSpinner.setVisibility(View.VISIBLE);

        presenter.categorySelected(categoryMenuSpinner.getSelectedItem().toString());
    }

    @Override
    public void showConfirmIncomeButton() {
        incomeDoneButton.setText(R.string.save_income_button);
        incomeDoneButton.setVisibility(View.VISIBLE);
        incomeDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.saveIncomeButtonClicked();
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
    public void showIncomeSavedView() {
        Toast.makeText(this, "Income Saved!!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
