package com.example.library_x;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    private List<Datamodel> mlist;
    private String Bookname,duedate,publishdate;
    private String image;
    private int expandedPosition = -1;

    public ItemAdapter(List<Datamodel> mlist) {
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Datamodel model = mlist.get(position);
        holder.mtextView.setText(model.getItemText());

        boolean isExpanded = position == expandedPosition;
        holder.relativeLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        if (isExpanded) {
            holder.mArrowImage.setImageResource(R.drawable.arrow_up);
        } else {
            holder.mArrowImage.setImageResource(R.drawable.arrow_down);
        }

        nestedAdapter adapter = new nestedAdapter(Bookname,duedate,publishdate, image);
        holder.nestedrecyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        holder.nestedrecyclerView.setHasFixedSize(true);
        holder.nestedrecyclerView.setAdapter(adapter);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Datamodel model = mlist.get(position);
                boolean isExpandable = model.isExpandable();

                // Toggle the expandable state of the clicked item
                model.setExpandable(!isExpandable);
                Bookname = model.getItemText();
                duedate = model.getDuedate();
                publishdate = model.getPublishdate();
                image = model.getImage();

                // Collapse the previously expanded item (if any)
                if (expandedPosition != -1 && expandedPosition != position) {
                    Datamodel prevExpandedModel = mlist.get(expandedPosition);
                    prevExpandedModel.setExpandable(false);
                    notifyItemChanged(expandedPosition);
                }

                // Update the expanded position
                expandedPosition = isExpandable ? -1 : position;

                // Notify the adapter of item changes
                notifyItemChanged(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final LinearLayout linearLayout;
        private final RelativeLayout relativeLayout;
        private final TextView mtextView;
        private final ImageView mArrowImage;
        private final RecyclerView nestedrecyclerView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.linearLayout);
            relativeLayout = itemView.findViewById(R.id.expandable_layout);
            mtextView = itemView.findViewById(R.id.itemTv);
            mArrowImage = itemView.findViewById(R.id.arrow_imageview);
            nestedrecyclerView = itemView.findViewById(R.id.child_rv);
        }
    }
}
