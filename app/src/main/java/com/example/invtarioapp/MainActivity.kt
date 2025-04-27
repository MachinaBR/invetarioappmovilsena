package com.example.invtarioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.invtarioapp.ui.theme.InvtarioAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InvtarioAppTheme {
                val navController = rememberNavController()
                NavigationHost(navController = navController)
            }
        }
    }
}
