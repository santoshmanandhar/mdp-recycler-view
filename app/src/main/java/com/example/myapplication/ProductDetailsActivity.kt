package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityProductDetailsBinding


class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve selected product from SelectedProduct object
        val selectedProduct = SelectedProduct.product

        // Update UI with selected product details
        selectedProduct?.let { product ->
            binding.tvProductName.text = product.productName
            binding.tvProductDescription.text = product.productDescription
            binding.tvProductPrice.text = "$"+ product.cost
        }

        binding.backHome.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
}
