package com.example.mygrocerapp.ui.shoppinglist

import com.example.mygrocerapp.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClick(item:ShoppingItem)


}