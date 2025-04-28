package com.example.invtarioapp.repository

import com.example.invtarioapp.Product
import com.example.invtarioapp.network.RetrofitInstance
import retrofit2.Response

class ProductRepository {

    suspend fun obtenerProductos(): List<Product> {
        return RetrofitInstance.api.obtenerProductos()
    }

    suspend fun guardarProducto(producto: Product): Response<Product> {
        return RetrofitInstance.api.guardarProducto(producto)
    }

    suspend fun eliminarProducto(id: Int): Response<Unit> {
        return RetrofitInstance.api.eliminarProducto(id)
    }
}


