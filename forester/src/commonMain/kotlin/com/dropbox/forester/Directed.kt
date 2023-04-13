package com.dropbox.forester

import kotlin.reflect.KClass

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class Directed(
    val nodes: Array<KClass<*>>
)