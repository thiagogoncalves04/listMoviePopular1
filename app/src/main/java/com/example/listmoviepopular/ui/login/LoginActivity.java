package com.example.listmoviepopular.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.listmoviepopular.R;
import com.example.listmoviepopular.ui.moviesList.ListMovieActivity;
import com.example.listmoviepopular.ui.register.RegisterActivity;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity implements LoginInterface.View {

    private TextInputEditText edtEmail;
    private TextInputEditText edtPassword;
    private TextView goRegister;
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
        goRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goRegister();
            }
        });
    }

    private void setViews() {
        presenter = new LoginPresenter(this);

        edtEmail = findViewById(R.id.edit_text_email_id);
        edtPassword = findViewById(R.id.edit_text_password_id);
        btnLogin = findViewById(R.id.button_login);
        goRegister = findViewById(R.id.text_register);

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
            edtPassword.setError("Email incorret");
        } else if (!isValidPassword()) {
            edtPassword.setError("Password incorret");
        } else{
            presenter.toLogin(edtEmail.getText().toString().trim(), edtPassword.getText().toString().trim());
        }
    }

    @Override
    public boolean isValidEmail() {
        return Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString()).matches();
    }

    @Override
    public boolean isValidPassword() {
        if (TextUtils.isEmpty(edtPassword.getText().toString()) ||
                edtPassword.getText().toString().length() < 4) {
            Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onLogin() {
        Intent intent = new Intent(this, ListMovieActivity.class);
        startActivity(intent);
    }

    @Override
    public void goRegister() {
        startActivity( new Intent(this, RegisterActivity.class));
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, "User not found or password incorrect!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        presenter.onDestroy();
    }
}