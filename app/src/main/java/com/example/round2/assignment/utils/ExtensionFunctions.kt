package com.example.round2.assignment.utils

import android.content.res.Configuration
import android.content.res.Resources
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
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

fun Resources.toggleTheme() {
    when {
        AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else -> {
            val nightModeFlags: Int = configuration.uiMode and
                    Configuration.UI_MODE_NIGHT_MASK
            when (nightModeFlags) {
                Configuration.UI_MODE_NIGHT_YES -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                Configuration.UI_MODE_NIGHT_NO -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
            }
        }
    }
}