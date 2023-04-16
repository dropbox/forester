package com.dropbox.forester.android.feat.pokedex_tab

import com.dropbox.forester.android.scoping.UserScope
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(UserScope::class)
interface PokedexBindings {
    fun inject(viewModel: PokedexViewModel)
}