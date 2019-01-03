package com.mariodias.appneon.InvestimentosActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mariodias.appneon.R;
import com.mariodias.appneon.Util;

import java.util.List;

public class InvestimentosAdapter extends BaseAdapter {

    private Context context;
    private List<InvestimentosModel> investimentosModel;

    private InvestimentosViewModel viewModel;

    public InvestimentosAdapter(Context context, List<InvestimentosModel> investimentosModel) {
        this.context = context;
        this.investimentosModel = investimentosModel;
    }

    @Override
    public int getCount() {
        return investimentosModel.size();
    }

    @Override
    public Object getItem(int position) {
        return investimentosModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {


        InvestimentosModel investimento = investimentosModel.get(position);
        viewModel = new InvestimentosViewModel();


        //Utiliza o ViewHolder para reaproveitar a celulas que nao sao mais exibidas na tela.
        ViewHolder holder = null;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.celula_investimentos, viewGroup, false);

            holder = new ViewHolder();

            holder.imgFundoInvestimento = view.findViewById(R.id.imgFundoInvestimento);
            holder.txtTituloInvestimento = view.findViewById(R.id.txtTituloInvestimento);
            holder.txtValorDepositado = view.findViewById(R.id.txtValorDepositado);
            holder.txtValorRendimento = view.findViewById(R.id.txtValorRendimento);

            holder.imgFundoInvestimento.setBackgroundResource(investimento.imgFundoInvestimento);
            holder.txtTituloInvestimento.setText(investimento.tituloInvestimentos);
            holder.txtValorDepositado.setText(Util.BRLMaskCurrency(investimento.valorDepositado));
            holder.txtValorRendimento.setText("+ " + Util.BRLMaskCurrency(investimento.valorRendimento));

            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }

        return view;
    }

    static class ViewHolder {
        ImageView imgFundoInvestimento;
        TextView txtTituloInvestimento;
        TextView txtValorDepositado;
        TextView txtValorRendimento;
    }
}
