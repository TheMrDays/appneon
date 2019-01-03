package com.mariodias.appneon.MeuNeon;

import android.util.Log;

import java.text.NumberFormat;
import java.util.Locale;

public class MeuNeonViewModel {


    public String toolbarTitle(){
        return "meu neon";
    }

    public int calculaProgressBar(int valorTotal, int valorDisponivel){

        float resultado = (float)valorDisponivel / (float)valorTotal * 100;

        return  (int)resultado;
    }
}
