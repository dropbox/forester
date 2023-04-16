package com.dropbox.forester.android.app.wiring

import com.dropbox.forester.android.scoping.AppScope
import com.dropbox.forester.android.scoping.SingleIn
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

@Module
@ContributesTo(AppScope::class)
object AppModule {
    @Provides
    @SingleIn(AppScope::class)
    fun provideHttpClient(): HttpClient {
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                json(json = Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                })
            }
        }
    }
}