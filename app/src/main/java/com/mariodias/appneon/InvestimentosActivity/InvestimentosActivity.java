package com.mariodias.appneon.InvestimentosActivity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import com.mariodias.appneon.DashboardActivity.DashboardActivity;
import com.mariodias.appneon.R;

import java.util.ArrayList;
import java.util.List;

public class InvestimentosActivity extends AppCompatActivity {

    private List<InvestimentosModel> investimento;
    private InvestimentosAdapter adapter;

    private ListView listInvestimento;
    private InvestimentosViewModel investimentosViewModel;

    private Window window;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investimentos);

        investimentosViewModel = new InvestimentosViewModel();


        configuraToolbar();

        //Ajusta a cor do StatusBar
        window = getWindow();
        window.setStatusBarColor(Color.rgb(0, 238, 255));

        insereInvestimentos();

        listInvestimento = findViewById(R.id.listInvestimento);

        adapter = new InvestimentosAdapter(this, investimento);
        listInvestimento.setAdapter(adapter);
        listInvestimento.setDivider(null);

    }

    private void configuraToolbar() {
        Toolbar toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView actionTitle = findViewById(R.id.tbTitle);
        actionTitle.setText(investimentosViewModel.toolbarTitle());

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                finish();
            }
        });
    }

    private void insereInvestimentos() {


        //Dados mockado
        investimento = new ArrayList<>();

        investimento.add(new InvestimentosModel(R.drawable.invest_card_contas, "Contas", 300000f, 032f));
        investimento.add(new InvestimentosModel(R.drawable.invest_card_carro, "Carro", 1500000f, 10054f));
        investimento.add(new InvestimentosModel(R.drawable.invest_card_viagem, "Viagem", 400000f, 9865f));


    }


}
