package com.example.invtarioapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.invtarioapp.ui.theme.AddProductScreen
import com.example.invtarioapp.ui.theme.ProductListScreen
import com.example.invtarioapp.ui.theme.ProductViewModel

@Composable
fun NavigationHost(
    navController: NavHostController,
    viewModel: ProductViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "listado",
        modifier = Modifier
    ) {
        composable("listado") {
            // recopilamos la lista de productos del StateFlow
            val lista = viewModel.productos.collectAsState().value
            ProductListScreen(
                productos     = lista,
                navController = navController,
                viewModel     = viewModel
            )
        }
        composable("agregar") {
            AddProductScreen(
                navController = navController,
                viewModel     = viewModel
            )
        }
    }
}
