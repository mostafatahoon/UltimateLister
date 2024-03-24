package com.example.mygrocerapp.ui.shoppinglist

import android.os.Parcelable.Creator
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mygrocerapp.data.repositories.ShoppingRepository

// we create this class bc our ViewModel take repository as a parameters
// and we don't have the option to pass that
@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(
    private val repository: ShoppingRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }


}