package com.example.mygrocerapp.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.mygrocerapp.R
import com.example.mygrocerapp.data.db.entities.ShoppingItem

class AddShoppingItemDialog (context:Context,var addDialogListener: AddDialogListener) :AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        val tvadd:TextView?=findViewById<TextView>(R.id.tvAdd)
        val tvcancel:TextView?=findViewById<TextView>(R.id.tvCancel)
        val etName:TextView?=findViewById<TextView>(R.id.etName)
        val etAmount:TextView?=findViewById<TextView>(R.id.etAmount)
        tvadd?.setOnClickListener {
         val name = etName?.text.toString()
            val amount = etAmount?.text.toString()

            if (name.isEmpty()||amount.isEmpty()){
                Toast.makeText(context, "please enter all the information", Toast.LENGTH_SHORT).show()
            }

          val item= ShoppingItem(name,amount.toInt())
            addDialogListener.onAddButtonClick(item)
            dismiss()


        }
     tvcancel?.setOnClickListener{
         cancel()
     }

    }

}