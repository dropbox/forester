package com.dropbox.forester.android.feat.pokedex_tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.dropbox.forester.android.api.entity.Pokemon
import com.dropbox.forester.android.dig.Dig
import com.dropbox.forester.android.dig.DigTypography

@Composable
fun PokedexTab(viewModel: PokedexViewModel = viewModel()) {

    val state = viewModel.state.collectAsState()

    when (val viewState = state.value.viewState) {
        is PokedexViewState.Data -> PokedexData(viewState.pokemon)
        PokedexViewState.Failure -> Text("Failure")
        PokedexViewState.Initial -> Text("Initial")
        PokedexViewState.Loading -> Loading()
    }
}


@Composable
fun Loading() {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.diglett_loading))
    val progress by animateLottieCompositionAsState(composition)
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun PokedexData(pokemon: Pokemon) {
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
            Column(
                modifier = Modifier.background(Dig.Colors.teal.background).fillMaxWidth().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {

                Text(pokemon.name.uppercase(), style = DigTypography.h4, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(8.dp))
                AsyncImage(pokemonImageModel(pokemon.id), pokemon.name, modifier = Modifier.size(208.dp))
                Spacer(Modifier.height(8.dp))
                Text(pokemon.id.toString(), style = DigTypography.h4, fontWeight = FontWeight.Bold)
            }
        }

        item {
            Tiles()
        }
    }
}

@Composable
private fun pokemonImageModel(id: Int): ImageRequest {
    val imageUrl = pokemonImageUrl(id)
    return if (imageUrl.endsWith(".svg")) {
        ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .decoderFactory(SvgDecoder.Factory())
            .build()
    } else {
        ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .build()
    }
}

private fun pokemonImageUrl(id: Int): String =
    "https://unpkg.com/pokeapi-sprites@2.0.2/sprites/pokemon/other/dream-world/${id}.svg"