package com.dropbox.forester.samples.counter.common

import com.dropbox.forester.Node

@Node
interface CounterViewModel {
    val state: Int
}
