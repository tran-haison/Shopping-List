package com.easylife.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.easylife.shoppinglist.R
import com.easylife.shoppinglist.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*


class AddShoppingItemDialog(
    context: Context,
    private val addDialogListener: AddDialogListener
) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please enter all information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val shoppingItem = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(shoppingItem)

            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }
}