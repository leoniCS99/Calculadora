package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero,numeroUm,numeroDois,numeroTres,numeroQuatro,numeroCinco,numeroSeis,numeroSete,numeroOito,numeroNove,ponto,
    soma,subtracao,multiplicao,divisao,igual,botao_limpar;

    private TextView txtExpressao,txtResultado;
    private ImageView backspace;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IniciarComponenetes();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        divisao.setOnClickListener(this);
        multiplicao.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        igual.setOnClickListener(this);
        botao_limpar.setOnClickListener(this);


        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1;

                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {



                    Expression expression = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expression.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double)longResult){
                        txtResultado.setText((CharSequence)String.valueOf(longResult));
                    }else{
                        txtResultado.setText((CharSequence)String.valueOf(resultado));
                    }


                }catch (Exception e){

                }


            }
        });


    }



    private void IniciarComponenetes(){
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_treis);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numeroNove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.ponto);
        igual = findViewById(R.id.igual);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backSpace);
        subtracao = findViewById(R.id.Subritacao);
        multiplicao = findViewById(R.id.Multiplicacao);
        divisao = findViewById(R.id.divisao);
        soma = findViewById(R.id.soma);
        botao_limpar = findViewById(R.id.bt_limpar);
    }

    public void AcrescentaUmaExpressao(String string ,boolean limparDados){
        if (txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }


        if (limparDados){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }else{
           txtExpressao.append(txtResultado.getText());
           txtExpressao.append(string);
           txtResultado.setText(" ");
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.numero_zero:
                AcrescentaUmaExpressao("0",true);
                break;

                case R.id.numero_um:
                AcrescentaUmaExpressao("1",true);
                    break;

            case R.id.numero_dois:
                AcrescentaUmaExpressao("2",true);
                break;

            case R.id.numero_treis:
            AcrescentaUmaExpressao("3",true);
                break;

            case R.id.numero_quatro:
                AcrescentaUmaExpressao("4",true);
                break;

            case R.id.numero_cinco:
                AcrescentaUmaExpressao("5",true);
                break;

            case R.id.numero_seis:
                AcrescentaUmaExpressao("6",true);
                break;

            case R.id.numero_sete:
                AcrescentaUmaExpressao("7",true);
                break;

            case R.id.numero_oito:
                AcrescentaUmaExpressao("8",true);
                break;

            case R.id.numero_nove:
                AcrescentaUmaExpressao("9",true);
                break;

            case R.id.ponto:
                AcrescentaUmaExpressao(".",true);
                break;

            case R.id.soma:
                AcrescentaUmaExpressao("+",false);
                break;

            case R.id.Subritacao:
                AcrescentaUmaExpressao("-",false);
                break;

            case R.id.Multiplicacao:
                AcrescentaUmaExpressao("*",false);
                break;

            case R.id.divisao:
                AcrescentaUmaExpressao("/",false);
                break;


            case R.id.igual:
                AcrescentaUmaExpressao("=",false);
                break;



/* CRÉDITOS AO PROJETO
=========================
LEONI CESAR
ENGENHEIRO DE SOFTWARE
=========================
 */

















        }
    }
}