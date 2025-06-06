package com.example.junkfoodcounterapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.junkfoodcounterapp.R
import com.example.junkfoodcounterapp.databinding.ItemListBinding
import com.example.junkfoodcounterapp.model.Food

class FoodAdapter(private val dataSet: List<Food>) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val food = dataSet[position]
        viewHolder.bindItem(food)
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(val view:View) : RecyclerView.ViewHolder(view) {
        val binding = ItemListBinding.bind(view)
        var context = view.context

        fun bindItem(food: Food){
            binding.txtName.text = context.getString(R.string.food_name_tag, food.name)
            binding.txtTimes.text = food.times.size.toString()
            binding.imgIcon.setImageResource(R.drawable.ic_fast_food)
        }
    }
}