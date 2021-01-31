package com.example.myapplication

import androidx.annotation.DrawableRes

data class RecyclerViewItemModel(
    @DrawableRes val image: Int,
    val name: String
)
