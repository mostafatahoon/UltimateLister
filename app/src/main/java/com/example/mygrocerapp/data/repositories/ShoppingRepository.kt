package com.example.mygrocerapp.data.repositories

import com.example.mygrocerapp.data.db.ShoppingDatabase
import com.example.mygrocerapp.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db:ShoppingDatabase
) {
    suspend fun upsort(item:ShoppingItem)=db.getShoppingDao().upsert(item)
    suspend fun delete(item:ShoppingItem)=db.getShoppingDao().delete(item)

    fun getAllShoppingItems()=db.getShoppingDao().getAllShoppingItems()

}