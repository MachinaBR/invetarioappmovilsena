package com.example.invtarioapp

data class Product(
    val id: Int,
    val nombre: String,
    val categoria: String,
    val cantidad: Int,
    val precio: Double,
    val proveedor: String?,
    val imagenUri: String?
)