package com.example.invtarioapp.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.invtarioapp.Product // <-- corregido aquí
import com.example.invtarioapp.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val repository = ProductRepository()

    private val _productos = MutableStateFlow<List<Product>>(emptyList())
    val productos: StateFlow<List<Product>> = _productos

    init {
        cargarProductos()
    }

    fun cargarProductos() {
        viewModelScope.launch {
            try {
                _productos.value = repository.obtenerProductos()
            } catch(e:Exception) {
                e.printStackTrace()
            }
        }
    }

    fun guardarProducto(producto: Product) {
        viewModelScope.launch {
            try {
                repository.guardarProducto(producto)
                cargarProductos()
            } catch(e:Exception) {
                e.printStackTrace()
            }
        }
    }

    fun eliminarProducto(id: Int) {
        viewModelScope.launch {
            try {
                repository.eliminarProducto(id)
                cargarProductos()
            } catch(e:Exception) {
                e.printStackTrace()
            }
        }
    }
}