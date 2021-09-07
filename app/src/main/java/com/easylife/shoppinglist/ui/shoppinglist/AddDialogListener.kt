package com.easylife.shoppinglist.ui.shoppinglist

import com.easylife.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}