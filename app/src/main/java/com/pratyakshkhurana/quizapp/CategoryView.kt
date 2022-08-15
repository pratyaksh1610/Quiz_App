package com.pratyakshkhurana.quizapp

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.media.Image
import android.widget.ImageView
import androidx.cardview.widget.CardView

//second screen of recycler view
data class CategoryView(
    val image: Int,
    val category: String,
    val cardImage: Drawable,
    val icon: Drawable
)
