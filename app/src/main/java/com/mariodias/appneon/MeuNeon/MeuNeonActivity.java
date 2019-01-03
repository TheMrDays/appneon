package com.mariodias.appneon.MeuNeon;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mariodias.appneon.DashboardActivity.DashboardActivity;
import com.mariodias.appneon.R;

import java.util.ArrayList;
import java.util.List;

public class MeuNeonActivity extends AppCompatActivity {

    private Window window;
    private MeuNeonViewModel viewModel;

    private List<LimitesModel> listLimites;
    private MeuNeonAdapter adapter;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_neon);
        window = getWindow();
        window.setStatusBarColor(Color.rgb(0, 0, 198));


        inicializaComponentes();
        configuraToolbar();

        listLimites.add(new LimitesModel("entre contas neon", 1200000, 1200000));
        listLimites.add(new LimitesModel("para outros bancos (mesmo CPF)", 400000, 1000000));
        listLimites.add(new LimitesModel("para outros bancos (mesmo CPF)", 750000, 900000));

        configuraHeaderListView();

        adapter = new MeuNeonAdapter(this, listLimites);
        listView.setAdapter(adapter);
        listView.setDivider(null);


    }


    private void inicializaComponentes() {


        listView = findViewById(R.id.listLimites);

        viewModel = new MeuNeonViewModel();
        listLimites = new ArrayList<>();


    }

    private void configuraToolbar() {
        //Configura Toolbar
        Toolbar toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView actionTitle = findViewById(R.id.tbTitle);
        actionTitle.setText(viewModel.toolbarTitle());

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                finish();
            }
        });
    }

    private void configuraHeaderListView() {

        TextView txtHeader = new TextView(this);

        txtHeader.setBackgroundColor(Color.argb(0,0,0,0));
        txtHeader.setTextColor(Color.WHITE);
        txtHeader.setText("transferências");
        txtHeader.setTextSize(20);
        txtHeader.setPadding(50,20,20,20);

        listView.addHeaderView(txtHeader);

    }
}
