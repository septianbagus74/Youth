package com.android.youth.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.Button;

import com.android.youth.R;
import com.android.youth.activity.MenuActivity;
import com.android.youth.base.BaseToolbarActivity;
import com.android.youth.utils.DatabaseHelper;
import com.android.youth.utils.InputValidation;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseToolbarActivity {
    private final BaseToolbarActivity activity = LoginActivity.this;

    @BindView(R.id.nestedScrollView)
    NestedScrollView nestedScrollView;

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.textInputLayoutEmail)
    TextInputLayout layoutEmail;

    @BindView(R.id.textInputLayoutPassword)
    TextInputLayout layoutPassword;

    @BindView(R.id.textInputEditTextEmail)
    TextInputEditText editTextEmail;

    @BindView(R.id.textInputEditTextPassword)
    TextInputEditText editTextPassword;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);

        setToolbar("Login");

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                verifyFromSQLite();
                break;
        }
    }

    private void verifyFromSQLite() {
        if (!inputValidation.isInputEditTextFilled(editTextEmail, layoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(editTextEmail, layoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(editTextPassword, layoutPassword, getString(R.string.error_message_email))) {
            return;
        }

        if (databaseHelper.checkUser(editTextEmail.getText().toString().trim()
                , editTextPassword.getText().toString().trim())) {


            Intent accountsIntent = new Intent(activity, MenuActivity.class);
            accountsIntent.putExtra("EMAIL", editTextEmail.getText().toString().trim());
            emptyInputEditText();
            startActivity(accountsIntent);
            finish();


        } else {
            // Snack Bar to show success message that record is wrong
            Snackbar.make(nestedScrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
        }
    }

    private void emptyInputEditText() {
        editTextEmail.setText(null);
        editTextPassword.setText(null);
    }
}
