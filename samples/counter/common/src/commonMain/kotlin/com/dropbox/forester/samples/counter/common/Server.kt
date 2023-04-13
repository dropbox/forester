package com.dropbox.forester.samples.counter.common

import com.dropbox.forester.Forest
import com.dropbox.forester.Shape
import com.dropbox.forester.node

@Forest
object Server {
    object Counter {
        val subscribe = node("server.counter.subscribe", Shape.Cloud)
    }
}