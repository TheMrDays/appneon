package com.mariodias.appneon.InvestimentosActivity;

public class InvestimentosModel {

    public int imgFundoInvestimento;
    public String tituloInvestimentos;
    public float valorDepositado;
    public float valorRendimento;

    public InvestimentosModel(int imgFundoInvestimento, String tituloInvestimentos, float valorDepositado, float valorRendimento) {
        this.imgFundoInvestimento = imgFundoInvestimento;
        this.tituloInvestimentos = tituloInvestimentos;
        this.valorDepositado = valorDepositado;
        this.valorRendimento = valorRendimento;
    }

}
