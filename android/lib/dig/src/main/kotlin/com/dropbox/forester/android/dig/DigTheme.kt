package com.dropbox.forester.android.dig

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import com.dropbox.forester.android.dig.color.Colors
import com.dropbox.forester.android.dig.color.LocalColorScheme
import com.dropbox.forester.android.dig.color.LocalColors
import com.dropbox.forester.android.dig.color.asColors
import androidx.compose.material3.MaterialTheme as Material3Theme
import androidx.compose.material3.Shapes as Shapes3


private val DigShapes = Shapes(
    small = RoundedCornerShape(0.dp),
    medium = RoundedCornerShape(0.dp),
    large = RoundedCornerShape(0.dp),
)

private val Dig3Shapes = Shapes3(
    extraSmall = RoundedCornerShape(0.dp),
    small = RoundedCornerShape(0.dp),
    medium = RoundedCornerShape(0.dp),
    large = RoundedCornerShape(0.dp),
    extraLarge = RoundedCornerShape(0.dp),
)

@Composable
fun DigTheme(
    colorScheme: ColorScheme = Dig.ColorScheme,
    shapes: Shapes3 = Dig3Shapes,
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(
        LocalColorScheme provides colorScheme,
    ) {
        Material3Theme(colorScheme = colorScheme, shapes = shapes, content = content)
    }
}


@Composable
fun DigTheme(
    colors: Colors,
    shapes: Shapes = DigShapes,
    typography: Typography = DigTypography,
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography
    ) {
        MaterialTheme(
            colors = colors.asColors(),
            shapes = shapes,
            content = content,
            typography = typography
        )
    }
}