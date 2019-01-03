package com.mariodias.appneon.DashboardActivity;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.widget.Button;


import com.mariodias.appneon.InvestimentosActivity.InvestimentosActivity;
import com.mariodias.appneon.MeuNeon.MeuNeonActivity;
import com.mariodias.appneon.R;


public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn_valor_saldo, btn_valor_investimentos, btn_valor_credito;
    private Button btn_investimentos, btn_saldo;
    private Button btn_AvatarMeuNeon;
    private Intent intent;
    private CardView cardMeuNeon;

    private DashboardViewModel dashboardViewModel;

    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        //Configura cor do Status Bar
        window = getWindow();
        window.setStatusBarColor(Color.rgb(0, 0, 198));

        //Faz a conexao dos componentes com a classe
        inicializaComponentes();


    }


    private void inicializaComponentes() {

        dashboardViewModel = new DashboardViewModel();


        btn_investimentos = findViewById(R.id.btn_investimentos);
        btn_valor_investimentos = findViewById(R.id.btn_invest_valor);
        btn_saldo = findViewById(R.id.btn_saldo);
        btn_valor_saldo = findViewById(R.id.btn_saldo_valor);
        btn_valor_credito = findViewById(R.id.btn_credit_valor);
        cardMeuNeon = findViewById(R.id.cardMeuNeon);
        btn_AvatarMeuNeon = findViewById(R.id.btnAvatarMeuNeon);


        // Inicia o app com o saldo
        btn_valor_saldo.setText(dashboardViewModel.getSaldoConta());
        btn_valor_investimentos.setText(dashboardViewModel.getSaldoInvestimentos());
        btn_valor_credito.setText(dashboardViewModel.getSaldoCredito());


        //Configura o Evento de click
        btn_valor_saldo.setOnClickListener(this);
        btn_valor_investimentos.setOnClickListener(this);
        btn_valor_credito.setOnClickListener(this);

        btn_saldo.setOnClickListener(this);
        btn_investimentos.setOnClickListener(this);

        cardMeuNeon.setOnClickListener(this);
        btn_AvatarMeuNeon.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        // Quando clicado nos valores, eh chamado o metodo para esconder/exibir os valores

        // Quando clicado nos nomes das celulas, eh chamado a activity correspondente
        switch (view.getId()) {
            case R.id.btn_saldo_valor:
                showHideValores();
                break;
            case R.id.btn_invest_valor:
                showHideValores();
                break;
            case R.id.btn_credit_valor:
                showHideValores();
                break;
            case R.id.btn_investimentos:
                callInvestimentosActivity();
                break;
            case R.id.cardMeuNeon:
                callMeuNeonActivity();
                break;
            case R.id.btnAvatarMeuNeon:
                callMeuNeonActivity();
                break;

        }

    }

    private void callInvestimentosActivity() {
        intent = new Intent(this, InvestimentosActivity.class);
        startActivity(intent);
        finish();
    }

    private void callMeuNeonActivity() {
        intent = new Intent(this, MeuNeonActivity.class);
        startActivity(intent);
        finish();
    }


    public void showHideValores() {

        if (dashboardViewModel.showValores(btn_valor_saldo.getText().toString())) {

                /* Quando clicar no visible_off, o saldo da conta e do investimento aparecerao
                   novamente
                 */
            btn_valor_saldo.setText(dashboardViewModel.getSaldoConta());
            btn_valor_investimentos.setText(dashboardViewModel.getSaldoInvestimentos());
            btn_valor_credito.setText(dashboardViewModel.getSaldoInvestimentos());

            btn_valor_saldo.setBackground(null);
            btn_valor_investimentos.setBackground(null);
            btn_valor_credito.setBackground(null);


            //Configura a dimensao padrao do texto quando exibir o valor
            btn_valor_saldo.setScaleX(1f);
            btn_valor_saldo.setScaleY(1f);

            btn_valor_investimentos.setScaleX(1f);
            btn_valor_investimentos.setScaleY(1f);

            btn_valor_credito.setScaleX(1f);
            btn_valor_credito.setScaleY(1f);

        } else {


            //Quando clicar nos valores, estes serao limpos e aparecera o visible_off
            btn_valor_saldo.setText(" ");
            btn_valor_investimentos.setText(" ");
            btn_valor_credito.setText(" ");

            btn_valor_saldo.setBackground(this.getResources().getDrawable(R.drawable.visible_off));
            btn_valor_investimentos.setBackground(this.getResources().getDrawable(R.drawable.visible_off));
            btn_valor_credito.setBackground(this.getResources().getDrawable(R.drawable.visible_off));


            //Reduz em a escala da imagem de visible_off para 60%
            btn_valor_saldo.setScaleX(.4f);
            btn_valor_saldo.setScaleY(.5f);

            btn_valor_investimentos.setScaleX(.4f);
            btn_valor_investimentos.setScaleY(.5f);

            btn_valor_credito.setScaleX(.4f);
            btn_valor_credito.setScaleY(.5f);


        }


    }


}
