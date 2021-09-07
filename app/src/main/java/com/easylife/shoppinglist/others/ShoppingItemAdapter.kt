package com.easylife.shoppinglist.others

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.easylife.shoppinglist.R
import com.easylife.shoppinglist.data.db.entities.ShoppingItem
import com.easylife.shoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]

        holder.itemView.tvName.text = currentShoppingItem.name
        holder.itemView.tvAmount.text = "${currentShoppingItem.amount}"

        holder.itemView.ivDelete.setOnClickListener{
            viewModel.delete(currentShoppingItem)
        }

        holder.itemView.ivPlus.setOnClickListener {
            currentShoppingItem.amount++
            viewModel.insert(currentShoppingItem)
        }

        holder.itemView.ivMinus.setOnClickListener {
            if (currentShoppingItem.amount > 0) {
                currentShoppingItem.amount--
                viewModel.insert(currentShoppingItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder(view: View) : RecyclerView.ViewHolder(view)
}