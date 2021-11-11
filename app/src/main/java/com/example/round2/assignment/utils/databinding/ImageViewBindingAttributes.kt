package com.example.round2.assignment.utils.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.request.ImageRequest
import com.example.round2.assignment.R

class ImageViewBindingAttributes {

    companion object {
        @BindingAdapter("app:imageUrl")
        @JvmStatic
        fun bindImageUrl(view: ImageView, url: String) {
            view.load(url) {
                listener(
                    onError = { _: ImageRequest, _: Throwable ->
                        view.load(R.drawable.ic_baseline_account_box_24)
                    }
                )
            }
        }
    }
}