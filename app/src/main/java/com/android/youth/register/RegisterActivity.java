package com.android.youth.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.Button;

import com.android.youth.R;
import com.android.youth.base.BaseToolbarActivity;
import com.android.youth.model.User;
import com.android.youth.utils.DatabaseHelper;
import com.android.youth.utils.InputValidation;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseToolbarActivity {

    private final BaseToolbarActivity activity = RegisterActivity.this;

    @BindView(R.id.nestedScrollView)
    NestedScrollView nestedScrollView;

    @BindView(R.id.btnRegistrasi)
    Button btnRegistrasi;

    @BindView(R.id.textInputLayoutUsername)
    TextInputLayout layoutUsername;

    @BindView(R.id.textInputLayoutEmail)
    TextInputLayout layoutEmail;

    @BindView(R.id.textInputLayoutPassword)
    TextInputLayout layoutPassword;

    @BindView(R.id.textInputLayoutConfirmPassword)
    TextInputLayout layoutConfirmPassword;

    @BindView(R.id.textInputLayoutPoin)
    TextInputLayout layoutPoin;

    @BindView(R.id.textInputEditTextUsername)
    TextInputEditText editTextUsername;

    @BindView(R.id.textInputEditTextEmail)
    TextInputEditText editTextEmail;

    @BindView(R.id.textInputEditTextPassword)
    TextInputEditText editTextPassword;

    @BindView(R.id.textInputEditTextConfirmPassword)
    TextInputEditText editTextConfirmPassword;

    @BindView(R.id.textInputEditTextPoin)
    TextInputEditText editTextPoin;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        setToolbar("Registrasi");

        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        user = new User();

        btnRegistrasi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegistrasi:
                postDataToSQLite();
                break;
        }
    }

    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(editTextUsername, layoutUsername, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(editTextEmail, layoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(editTextEmail, layoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(editTextPassword, layoutPassword, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(editTextPassword, editTextConfirmPassword,
                layoutConfirmPassword, getString(R.string.error_password_match))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(editTextPoin, layoutPoin, "Cek Poin Anda")){
            return;
        }

        if (!databaseHelper.checkUser(editTextEmail.getText().toString().trim())) {

            user.setName(editTextUsername.getText().toString().trim());
            user.setEmail(editTextEmail.getText().toString().trim());
            user.setPassword(editTextPassword.getText().toString().trim());
            user.setPoin("0");

            databaseHelper.addUser(user);

            // Snack Bar to show success message that record saved successfully
            Intent accountsIntent = new Intent(activity, TermAndConditionActivity.class);
            emptyInputEditText();
            startActivity(accountsIntent);
            finish();
//            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
//            emptyInputEditText();


        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }
    }

    private void emptyInputEditText() {
        editTextUsername.setText(null);
        editTextEmail.setText(null);
        editTextPassword.setText(null);
        editTextConfirmPassword.setText(null);
        editTextPoin.setText("0");
    }
}
