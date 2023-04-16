package com.dropbox.forester.android.dig.color

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalColors: ProvidableCompositionLocal<Colors>
    @ReadOnlyComposable
    @Composable
    get() {
        val colors = systemThemeColors()
        return staticCompositionLocalOf { colors }
    }

internal val LocalColorScheme: ProvidableCompositionLocal<ColorScheme>
    @ReadOnlyComposable
    @Composable
    get() {
        val colorScheme = systemColorScheme()
        return staticCompositionLocalOf { colorScheme }
    }