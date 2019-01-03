package com.mariodias.appneon;

import android.graphics.Color;
import android.view.Window;

import java.text.NumberFormat;
import java.util.Locale;

public  class Util {

    public static String BRLMaskCurrency(float valor){

        //Formata o valor informado para o padrao real
            Locale locale = new Locale("pt", "BR");
            NumberFormat saldoFormated = NumberFormat.getCurrencyInstance(locale);
            return saldoFormated.format(valor / 100);

    }


}
