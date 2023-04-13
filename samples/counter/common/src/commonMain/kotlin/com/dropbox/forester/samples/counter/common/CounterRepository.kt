package com.dropbox.forester.samples.counter.common

import com.dropbox.forester.Directed
import com.dropbox.forester.Node

@Node
@Directed([CounterViewModel::class])
class CounterRepository