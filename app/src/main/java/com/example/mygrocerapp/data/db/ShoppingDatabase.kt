package com.example.mygrocerapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mygrocerapp.data.db.entities.ShoppingItem


@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase :RoomDatabase(){

    abstract fun getShoppingDao(): ShoppingDao

    companion object{

    @Volatile
    private var instance: ShoppingDatabase? =null
        private val Lock=Any()

        //this invoke will run when we call the function like that
        //ShoppingDatabase()
        //?: will return the instance if he is null will return what is right
        operator fun invoke(context: Context)= instance ?: synchronized(Lock){
            instance ?: createDatebase(context).also { instance =it }
        }
        //synchnorized no other threats will access it at the same time

       private fun createDatebase(context:Context)=
           Room.databaseBuilder(context.applicationContext
               , ShoppingDatabase::class.java,"ShoppingDB.db").build()

    }



}