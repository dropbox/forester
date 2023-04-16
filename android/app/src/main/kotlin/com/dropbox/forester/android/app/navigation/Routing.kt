package com.dropbox.forester.android.app.navigation


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dropbox.forester.android.feat.account_tab.AccountTab
import com.dropbox.forester.android.feat.pokedex_tab.PokedexTab


@Composable
fun Routing(
    navController: NavHostController,
    innerPadding: PaddingValues,
) {
    NavHost(
        navController = navController, startDestination = Screen.Home.route, modifier = Modifier
            .padding(innerPadding)
    ) {
        composable(Screen.Home.route) {
            PokedexTab()
        }

        composable(Screen.Account.route) {
            AccountTab()
        }
    }
}