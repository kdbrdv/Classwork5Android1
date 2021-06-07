package com.example.classwork5android1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classwork5android1.databinding.ItemBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Model> list = new ArrayList<>();

    public void addItems(Model arrayList) {
        this.list.add(0,arrayList);
        notifyDataSetChanged();
    }


    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemBinding binding;

        public ViewHolder(ItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(Model model) {
            binding.tvName.setText(model.getName());
            binding.tvNumber.setText(model.getNumber());

        }
    }
}
