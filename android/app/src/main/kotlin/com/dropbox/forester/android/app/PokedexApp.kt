package com.dropbox.forester.android.app

import android.app.Application
import com.dropbox.forester.android.app.wiring.AppComponent
import com.dropbox.forester.android.app.wiring.DaggerAppComponent
import com.dropbox.forester.android.scoping.AppScope
import com.dropbox.forester.android.scoping.ComponentHolder
import com.dropbox.forester.android.scoping.SingleIn
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class, boundType = Application::class)
class PokedexApp @Inject constructor() : Application(), ComponentHolder {
    override lateinit var component: AppComponent

    override fun onCreate() {
        component = DaggerAppComponent.factory().create(applicationContext)
        super.onCreate()
    }
}
