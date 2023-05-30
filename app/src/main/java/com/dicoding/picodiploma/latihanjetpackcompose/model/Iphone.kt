package com.dicoding.picodiploma.latihanjetpackcompose.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Iphone (
    val id: String,
    val name: String,
    val description: String,
    val photoUrl: String
):Parcelable
