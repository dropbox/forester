package com.dropbox.forester

import kotlin.reflect.KClass

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class Undirected(
    val nodes: Array<KClass<*>>
)