package com.sb.park.designsystem.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = NAVY10,
    onPrimary = WHITE,
    primaryContainer = WHITE,
    onPrimaryContainer = NAVY10,
    inversePrimary = DARK_GRAY,
    secondary = BLUE,
    onSecondary = LOSE_RED,
    surface = NAVY,
    onSurface = WHITE,
    onSurfaceVariant = WHITE,
    outline = NAVY10,
    surfaceTint = YELLOW,
    surfaceContainer = DARK_BLUE,
    surfaceDim = DARK_TEAL,
    surfaceVariant = WIN_BLUE,
    tertiary = BLACK,
    error = LIGHT_RED
)

private val LightColorScheme = lightColorScheme(
    primary = NAVY10,
    onPrimary = WHITE,
    primaryContainer = WHITE,
    onPrimaryContainer = NAVY10,
    inversePrimary = DARK_GRAY,
    secondary = BLUE,
    onSecondary = LOSE_RED,
    surface = NAVY,
    onSurface = WHITE,
    onSurfaceVariant = WHITE,
    outline = NAVY10,
    surfaceTint = YELLOW,
    surfaceContainer = DARK_BLUE,
    surfaceDim = DARK_TEAL,
    surfaceVariant = WIN_BLUE,
    tertiary = BLACK,
    error = LIGHT_RED
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
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    if (!LocalInspectionMode.current) {
        val view = LocalView.current
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = NAVY10.toArgb()
            WindowCompat.setDecorFitsSystemWindows(window, false)
        }
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