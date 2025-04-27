package com.example.invtarioapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.invtarioapp.Product
import com.example.invtarioapp.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(productos: List<Product>, navController: NavHostController, viewModel: ProductViewModel) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("agregar")
                },
                containerColor = Color(0xFF2ECC71)
            ) {
                Text("+")
            }
        },
        containerColor = Color(0xFF001f3f) // Fondo azul marino oscuro
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            item {
                Text(
                    text = "Inventario de Productos",
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            items(productos) { producto ->
                var showDialog by remember { mutableStateOf(false) }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = producto.nombre, style = MaterialTheme.typography.titleLarge)
                        Text(text = "Categoría: ${producto.categoria}")
                        Text(text = "Cantidad: ${producto.cantidad}")
                        Text(text = "Precio: \$${producto.precio}")
                        Text(text = "Proveedor: ${producto.proveedor ?: "No definido"}")

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Button(
                                onClick = {
                                    showDialog = true
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFE74C3C) // Rojo
                                )
                            ) {
                                Text("Eliminar")
                            }
                        }

                        if (showDialog) {
                            AlertDialog(
                                onDismissRequest = { showDialog = false },
                                title = { Text(text = "Confirmar eliminación") },
                                text = { Text(text = "¿Estás seguro de que deseas eliminar este producto?") },
                                confirmButton = {
                                    Button(
                                        onClick = {
                                            viewModel.eliminarProducto(producto)
                                            showDialog = false
                                        },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color(0xFFE74C3C)
                                        )
                                    ) {
                                        Text("Sí, eliminar")
                                    }
                                },
                                dismissButton = {
                                    OutlinedButton(
                                        onClick = { showDialog = false }
                                    ) {
                                        Text("Cancelar")
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
