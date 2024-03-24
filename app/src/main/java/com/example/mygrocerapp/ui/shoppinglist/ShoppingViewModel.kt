package com.example.mygrocerapp.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.mygrocerapp.data.db.entities.ShoppingItem
import com.example.mygrocerapp.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel (
    private val repository:ShoppingRepository   // we must pass the repository
):ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsort(item)
    }
    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

   fun getAllShoppingItems()=repository.getAllShoppingItems()
}