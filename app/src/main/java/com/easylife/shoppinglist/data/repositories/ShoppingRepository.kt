package com.easylife.shoppinglist.data.repositories

import com.easylife.shoppinglist.data.db.ShoppingDatabase
import com.easylife.shoppinglist.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun insert(item: ShoppingItem) = db.getShoppingDao().insert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}