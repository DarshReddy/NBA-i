package com.example.round2.assignment.utils.databinding

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.example.round2.assignment.R

class ImageViewBindingAttributes {

    companion object {
        @BindingAdapter("app:imageUrl")
        @JvmStatic
        fun bindImageUrl(view: ImageView, url: String) {
            view.load(url) {
                placeholder(R.drawable.ic_player)
                crossfade(true)
                error(R.drawable.ic_player)
                Log.d("IMAGE LOADING FLOW", "Loading image - $url")
            }
        }
    }
}