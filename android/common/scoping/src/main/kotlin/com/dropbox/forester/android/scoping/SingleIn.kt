package com.dropbox.forester.android.scoping

import javax.inject.Scope
import kotlin.reflect.KClass

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SingleIn(val scope: KClass<*>)