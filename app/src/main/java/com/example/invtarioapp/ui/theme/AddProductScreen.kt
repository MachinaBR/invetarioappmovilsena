package com.example.invtarioapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.invtarioapp.Product
import com.example.invtarioapp.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(navController: NavHostController, viewModel: ProductViewModel) {
    var nombre = remember { mutableStateOf(TextFieldValue("")) }
    var categoria = remember { mutableStateOf(TextFieldValue("")) }
    var cantidad = remember { mutableStateOf(TextFieldValue("")) }
    var precio = remember { mutableStateOf(TextFieldValue("")) }
    var proveedor = remember { mutableStateOf(TextFieldValue("")) }
    var errorMensaje by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF074B75))
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Agregar Producto", color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))

        // Campos personalizados
        BasicTextFieldPersonalizado(nombre, "Nombre del Producto")
        BasicTextFieldPersonalizado(categoria, "Categoría")
        BasicTextFieldPersonalizado(cantidad, "Cantidad")
        BasicTextFieldPersonalizado(precio, "Precio")
        BasicTextFieldPersonalizado(proveedor, "Proveedor")

        if (errorMensaje.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = errorMensaje,
                color = Color.Red
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón Guardar
        Button(
            onClick = {
                if (
                    nombre.value.text.isNotBlank() &&
                    categoria.value.text.isNotBlank() &&
                    cantidad.value.text.isNotBlank() &&
                    precio.value.text.isNotBlank() &&
                    proveedor.value.text.isNotBlank()
                ) {
                    // Guardar producto
                    val nuevoProducto = Product(
                        id = (0..1000).random(),
                        nombre = nombre.value.text,
                        categoria = categoria.value.text,
                        cantidad = cantidad.value.text.toIntOrNull() ?: 0,
                        precio = precio.value.text.toDoubleOrNull() ?: 0.0,
                        proveedor = proveedor.value.text,
                        imagenUri = null
                    )
                    viewModel.agregarProducto(nuevoProducto)
                    navController.popBackStack() // Volver al listado
                } else {
                    errorMensaje = "⚠️ Todos los campos son obligatorios."
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2ECC71))
        ) {
            Text(text = "Guardar Producto")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Botón Cancelar
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF09395B))
        ) {
            Text(text = "Cancelar")
        }
    }
}

@Composable
fun BasicTextFieldPersonalizado(state: MutableState<TextFieldValue>, placeholder: String) {
    BasicTextField(
        value = state.value,
        onValueChange = { newValue -> state.value = newValue },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        decorationBox = { innerTextField ->
            if (state.value.text.isEmpty()) {
                Text(text = placeholder, color = Color.Gray)
            }
            innerTextField()
        }
    )
    Spacer(modifier = Modifier.height(8.dp))
}
