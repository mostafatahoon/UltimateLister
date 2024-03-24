package com.example.mygrocerapp.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.mygrocerapp.R
import com.example.mygrocerapp.data.db.entities.ShoppingItem
import com.example.mygrocerapp.ui.shoppinglist.ShoppingViewModel

//ctrl + i for the methods
class ShoppingItemAdapter(
   var items:List<ShoppingItem> ,
    private val viewModel: ShoppingViewModel
):RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem=items[position]
        holder.itemView.findViewById<TextView>(R.id.tvName).text=curShoppingItem.name
        holder.itemView.findViewById<TextView>(R.id.tvAmount).text="${curShoppingItem.amount}"
        holder.itemView.findViewById<ImageView>(R.id.ivDelete).setOnClickListener{
            viewModel.delete(curShoppingItem)
        }
        holder.itemView.findViewById<ImageView>(R.id.ivPlus).setOnClickListener{
            curShoppingItem.amount++
            viewModel.upsert(curShoppingItem)
        }

        holder.itemView.findViewById<ImageView>(R.id.ivMinus).setOnClickListener {
            if (curShoppingItem.amount>0) {
                curShoppingItem.amount--
                viewModel.upsert(curShoppingItem)
            }
        }   



    }
}