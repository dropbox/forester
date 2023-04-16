package com.dropbox.forester.android.dig.color

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable


@ReadOnlyComposable
@Composable
fun darkColors() = PigColors.Dark.create()

@ReadOnlyComposable
@Composable
fun systemThemeColors() = if (isSystemInDarkTheme()) PigColors.Dark.create() else PigColors.Light.create()

@ReadOnlyComposable
@Composable
fun systemColorScheme() = systemThemeColors().asColorScheme()

@ReadOnlyComposable
@Composable
fun darkColorScheme() = darkColors().asColorScheme()
