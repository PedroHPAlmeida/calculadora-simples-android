package br.com.fatec.calculadorasimples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonSoma;
    private Button buttonSubtracao;
    private Button buttonMultiplicacao;
    private Button buttonDivisao;
    private EditText editTextValor1;
    private EditText editTextValor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // associa objetos java ao componente xml
        buttonSoma = findViewById(R.id.buttonSoma);
        buttonSubtracao = findViewById(R.id.buttonSubtracao);
        buttonMultiplicacao = findViewById(R.id.buttonMultiplicacao);
        buttonDivisao = findViewById(R.id.buttonDivisao);
        editTextValor1 = findViewById(R.id.editTextValor1);
        editTextValor2 = findViewById((R.id.editTextValor2));

        // gerando evento click do botão soma
        buttonSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double v1 = Double.parseDouble(editTextValor1.getText().toString());
                double v2 = Double.parseDouble(editTextValor2.getText().toString());
                double soma = v1 + v2;
                Toast.makeText(MainActivity.this, "Soma: " + soma, Toast.LENGTH_LONG).show();
            }
        });

        // gerando evento click do botão subtração
        buttonSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double v1 = Double.parseDouble(editTextValor1.getText().toString());
                double v2 = Double.parseDouble(editTextValor2.getText().toString());
                double subtracao = v1 - v2;
                Toast.makeText(MainActivity.this, "Subtração: " + subtracao, Toast.LENGTH_LONG).show();
            }
        });

        // gerando evento click do botão multiplicação
        buttonMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double v1 = Double.parseDouble(editTextValor1.getText().toString());
                double v2 = Double.parseDouble(editTextValor2.getText().toString());
                double multiplicacao = v1 * v2;
                Toast.makeText(MainActivity.this, "Multiplicação: " + multiplicacao, Toast.LENGTH_LONG).show();
            }
        });

        // gerando evento click do botão divisão
        buttonDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double v1 = Double.parseDouble(editTextValor1.getText().toString());
                double v2 = Double.parseDouble(editTextValor2.getText().toString());

                try {
                    double divisao = v1 / v2;
                    Toast.makeText(MainActivity.this, "Divisão: " + divisao, Toast.LENGTH_LONG).show();
                } catch (ArithmeticException exception) {
                    Toast.makeText(MainActivity.this, "Erro: Impossível dividir por zero!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}