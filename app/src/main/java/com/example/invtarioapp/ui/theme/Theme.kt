package com.example.invtarioapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    /* aquí tus colores si quieres */
)
private val DarkColors  = darkColorScheme(
    /* aquí tus colores si quieres */
)

@Composable
fun InvtarioAppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme  = if (darkTheme) DarkColors else LightColors,
        typography   = MaterialTheme.typography,
        content      = content
    )
}