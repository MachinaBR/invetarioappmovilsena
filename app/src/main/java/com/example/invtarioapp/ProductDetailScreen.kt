package com.example.inventarioapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.invtarioapp.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(product: Product) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(product.nombre) }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "Categoría: ${product.categoria}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Cantidad: ${product.cantidad}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Precio: $${product.precio}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Proveedor: ${product.proveedor ?: "No especificado"}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
