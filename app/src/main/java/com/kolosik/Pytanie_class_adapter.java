package com.kolosik;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ciasteczko on 19/05/2018.
 */

public class Pytanie_class_adapter extends RecyclerView.Adapter<Pytanie_class_adapter.ProductViewHolder>{

    private Context mCtx;
    private List<Pytanie_class> productList;



    public Pytanie_class_adapter(Context mCtx, List<Pytanie_class> productList){
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public Pytanie_class_adapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.podglad_reeee, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Pytanie_class product = productList.get(position);

        holder.pytanie.setText(product.getPytanie());
        holder.odpA.setText(product.getOdpowiedzA());
        holder.odpB.setText(String.valueOf(product.getOdpowiedzB()));
        holder.odpC.setText(product.getOdpowiedzC());
        holder.odpD.setText(product.getOdpowiedzD());
        holder.odpraw.setText(product.getOdpowiedzPrawidlowa());

    }


    @Override
    public int getItemCount( ) {
        return productList.size();
    }




    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView odpA, odpB, odpC, odpD, odpraw, pytanie;


        public ProductViewHolder(View itemView) {
            super(itemView);
            pytanie = itemView.findViewById(R.id.textView_Pytanielolololo);
            odpA = itemView.findViewById(R.id.textView_odpA);
            odpB = itemView.findViewById(R.id.textView_odpB);
            odpC = itemView.findViewById(R.id.textView_odpC);
            odpD = itemView.findViewById(R.id.textView_odpD);
            odpraw = itemView.findViewById(R.id.textView_odppraw);
        }
    }

}
