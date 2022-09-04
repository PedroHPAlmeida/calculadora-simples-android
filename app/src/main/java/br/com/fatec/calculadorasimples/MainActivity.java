package br.com.fatec.calculadorasimples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

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

        vincularComponentes();
        calcular(buttonSoma, "+");
        calcular(buttonSubtracao, "-");
        calcular(buttonMultiplicacao, "*");
        calcular(buttonDivisao, "/");
    }

    private void vincularComponentes() {
        // associa objetos java ao componente xml
        this.buttonSoma = findViewById(R.id.buttonSoma);
        this.buttonSubtracao = findViewById(R.id.buttonSubtracao);
        this.buttonMultiplicacao = findViewById(R.id.buttonMultiplicacao);
        this.buttonDivisao = findViewById(R.id.buttonDivisao);
        this.editTextValor1 = findViewById(R.id.editTextValor1);
        this.editTextValor2 = findViewById((R.id.editTextValor2));
    }

    private void calcular(Button button, String op){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editText1 = editTextValor1.getText().toString();
                String editText2 = editTextValor2.getText().toString();
                System.out.println(editText1 + " ---------- " + editText2);
                if(editText1.isEmpty() || editText2.isEmpty()){
                    Toast.makeText(MainActivity.this, "Erro: digite os dois valores", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(editText1.equals(".") || editText2.equals(".")){
                    Toast.makeText(MainActivity.this, "Erro: digite valores válidos", Toast.LENGTH_SHORT).show();
                    return;
                }
                double v1 = Double.parseDouble(editText1);
                double v2 = Double.parseDouble(editText2);
                double result = 0;

                switch (op){
                    case "+":
                        result = v1 + v2; break;
                    case "-":
                        result = v1 - v2; break;
                    case "*":
                        result = v1 * v2; break;
                    case "/":
                        if(v2 != 0){
                            result = v1 / v2;
                        } else {
                            Toast.makeText(MainActivity.this, "Erro: divisão por ZERO", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        break;
                    default:
                        throw new RuntimeException("Operação Inválida");
                }
                Toast.makeText(MainActivity.this, "Resultado: " + result, Toast.LENGTH_LONG).show();
            }
        });

    }
}