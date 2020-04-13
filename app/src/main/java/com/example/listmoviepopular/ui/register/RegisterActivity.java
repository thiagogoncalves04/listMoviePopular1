package com.example.listmoviepopular.ui.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.listmoviepopular.R;
import com.example.listmoviepopular.ui.moviesList.ListMovieActivity;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {
    private TextInputEditText edtName, edtEmail, edtPassword, edtPassword2;
    private Button btnRegister;
    private MaterialDialog dialog;
    private RegisterContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        showToolbar("Registro", true);
        setViews();

//        String[] GENEROS = getResources().getStringArray(R.array.lista_de_generos);
//
//        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this,
//                android.R.layout.simple_dropdown_item_1line, GENEROS);
//        MaterialBetterSpinner textView = findViewById(R.id.spinner_id);
//        textView.setAdapter(adapterSpinner);
    }

    public void setViews() {
        presenter = new RegisterPresenter(this);

        edtName = findViewById(R.id.edit_text_name_id);
        edtEmail = findViewById(R.id.edit_text_email_register_id);
        edtPassword = findViewById(R.id.user_password_id);
        edtPassword2 = findViewById(R.id.confirm_user_password_id);
        btnRegister = findViewById(R.id.btn_register_save);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRegister();
            }
        });
        MaterialDialog.Builder builder = new MaterialDialog.Builder(this)
                .title("Carregand")
                .content("Espere, por favor...")
                .progress(true, 0);
        dialog = builder.build();
    }

    public void showToolbar(String register, boolean b) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(register);
            getSupportActionBar().setDisplayHomeAsUpEnabled(b);
        }
    }

    @Override
    public void disableInputs() {
        setEnable(false);
    }

    private void setEnable(boolean b) {
        edtPassword.setEnabled(b);
        edtPassword2.setEnabled(b);
        edtName.setEnabled(b);
        edtEmail.setEnabled(b);
    }

    @Override
    public void enableInputs() {
        setEnable(true);
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
    public void handleRegister() {
        if (validateViews()) {
         presenter.doRegister(edtName.getText().toString(), edtEmail.getText().toString().trim(), edtPassword.getText().toString().trim());
        }
    }

    @Override
    public boolean validateViews() {
        boolean retVal = true;
        if (TextUtils.isEmpty(edtName.getText() != null ? edtName.getText():"")) {
            edtName.setError("Este campoé obrigatório");
            retVal = false;
        } else if (edtName.getText().toString().length() < 5) {
            edtName.setError("Deve conter pelo menos 6 caracteres.");
        }
        if (TextUtils.isEmpty(edtEmail.getText())) {
            edtEmail.setError("Este campo é obrigatório");
            retVal = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString().trim()).matches()) {
            edtEmail.setError("Não é um email válido");
            retVal = false;
        }
        if (TextUtils.isEmpty((edtPassword.getText()))) {
            edtPassword.setError("Este campo é obrigatório");
            retVal = false;
        } else if (edtPassword.getText().toString().length() < 6) {
            edtPassword.setError("Password deve conter ao menos 4 caracter!");
        retVal = false;
        }
        if (TextUtils.isEmpty((edtPassword.getText()))) {
            edtPassword.setError("Este campo é obrigatório");
            retVal = false;
        } else if (!edtPassword.getText().toString().trim().equals(edtPassword2.getText().toString().trim())) {
            retVal = false;
            edtPassword2.setError("As senhas não coincidem");
        }
        return retVal;
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, "Deu pior", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLogin() {
        Intent intent = new Intent(this, ListMovieActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}