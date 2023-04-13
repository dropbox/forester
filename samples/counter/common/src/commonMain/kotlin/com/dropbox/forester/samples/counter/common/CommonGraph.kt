package com.dropbox.forester.samples.counter.common

import com.dropbox.forester.Graph
import com.dropbox.forester.graph

@Graph
class CommonGraph {
    fun provide() = graph {
        directed(Server.Counter.subscribe, CounterApi::class)
        directed(CounterViewModel::class, Xplat.Counter.CounterScreen)
    }
}

