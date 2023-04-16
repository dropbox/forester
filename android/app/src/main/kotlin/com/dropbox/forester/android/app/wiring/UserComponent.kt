package com.dropbox.forester.android.app.wiring

import com.dropbox.forester.android.api.User
import com.dropbox.forester.android.scoping.AppScope
import com.dropbox.forester.android.scoping.SingleIn
import com.dropbox.forester.android.scoping.UserScope
import com.squareup.anvil.annotations.ContributesSubcomponent
import com.squareup.anvil.annotations.ContributesTo
import dagger.BindsInstance

@SingleIn(UserScope::class)
@ContributesSubcomponent(scope = UserScope::class, parentScope = AppScope::class)
interface UserComponent {
    @ContributesSubcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance user: User
        ): UserComponent
    }

    @ContributesTo(AppScope::class)
    interface ParentBindings {
        fun userComponentFactory(): Factory
    }
}