package com.dropbox.forester.android.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dropbox.forester.android.dig.DigTheme
import com.dropbox.forester.android.dig.color.systemThemeColors
import com.dropbox.pokedex.android.ui.PokedexScaffold
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main

class PokedexMainActivity : ComponentActivity() {

    private val scope: CoroutineScope = CoroutineScope(Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigTheme(systemThemeColors()) {
                PokedexScaffold()
            }
        }
    }
}

