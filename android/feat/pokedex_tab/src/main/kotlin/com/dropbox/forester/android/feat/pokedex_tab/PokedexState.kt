package com.dropbox.forester.android.feat.pokedex_tab

import com.dropbox.forester.android.api.entity.Pokemon

data class PokedexState(
    val viewState: PokedexViewState
)

sealed class PokedexViewState {

    object Initial : PokedexViewState()
    data class Data(
        val pokemon: Pokemon
    ) : PokedexViewState()

    object Loading : PokedexViewState()

    object Failure : PokedexViewState()
}

val InitialState = PokedexState(PokedexViewState.Initial)
val Loading = PokedexState(PokedexViewState.Loading)
val Failure = PokedexState(PokedexViewState.Failure)