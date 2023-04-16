package com.dropbox.forester.android.feat.pokedex_tab

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.dropbox.forester.android.api.RequestResult
import com.dropbox.forester.android.scoping.ComponentHolder
import com.dropbox.forester.android.scoping.bindings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokedexViewModel @Inject constructor(application: Application) : AndroidViewModel(application), ComponentHolder {

    override val component = application.bindings<PokedexComponent.ParentBindings>().pokedexComponentBuilder().create()

    @Inject
    lateinit var pokedexRepository: PokedexRepository

    private val stateFlow = MutableStateFlow<PokedexState>(InitialState)
    val state: StateFlow<PokedexState> = stateFlow

    init {
        bindings<PokedexBindings>().inject(this)

        viewModelScope.launch {
            stateFlow.value = Loading
            when (val result = pokedexRepository.getPokemon(1)) {
                is RequestResult.Failure -> stateFlow.value = Failure
                is RequestResult.Success -> stateFlow.value = PokedexState(PokedexViewState.Data(result.data))
            }
        }
    }
}