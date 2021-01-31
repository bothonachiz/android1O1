package com.example.myapplication.navigate

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TwoModel(
    val text: String
) : Parcelable