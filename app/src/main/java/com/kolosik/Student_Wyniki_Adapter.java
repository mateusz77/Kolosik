package com.kolosik;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;




import java.util.List;

/**
 * Created by Ciasteczko on 18/05/2018.
 */



public class Student_Wyniki_Adapter extends RecyclerView.Adapter<Student_Wyniki_Adapter.ProductViewHolder> {

    private Context mCtx;
    private List<Student_Wyniki> productList;

    public Student_Wyniki_Adapter(Context mCtx, List<Student_Wyniki> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.wynikireeeee, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Student_Wyniki product = productList.get(position);

        holder.textViewTitle.setText(product.getImie());
        holder.textViewShortDesc.setText(product.getNazwisko());
        holder.textViewRating.setText(String.valueOf(product.getPunkty()));
        holder.textViewPrice.setText(String.valueOf(product.getKlasa()));
    }

    @Override
    public int getItemCount( ) {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textView_Title);
            textViewShortDesc = itemView.findViewById(R.id.textView_odpA);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
