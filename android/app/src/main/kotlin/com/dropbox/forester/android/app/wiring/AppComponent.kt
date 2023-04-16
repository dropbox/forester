package com.dropbox.forester.android.app.wiring

import android.content.Context
import com.dropbox.forester.android.scoping.AppScope
import com.dropbox.forester.android.scoping.SingleIn
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component

@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance applicationContext: Context,
        ): AppComponent
    }
}