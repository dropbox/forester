package com.dropbox.forester.android.feat.pokedex_tab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dropbox.forester.android.dig.color.*

@Composable
fun Tiles() {
    Column {


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(vertical = 10.dp),
        ) {
            Tile(
                modifier = Modifier.weight(1f),
                title = "Pokedex",
                brush = Brush.linearGradient(listOf(Red300, Red500)),
                painter = painterResource(R.drawable.pokeball),
                onClick = {}
            )


        }


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(vertical = 10.dp),
        ) {

            Tile(
                modifier = Modifier.weight(1f),
                title = "Moves",
                brush = Brush.linearGradient(listOf(Yellow300, Yellow500)),
                painter = painterResource(R.drawable.bolt),
                onClick = {}
            )
        }


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            Tile(
                modifier = Modifier.weight(1f),
                title = "Evolutions",
                brush = Brush.linearGradient(listOf(Purple300, Purple500)),
                painter = painterResource(R.drawable.helix),
                onClick = {}
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(vertical = 10.dp)
        ) {


            Tile(
                modifier = Modifier.weight(1f),
                title = "Locations",
                brush = Brush.linearGradient(listOf(Blue300, Blue500)),
                painter = painterResource(R.drawable.pin),
                onClick = {}
            )
        }

    }
}