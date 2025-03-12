package com.example.mealmate_demo.Adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mealmate_demo.Model.Grocery;
import com.example.mealmate_demo.R;
import com.example.mealmate_demo.RecyclerClick.RecyclerClickViewGrocery;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder>{
    private final RecyclerClickViewGrocery itemClickListener;
    private final ArrayList<Grocery> items;
    public GroceryAdapter(ArrayList<Grocery> items, RecyclerClickViewGrocery itemClickListener) {
        this.itemClickListener = itemClickListener;
        this.items = items;
    }

    @NonNull
    @Override
    public GroceryAdapter.GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.signle_grocery, parent, false);
        return new GroceryViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GroceryAdapter.GroceryViewHolder holder, int position) {
        Grocery item = items.get(position);
        holder.textViewName.setText(item.getName());
        if(item.isPurchased()) {
            holder.textViewName.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_check, 0);
        }
        holder.textViewPrice.setText(String.valueOf(item.getPrice()));
        holder.textViewDescription.setText(item.getDescription());
        Uri imageUri = item.getImage();
        if(imageUri != null) {
            holder.imageView.setImageURI(imageUri);
        }
    }

    @Override
    public int getItemCount() {
        return  items.size();
    }

    public class GroceryViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView textViewName, textViewPrice, textViewDescription;

        public GroceryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itemImage);
            textViewName = itemView.findViewById(R.id.itemName);
            textViewPrice = itemView.findViewById(R.id.ItemPrice);
            textViewDescription = itemView.findViewById(R.id.itemDescription);

            itemView.setOnClickListener(this::itemViewOnClick);
        }
        private void itemViewOnClick(View view) {
            itemClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
