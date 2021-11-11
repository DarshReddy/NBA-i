package com.example.round2.assignment.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.round2.assignment.view.OnScrollListener

fun RecyclerView.addScrollDirectionListener(interfaceOnScrollListener: OnScrollListener) {
    this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (dy > 0) {
                interfaceOnScrollListener.setNavBarVisibility(false)
            } else if (dy < 0) {
                interfaceOnScrollListener.setNavBarVisibility(true)
            }
        }
    })
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}