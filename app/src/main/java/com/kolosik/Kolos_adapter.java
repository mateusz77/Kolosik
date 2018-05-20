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

public class Kolos_adapter extends RecyclerView.Adapter<Kolos_adapter.ProductViewHolder> {

    private Context mCtx;
    private List<Kolos> productList;

    public Kolos_adapter(Context mCtx, List<Kolos> productList){
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public Kolos_adapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.kolos_reeee, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Kolos_adapter.ProductViewHolder holder, int position) {
        Kolos product = productList.get(position);

        holder.nazwa.setText(product.getNazwa());


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView nazwa;

        public ProductViewHolder(View itemView) {
            super(itemView);
            nazwa = itemView.findViewById(R.id.textView_nazwa_kolosa_kolos_reee);

        }
    }

}
