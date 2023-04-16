package com.dropbox.forester.android.dig

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalTypography: ProvidableCompositionLocal<Typography>
    @ReadOnlyComposable
    @Composable
    get() {
        return staticCompositionLocalOf { DigTypography }
    }