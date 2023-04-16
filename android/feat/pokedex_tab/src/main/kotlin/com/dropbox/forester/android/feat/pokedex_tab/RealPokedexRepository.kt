package com.dropbox.forester.android.feat.pokedex_tab

import com.dropbox.forester.android.api.PokeApi
import com.dropbox.forester.android.api.RequestResult
import com.dropbox.forester.android.api.entity.Pokemon
import com.dropbox.forester.android.scoping.AppScope
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class RealPokedexRepository @Inject constructor(private val api: PokeApi) : PokedexRepository {
    override suspend fun getPokemon(id: Int): RequestResult<Pokemon> = try {
        RequestResult.Success(api.getPokemon(id))
    } catch (error: Throwable) {
        println("ERROR = $error")
        RequestResult.Failure(error)
    }
}