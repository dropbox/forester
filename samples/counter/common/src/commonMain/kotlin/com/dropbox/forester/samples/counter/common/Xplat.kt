package com.dropbox.forester.samples.counter.common

import com.dropbox.forester.Forest
import com.dropbox.forester.Shape
import com.dropbox.forester.node

@Forest
object Xplat {
    object Counter {
        val CounterScreen = node("xplat.counter.CounterScreen", shape = Shape.Parallelogram)
    }
}