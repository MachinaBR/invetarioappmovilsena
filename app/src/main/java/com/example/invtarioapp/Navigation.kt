package com.example.invtarioapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.invtarioapp.ui.theme.ProductListScreen
import com.example.invtarioapp.ui.theme.AddProductScreen

@Composable
fun NavigationHost(navController: NavHostController, modifier: Modifier = Modifier) {
    val viewModel: ProductViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "listado",
        modifier = modifier
    ) {
        composable(route = "listado") {
            ProductListScreen(
                productos = viewModel.productos,
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(route = "agregar") {
            AddProductScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}
