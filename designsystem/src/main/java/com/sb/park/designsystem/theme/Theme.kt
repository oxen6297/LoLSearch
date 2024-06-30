package com.sb.park.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = NAVY10,
    onPrimary = WHITE,
    primaryContainer = WHITE,
    onPrimaryContainer = NAVY10,
    inversePrimary = WHITE,
    secondary = BLUE,
    onSecondary = WHITE,
    surface = NAVY10,
    onSurface = WHITE,
    onSurfaceVariant = WHITE
)

private val LightColorScheme = lightColorScheme(
    primary = NAVY10,
    onPrimary = WHITE,
    primaryContainer = WHITE,
    onPrimaryContainer = NAVY10,
    inversePrimary = WHITE,
    secondary = BLUE,
    onSecondary = WHITE,
    surface = NAVY10,
    onSurface = WHITE,
    onSurfaceVariant = WHITE
)

val LocalDarkTheme = compositionLocalOf { true }

object LoLTheme {
    val typography: LoLTypography
        @Composable
        get() = LocalTypography.current
}

@Composable
fun LoLSearchTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    CompositionLocalProvider(
        LocalDarkTheme provides darkTheme,
        LocalTypography provides Typography
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content,
        )
    }
}