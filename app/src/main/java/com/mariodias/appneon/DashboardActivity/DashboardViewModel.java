package com.mariodias.appneon.DashboardActivity;


import com.mariodias.appneon.Util;


public class DashboardViewModel {

    private String valor_conta, valor_investimentos, valor_credito;


    private boolean handleValorButtonTap() {
        return true;
    }


    /* Para efeito de teste, estou fixando os valores dos saldos de conta corrente e investimentos,
     * porem as funcoes buscariam os valores da base */

    public String getSaldoConta() {
        return this.valor_conta = Util.BRLMaskCurrency(128390);
    }

    public String getSaldoInvestimentos() {
        return this.valor_investimentos = Util.BRLMaskCurrency(283791);
    }

    public String getSaldoCredito() {
        return this.valor_credito = Util.BRLMaskCurrency(378132);
    }


    //Mostra ou Oculta os valores da dashboard quando clicado
    public boolean showValores(String valorSaldo) {
        return valorSaldo == " ";
    }

}
