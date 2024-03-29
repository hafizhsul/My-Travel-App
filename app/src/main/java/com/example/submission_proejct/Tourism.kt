package com.example.submission_proejct

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tourism(
    val name: String,
    val overview: String,
    val photo: Int,
    val country: String,
    val content: String
): Parcelable
