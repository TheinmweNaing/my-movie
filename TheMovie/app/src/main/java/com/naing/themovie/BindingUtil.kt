package com.naing.themovie

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object BindingUtil {

    @BindingAdapter("app:path")
    fun setImageUri(imageView: AppCompatImageView, imageFilePath: String?) {
        if (imageFilePath != null && imageFilePath.isNotEmpty()) {
            Picasso.get().load(imageFilePath).into(imageView)
        }
    }
}