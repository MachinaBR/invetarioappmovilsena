package com.example.invtarioapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {
    var productos = mutableStateListOf<Product>()
        private set

    fun agregarProducto(producto: Product) {
        productos.add(producto)
    }

    fun eliminarProducto(producto: Product) {
        productos.remove(producto)
    }
}