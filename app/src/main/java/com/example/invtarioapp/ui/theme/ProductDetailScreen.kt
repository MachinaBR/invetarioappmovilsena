package com.example.invtarioapp.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.invtarioapp.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    product: Product,
    onSave: (Product) -> Unit,
    onCancel: () -> Unit
) {
    var nombre by remember { mutableStateOf(product.nombre) }
    var categoria by remember { mutableStateOf(product.categoria) }
    var cantidad by remember { mutableStateOf(product.cantidad.toString()) }
    var precio by remember { mutableStateOf(product.precio.toString()) }
    var proveedor by remember { mutableStateOf(product.proveedor ?: "") }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()
    ) {
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre del producto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = categoria,
            onValueChange = { categoria = it },
            label = { Text("Categoría") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text("Cantidad") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = proveedor,
            onValueChange = { proveedor = it },
            label = { Text("Proveedor") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { onCancel() }) {
                Text("Cancelar")
            }
            Button(onClick = {
                onSave(
                    Product(
                        id = product.id,
                        nombre = nombre,
                        categoria = categoria,
                        cantidad = cantidad.toIntOrNull() ?: 0,
                        precio = precio.toDoubleOrNull() ?: 0.0,
                        proveedor = if (proveedor.isBlank()) null else proveedor,
                        imagenUri = product.imagenUri
                    )
                )
            }) {
                Text("Guardar")
            }
        }
    }
}


