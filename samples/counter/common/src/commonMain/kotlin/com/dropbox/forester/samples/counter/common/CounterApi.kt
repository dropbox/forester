package com.dropbox.forester.samples.counter.common

import com.dropbox.forester.Node
import com.dropbox.forester.Undirected

@Node
@Undirected([CounterRepository::class])
class CounterApi {
    suspend fun subscribe(): Int = 0
    fun update(count: Int): Unit {}
}