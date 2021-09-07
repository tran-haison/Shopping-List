package com.easylife.shoppinglist.ui.shoppinglist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.easylife.shoppinglist.R
import com.easylife.shoppinglist.data.db.entities.ShoppingItem
import com.easylife.shoppinglist.others.ShoppingItemAdapter
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ShoppingActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: ShoppingViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val viewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)

        val shoppingItemAdapter = ShoppingItemAdapter(listOf(), viewModel)

        rvShoppingItems.setHasFixedSize(true)
        rvShoppingItems.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvShoppingItems.adapter = shoppingItemAdapter

        viewModel.getAllShoppingItems().observe(this, {
            shoppingItemAdapter.items = it
            shoppingItemAdapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingItemDialog(this, object : AddDialogListener {
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.insert(item)
                }
            }).show()
        }
    }
}