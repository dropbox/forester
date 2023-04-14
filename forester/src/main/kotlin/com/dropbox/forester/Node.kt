package com.dropbox.forester

import kotlin.reflect.KClass


@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class Node(
    val scopes: Array<KClass<out Scope>> = [],
    val shape: Shape = Shape.Rectangle
)
