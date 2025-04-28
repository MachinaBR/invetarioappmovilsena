package com.example.invtarioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.invtarioapp.ui.theme.InvtarioAppTheme
import com.example.invtarioapp.ui.theme.ProductViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 1) Aplica tu tema Compose
            InvtarioAppTheme {
                // 2) Crea NavController en Compose
                val navController = rememberNavController()
                // 3) Saca tu ViewModel con la extensión de Compose
                val vm: ProductViewModel = viewModel()

                // 4) Lanza tu host de navegación (ya debe aceptar vm)
                NavigationHost(
                    navController = navController,
                    viewModel     = vm
                )
            }
        }
    }
}
