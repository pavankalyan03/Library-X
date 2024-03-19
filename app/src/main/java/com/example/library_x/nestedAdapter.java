package com.example.library_x;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import org.jetbrains.annotations.NotNull;


public class nestedAdapter extends RecyclerView.Adapter<nestedAdapter.nestedViewHolder> {

    private final String details;
    private final String image;

    public nestedAdapter(String details, String image) {
        this.details = details;
        this.image = image;
    }

    @NonNull
    @NotNull
    @Override
    public nestedViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nested_item, parent, false);
        return new nestedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull nestedViewHolder holder, int position) {
        holder.mtv.setText(image);
//        holder.mImageView.setImageResource(image);
        Picasso.get().load(image).into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class nestedViewHolder extends RecyclerView.ViewHolder {

        private final TextView mtv;
        private final ImageView mImageView;

        public nestedViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            mtv = itemView.findViewById(R.id.nestedItemTv);
            mImageView = itemView.findViewById(R.id.imageView);
        }
    }

}
