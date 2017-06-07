package com.gudgie.kotlintest.presenter

import com.gudgie.kotlintest.view.BaseView
import java.lang.ref.WeakReference

/**
 * Created by luke on 06/06/17.
 */
open class BasePresenter<T : BaseView> {

    private var viewRef: WeakReference<T>? = null

    open fun onViewCreated(view: T) {
        viewRef = WeakReference(view)
    }

    open fun onViewDestroyed() {
        if (viewRef != null) {
            viewRef!!.clear()
        }
        viewRef = null
    }

    fun getView(): T? {
        return viewRef?.get()
    }

}