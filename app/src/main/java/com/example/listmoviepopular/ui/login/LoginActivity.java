package com.example.listmoviepopular.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.afollestad.materialdialogs.MaterialDialog;
import com.example.listmoviepopular.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity implements LoginInterface.View {

    private TextInputEditText edtEmail, edtPassword;
    private Button btnLogin;
    private MaterialDialog dialog;
    private LoginInterface.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setViews();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });
    }

    private void setViews() {
        presenter = new LoginPresenter(this);

        edtEmail = findViewById(R.id.edit_text_email_id);
        edtPassword = findViewById(R.id.edit_text_password_id);
        btnLogin = findViewById(R.id.button_login);

        MaterialDialog.Builder builder = new MaterialDialog.Builder(this)
                .title("Carregando")
                .content("Espere, por favor.")
                .cancelable(false)
                .progress(true, 0);
        dialog = builder.build();

    }

    private void setInputs(boolean enable) {
        edtEmail.setEnabled(enable);
        edtPassword.setEnabled(enable);
        btnLogin.setEnabled(enable);
    }

    @Override
    public void disableInputs() {
        setInputs(false);

    }

    @Override
    public void enableInputs() {
        setInputs(true);

    }

    @Override
    public void showProgress() {
        dialog.show();
    }

    @Override
    public void hidePrgress() {
        dialog.dismiss();

    }

    @Override
    public void handleLogin() {
        if (!isValidEmail()) {
            Toast.makeText(this, "Imvalid e-mail", Toast.LENGTH_SHORT).show();
        } else if (!isValidPassword()) {
            Toast.makeText(this, "Imvalid password", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean isValidEmail() {
        return Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString()).matches();
    }

    @Override
    public boolean isValidPassword() {
        if (TextUtils.isEmpty(edtPassword.getText().toString()) &&
                edtPassword.getText().toString().length() < 4) {
            Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
            edtPassword.setError("Password incorret");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onLogin() {
        Toast.makeText(this, "You have successfully logged on", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }
}