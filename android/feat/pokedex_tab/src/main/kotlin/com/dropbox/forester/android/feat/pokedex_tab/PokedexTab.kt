package com.dropbox.forester.android.feat.pokedex_tab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dropbox.forester.android.dig.Dig

@Composable
fun PokedexTab() {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp).padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("What Pokémon are you looking for?", style = Dig.Typography.h4, fontWeight = FontWeight.Bold)
        }

        item {
            Search()
        }
        item {
            Tiles()
        }
    }
}