package com.dropbox.forester.android.dig


import androidx.compose.material.Typography
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.dropbox.forester.android.dig.color.Colors
import com.dropbox.forester.android.dig.color.LocalColors
import com.dropbox.forester.android.dig.color.asColorScheme


object Dig {
    val Colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val ColorScheme: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = Colors.asColorScheme()

    val Typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}