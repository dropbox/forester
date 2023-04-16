package com.dropbox.forester.android.scoping

import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel


inline fun <reified T : Any> Context.bindings() = bindings(T::class.java)
inline fun <reified T : Any> Fragment.bindings() = bindings(T::class.java)

inline fun <reified T : Any> AndroidViewModel.bindings() =
    ((this as? ComponentHolder)?.component as? T) ?: getApplication<Application>().bindings(T::class.java)


@PublishedApi
internal fun <T : Any> Context.bindings(klass: Class<T>): T {
    return generateSequence(this) { (it as? ContextWrapper)?.baseContext }
        .plus(applicationContext)
        .filterIsInstance<ComponentHolder>()
        .map { it.component }
        .flatMap { if (it is Collection<*>) it else listOf(it) }
        .filterIsInstance(klass)
        .firstOrNull()
        ?: error("No bindings for ${klass.name}")
}

@PublishedApi
internal fun <T : Any> Fragment.bindings(klass: Class<T>): T {
    return generateSequence(this, Fragment::getParentFragment)
        .filterIsInstance<ComponentHolder>()
        .map { it.component }
        .flatMap { if (it is Collection<*>) it else listOf(it) }
        .filterIsInstance(klass)
        .firstOrNull()
        ?: requireActivity().bindings(klass)
}