package com.appsyncsample.utils.listeners

import android.view.View

interface OnViewClickListener {
    fun <T> onItemClick(view: View, data: T) {
        /*not implemented*/
    }

    fun <T> onItemClick(view: View, position: Int, data: T) {
        /*not implemented*/
    }

    fun <T> onItemLongClick(view: View, data: T) {
        /*not implemented*/
    }

    fun <T> onItemLongClick(view: View, position: Int, data: T) {
        /*not implemented*/
    }
}