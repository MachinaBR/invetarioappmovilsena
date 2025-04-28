package com.example.invtarioapp.network

import com.example.invtarioapp.Product
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("api/productos")
    suspend fun obtenerProductos(): List<Product>

    @POST("api/productos")
    suspend fun guardarProducto(@Body producto: Product): Response<Product>

    @DELETE("api/productos/{id}")
    suspend fun eliminarProducto(@Path("id") id: Int): Response<Unit>
}