package com.example.myapplication

import MyAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MyAdapter.ItemClickListener {

    private lateinit var adapter: MyAdapter
    val products = ArrayList<Product>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        products.add(Product("iPad", "iPad Pro 11-inch", 400.0))
        products.add(Product("MacBook M3 Pro", "12-core CPU\n18-core GPU", 2500.00))
        products.add(Product("Dell Inspiron", "13th Gen Intel® Core™ i7", 1499.00))
        products.add(Product("Logitech Keyboard", "Logitech - PRO X\nTKL LIGHTSPEED Wireless", 199.00))
        products.add(Product("MacBook M3 Max", "14-core CPU\n30-core GPU", 3499.00))

        val recyclerView: RecyclerView = findViewById(R.id.rvAnimals)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(this, products, this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(view: View, position: Int) {
        val product = products[position]
        SelectedProduct.setProduct(product)
        val intent = Intent(this, ProductDetailsActivity::class.java)
        startActivity(intent)
    }

}
