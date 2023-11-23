package com.example.foodie.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class dataRestaurant(
    val name: String,
    val minutes: String,
    val miles: String,
    val star: String,
    val image: Int
): Parcelable

