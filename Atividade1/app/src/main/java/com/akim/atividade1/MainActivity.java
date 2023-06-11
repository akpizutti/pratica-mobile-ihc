package com.akim.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myTextView = findViewById(R.id.resultado);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toastBotao();
                somar(v);
                myTextView.setText("Resultado: " + String.valueOf(result));
            }
        });

    }

    private void toastBotao()
    {
        Toast.makeText(this, "botao", Toast.LENGTH_SHORT).show();
    }

    private void somar(View view)
    {
        EditText et1 = (EditText) findViewById(R.id.texto1); // ID from component
        EditText et2 = (EditText) findViewById(R.id.texto2); // ID from component
        result = Integer.parseInt(et1.getText().toString()) + Integer.parseInt(et2.getText().toString());
    }
}