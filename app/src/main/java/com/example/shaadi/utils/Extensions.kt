package com.example.shaadi.utils

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

fun ImageView.loadImage(context: Context, imageUrl: String, placeHolderColorId: Int) {
    Glide.with(context).load(imageUrl)
        .placeholder(ColorDrawable(ContextCompat.getColor(context, placeHolderColorId)))
        .into(this)
}

fun Fragment.snackbar(text: String) {
    Snackbar.make(
        requireView(),
        text,
        Snackbar.LENGTH_LONG
    ).show()
}