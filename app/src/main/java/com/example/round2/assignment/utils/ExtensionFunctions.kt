package com.example.round2.assignment.utils

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.transition.Fade
import androidx.transition.Slide
import androidx.transition.Transition
import androidx.transition.TransitionManager

fun View.slideVisibility(visibility: Boolean, durationTime: Long = 500) {
    val transition = Slide(Gravity.BOTTOM)
    transition.apply {
        duration = durationTime
        addTarget(this@slideVisibility)
    }
    TransitionManager.beginDelayedTransition(this.parent as ViewGroup, transition)
    this.isVisible = visibility
}

fun View.fadeVisibility(visibility: Int, duration: Long = 200) {
    val transition: Transition = Fade()
    transition.duration = duration
    transition.addTarget(this)
    TransitionManager.beginDelayedTransition(this.parent as ViewGroup, transition)
    this.visibility = visibility
}