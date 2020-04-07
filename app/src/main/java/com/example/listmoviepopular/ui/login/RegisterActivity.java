package com.example.listmoviepopular.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.listmoviepopular.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        String[] GENEROS = getResources().getStringArray(R.array.lista_de_generos);

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, GENEROS);
        MaterialBetterSpinner textView = findViewById(R.id.spinner_id);
        textView.setAdapter(adapterSpinner);
    }
}
