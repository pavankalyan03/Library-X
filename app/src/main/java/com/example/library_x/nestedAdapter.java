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

    private final String details,duedate,publishdate;
    private final String image;

    public nestedAdapter(String details,String duedate,String publishdate, String image) {
        this.details = details;
        this.duedate = duedate;
        this.publishdate = publishdate;
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
        holder.bookname.setText(details);
        holder.due.setText(duedate);
        holder.publish.setText(publishdate);
//        holder.mImageView.setImageResource(image);
        Picasso.get().load(image).into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class nestedViewHolder extends RecyclerView.ViewHolder {

        private final TextView bookname,due,publish;
        private final ImageView mImageView;

        public nestedViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            bookname = itemView.findViewById(R.id.bookname);
            due = itemView.findViewById(R.id.due);
            publish = itemView.findViewById(R.id.publish);
            mImageView = itemView.findViewById(R.id.imageView);
        }
    }

}
