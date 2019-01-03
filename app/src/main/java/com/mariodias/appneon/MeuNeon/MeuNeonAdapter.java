package com.mariodias.appneon.MeuNeon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mariodias.appneon.R;
import com.mariodias.appneon.Util;

import java.util.List;

public class MeuNeonAdapter extends BaseAdapter {

    private Context context;
    private List<LimitesModel> listLimitesModel;
    private MeuNeonViewModel viewModel;



    public MeuNeonAdapter(Context context, List<LimitesModel> listLimitesModel) {
        this.context = context;
        this.listLimitesModel = listLimitesModel;
    }



    @Override
    public int getCount() {
        return listLimitesModel.size();
    }

    @Override
    public Object getItem(int position) {
        return listLimitesModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {


        LimitesModel limitesModel = listLimitesModel.get(position);
        viewModel = new MeuNeonViewModel();
        ViewHolder holder;

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.celula_limites_diarios, viewGroup, false);

            holder = new ViewHolder();


            holder.txtTituloLimite = view.findViewById(R.id.txtTituloLimite);
            holder.progressBarLimite = view.findViewById(R.id.progressBarLimites);
            holder.txtLimiteDisponivel = view.findViewById(R.id.txtLimiteDisponivel);
            holder.txtLimiteTotal = view.findViewById(R.id.txtLimiteTotal);


            //Configura a animacao do progressBar (ValorDisponivel / ValorTotal * 100)
            int to = viewModel.calculaProgressBar(limitesModel.valorTotal, limitesModel.valorDisponivel);

            ProgressBarAnimation anim = new ProgressBarAnimation(holder.progressBarLimite, 0, to);
            anim.setDuration(2000);
            holder.progressBarLimite.startAnimation(anim);

            holder.txtTituloLimite.setText(limitesModel.tituloLimites);
            holder.txtLimiteDisponivel.setText(Util.BRLMaskCurrency(limitesModel.valorDisponivel));
            holder.txtLimiteTotal.setText(Util.BRLMaskCurrency(limitesModel.valorTotal));


            view.setTag(holder);



        } else {
            holder = (ViewHolder)view.getTag();
        }


        return view;
    }

    static class ViewHolder {

        TextView txtTituloLimite;
        ProgressBar progressBarLimite;
        TextView txtLimiteDisponivel;
        TextView txtLimiteTotal;


    }
}





