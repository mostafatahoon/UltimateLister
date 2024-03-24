package com.example.mygrocerapp.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mygrocerapp.R
import com.example.mygrocerapp.data.db.ShoppingDatabase
import com.example.mygrocerapp.data.db.entities.ShoppingItem
import com.example.mygrocerapp.data.repositories.ShoppingRepository
import com.example.mygrocerapp.other.ShoppingItemAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShoppingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val rvShoppingitems=findViewById<RecyclerView>(R.id.rvShoppingItems)
        val fab=findViewById<FloatingActionButton>(R.id.fab)

        val database=ShoppingDatabase(this)

        val repository=ShoppingRepository(database)

        val factory =ShoppingViewModelFactory(repository)

        val viewModel= ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)

        val adapter= ShoppingItemAdapter(listOf(),viewModel)

        rvShoppingitems.layoutManager= LinearLayoutManager(this)
        rvShoppingitems.adapter=adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items=it
            adapter.notifyDataSetChanged()
        })

      fab.setOnClickListener{
          AddShoppingItemDialog(this,
              object :AddDialogListener{
                  override fun onAddButtonClick(item: ShoppingItem) {
                      viewModel.upsert(item)
                  }
              }).show()
      }



    }
}