package com.mariodias.appneon.LoginActivity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.mariodias.appneon.DashboardActivity.DashboardActivity;
import com.mariodias.appneon.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private RatingBar myRatingBar;

    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6;
    private Button btn_7, btn_8, btn_9, btn_0, btn_ajuda, btn_limpa;


    private LoginActivityViewModel loginActivityViewModel;

    private Window window;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Configura cor do Status Bar
        window = getWindow();
        window.setStatusBarColor(Color.rgb(0, 238, 255));

        //Faz a conexao dos componentes com a classe
        inicializaComponentes();

    }

    private void inicializaComponentes() {

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_ajuda = findViewById(R.id.btn_ajuda);
        btn_limpa = findViewById(R.id.btn_limpa);

        myRatingBar = findViewById(R.id.ratingBar);

        loginActivityViewModel = new LoginActivityViewModel();


        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_limpa.setOnClickListener(this);
        btn_ajuda.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        // A cada clique, sera incluido o numero correspondente do botao na string
        switch (view.getId()) {
            case R.id.btn_0:
                loginActivityViewModel.handlePasswordButtonTap("0");
                break;
            case R.id.btn_1:
                loginActivityViewModel.handlePasswordButtonTap("1");
                break;
            case R.id.btn_2:
                loginActivityViewModel.handlePasswordButtonTap("2");
                break;
            case R.id.btn_3:
                loginActivityViewModel.handlePasswordButtonTap("3");
                break;
            case R.id.btn_4:
                loginActivityViewModel.handlePasswordButtonTap("4");
                break;
            case R.id.btn_5:
                loginActivityViewModel.handlePasswordButtonTap("5");
                break;
            case R.id.btn_6:
                loginActivityViewModel.handlePasswordButtonTap("6");
                break;
            case R.id.btn_7:
                loginActivityViewModel.handlePasswordButtonTap("7");
                break;
            case R.id.btn_8:
                loginActivityViewModel.handlePasswordButtonTap("8");
                break;
            case R.id.btn_9:
                loginActivityViewModel.handlePasswordButtonTap("9");
                break;
            case R.id.btn_limpa:
                loginActivityViewModel.handlePasswordCleanButtonTap();
                break;
            case R.id.btn_ajuda:

                break;
        }

        /* Toda vez que um botao eh clicado, esse metodo eh chamado para atualizar o ratingBar
         * e dar o efeito de 'preenchido' */
        atualizaRating();


        /* Quando a string atingir o tamanhho 6, ehh feito a validacao do login*/
        login();


    }

    private void atualizaRating() {

        myRatingBar.setRating(loginActivityViewModel.currentPasswordLenght());

        if (loginActivityViewModel.isPasswordComplete()) {
            Toast.makeText(this, loginActivityViewModel.toastMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private void login() {

        /* Quando o lenght da string atingir 6, eh feito a validacao da senha e logo em seguida
           chama a tela do Dashboard  */
        if (loginActivityViewModel.isPasswordComplete()) {
            Intent intent = new Intent(this, DashboardActivity.class);
            startActivity(intent);
            finish();
        }


    }

}
