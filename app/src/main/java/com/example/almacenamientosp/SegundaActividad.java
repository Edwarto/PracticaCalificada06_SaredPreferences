package com.example.almacenamientosp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class SegundaActividad extends AppCompatActivity {



    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    private static final String TAG = "SegundaActividad";
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private TextView mName;

    private int ValorTexto;
    private Button btnAumentar, btnPredeterminador, btnDisminuir;




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);
        mName = (TextView) findViewById(R.id.etNombre_SP);
        btnAumentar = (Button) findViewById(R.id.btnaumentar);
        btnPredeterminador = (Button) findViewById(R.id.btnpredeterminado);
        btnDisminuir = (Button) findViewById(R.id.btndisminuir);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        checkSharedPreferences();

        SharedPreferences mPreferences =
                PreferenceManager.
                        getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor =
                mPreferences.edit();

        String name =
                mPreferences.getString
                        (getString(R.string.name), "");
        mName.setText("Bienvenido/a, " + name);


        btnAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ValorTexto == 0) {
                    ValorTexto = 20;
                    mEditor.putInt(getString(R.string.size), ValorTexto);
                    mEditor.commit();
                }
                if (ValorTexto < 30) {
                    ValorTexto = ValorTexto + 1;
                    mName.setTextSize(ValorTexto);
                    mEditor.putInt(getString(R.string.size), ValorTexto);
                    mEditor.commit();
                }
            }
        });

        btnPredeterminador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValorTexto = 20;
                mName.setTextSize(ValorTexto);
                mEditor.putInt(getString(R.string.size), ValorTexto);
                mEditor.commit();
            }
        });

        btnDisminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ValorTexto == 0) {
                    ValorTexto = 20;
                    mEditor.putInt(getString(R.string.size), ValorTexto);
                    mEditor.commit();
                }
                if (ValorTexto > 10) {
                    ValorTexto = ValorTexto - 1;
                    mName.setTextSize(ValorTexto);
                    mEditor.putInt(getString(R.string.size), ValorTexto);
                    mEditor.commit();
                }
            }
        });
    }

    private void checkSharedPreferences(){
        int size = mPreferences.getInt(getString(R.string.size), 20);
        mName.setTextSize(size);

    }

}

