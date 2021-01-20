package com.univ_amu.food_scanner.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.univ_amu.food_scanner.R;
import com.univ_amu.food_scanner.data.Food;
import com.univ_amu.food_scanner.databinding.FoodItemBinding;
import com.univ_amu.food_scanner.databinding.FragmentFoodListBinding;

public class FoodListAdapter extends ListAdapter<Food, FoodListAdapter.ViewHolder> {

    FoodListAdapter() {
        super(diffUtilCallback);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        FoodItemBinding itemBinding =
                FoodItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Food food = getItem(position);
        holder.bind(food);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        FoodItemBinding binding;
        public Food food;
        public ViewHolder(FoodItemBinding item) {
            super(item.getRoot());
            this.binding = item;
            this.binding.setViewHolder(this);

        }

        void bind(Food food) {
            this.food = food;
            this.binding.invalidateAll();
            }

    }

    private static final DiffUtil.ItemCallback<Food> diffUtilCallback =
            new DiffUtil.ItemCallback<Food>() {
                @Override
                public boolean areItemsTheSame(Food oldFood, Food newFood) {
                    return oldFood.code.equals(newFood.code);
                }
                @Override
                public boolean areContentsTheSame(Food oldFood, Food newFood) {
                    return this.areItemsTheSame(oldFood, newFood);
                }
            };

}