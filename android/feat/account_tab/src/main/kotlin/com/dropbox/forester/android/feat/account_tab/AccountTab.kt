package com.dropbox.forester.android.feat.account_tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dropbox.forester.android.dig.Dig

@Composable
fun AccountTab() {
    Column(modifier = Modifier.fillMaxSize()) {


        Box(modifier = Modifier.height(150.dp)) {
            AsyncImage(
                "https://static.wikia.nocookie.net/pokemon/images/6/69/Ash_and_Professor_Oak.png",
                null,
                modifier = Modifier.fillMaxWidth().height(150.dp),
                contentScale = ContentScale.Crop
            )


            Column(
                modifier = Modifier.fillMaxSize().offset(y = 80.dp).padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    "https://static.wikia.nocookie.net/pokemon/images/2/29/Ash_anime_XY_and_XYZ.png",
                    null,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter,
                    modifier = Modifier.clip(CircleShape).size(150.dp).background(Dig.Colors.secondary)
                )
            }
        }

        Spacer(modifier = Modifier.height(80.dp))

        Column(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {

            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Ash Ketchum", style = Dig.Typography.h4, fontWeight = FontWeight.Black)
                Text("Pokémon Champion", style = Dig.Typography.h6, fontWeight = FontWeight.Black)

            }

            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(12.dp)) {

                item {
                    Column(
                        modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(Dig.Colors.secondary)
                            .fillMaxWidth().padding(12.dp)
                    ) {
                        Text("About", style = Dig.Typography.h6, fontWeight = FontWeight.Black)
                        Text(ASH_ABOUT, style = Dig.Typography.body1, maxLines = 5)
                    }
                }

                item {
                    Column(
                        modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(Dig.Colors.secondary)
                            .fillMaxWidth().padding(12.dp)
                    ) {
                        Text("Intro", style = Dig.Typography.h6, fontWeight = FontWeight.Black)
                    }
                }

                item {
                    Column(
                        modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(Dig.Colors.secondary)
                            .fillMaxWidth().padding(12.dp)
                    ) {
                        Text("Photos", style = Dig.Typography.h6, fontWeight = FontWeight.Black)
                    }
                }

                item {
                    Column(
                        modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(Dig.Colors.secondary)
                            .fillMaxWidth().padding(12.dp)
                    ) {
                        Text("Friends", style = Dig.Typography.h6, fontWeight = FontWeight.Black)
                    }
                }
            }


        }


    }
}


private const val ASH_ABOUT =
    "Ash Ketchum is the main protagonist of Pokémon the Series. He is a 10-year-old Pokémon Trainer from Pallet Town in the Kanto region who has always dreamed of becoming the world's greatest Pokémon Master. The first human character to be introduced in the series, he is the winner of the Orange League and Kanto Battle Frontier and also the Alola region's Pokémon Champion, receiving the title after winning its first Pokémon League Conference. He is also one of the 8 best trainers in the Pokémon World after defeating Raihan and reached Master Class in the World Coronation Series. Ash became the Monarch (World Champion) and became The Strongest Pokémon Trainer in the Pokémon World after winning The Masters Eight Tournament defeating the Previously Monarch Leon."