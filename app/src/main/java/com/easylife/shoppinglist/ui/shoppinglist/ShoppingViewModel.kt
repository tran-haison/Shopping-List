package com.easylife.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.easylife.shoppinglist.data.db.entities.ShoppingItem
import com.easylife.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {

    fun insert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.insert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}