package com.techyourchance.dagger2course.screens.common.viewsmvc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes


abstract class BaseViewMvc<LISTENER>(
    layoutInflater: LayoutInflater,
    parent: ViewGroup?,
    @LayoutRes layoutId: Int
) {

    val rootView: View = layoutInflater.inflate(layoutId, parent, false)
    val context get() = rootView.context


    protected val listeners = HashSet<LISTENER>()

    fun registerListener(listener: LISTENER) {
        listeners.add(listener)
    }

    fun unregisterListener(listener: LISTENER) {
        listeners.remove(listener)
    }

    protected fun <T: View?> findViewById(@IdRes id: Int): T {
        return rootView.findViewById<T>(id)
    }
}