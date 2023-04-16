package com.dropbox.pokedex.android.ui

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.dropbox.forester.android.app.navigation.Routing
import com.dropbox.forester.android.app.ui.PokedexBottomBar

@Composable
fun PokedexScaffold() {

    val navController = rememberNavController()
    Scaffold(
        bottomBar = { PokedexBottomBar(navController = navController) }
    ) { innerPadding ->
        Routing(
            navController = navController,
            innerPadding = innerPadding
        )
    }
}