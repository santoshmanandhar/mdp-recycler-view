package com.example.myapplication

object SelectedProduct {
    var product: Product? = null
    private set

    fun setProduct(selectedProduct: Product) {
        product = selectedProduct
    }
}