package com.dropbox.forester.android.feat.pokedex_tab

import com.dropbox.forester.android.scoping.AppScope
import com.dropbox.forester.android.scoping.SingleIn
import com.dropbox.forester.android.scoping.UserScope
import com.squareup.anvil.annotations.ContributesSubcomponent
import com.squareup.anvil.annotations.ContributesTo


@SingleIn(UserScope::class)
@ContributesSubcomponent(scope = UserScope::class, parentScope = AppScope::class)
interface PokedexComponent {
    @ContributesSubcomponent.Factory
    interface Factory {
        fun create(): PokedexComponent
    }

    @ContributesTo(AppScope::class)
    interface ParentBindings {
        fun pokedexComponentBuilder(): Factory
    }
}