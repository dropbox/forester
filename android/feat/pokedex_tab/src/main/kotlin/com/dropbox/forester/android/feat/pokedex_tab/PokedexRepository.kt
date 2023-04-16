package com.dropbox.forester.android.feat.pokedex_tab

import com.dropbox.forester.android.api.RequestResult
import com.dropbox.forester.android.api.entity.Pokemon

interface PokedexRepository {
    suspend fun getPokemon(id: Int): RequestResult<Pokemon>
}