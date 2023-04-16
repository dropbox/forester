package com.dropbox.forester.android.app.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dropbox.forester.android.app.navigation.BottomTabs
import com.dropbox.forester.android.app.navigation.Screen
import com.dropbox.forester.android.dig.Dig
import com.dropbox.forester.android.dig.color.systemThemeColors

@Composable
fun PokedexBottomBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val colors = systemThemeColors()

    fun isSelected(tab: Screen) = currentDestination?.hierarchy?.any { it.route == tab.route } == true
    BottomAppBar(
        containerColor = if (Dig.Colors.isLight) Color.White else Color.Black.copy(alpha = 0.4f),
        actions = {
            BottomTabs.forEach { tab ->

                Box {

                    val icon = if (isSelected(tab)) tab.iconSelected else tab.iconNotSelected

                    IconButton(onClick = {
                        navController.navigate(tab.route)
                    }) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = colors.standard.text
                        )
                    }
                }
            }
        }
    )
}