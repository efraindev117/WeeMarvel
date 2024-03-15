package com.android.weemarvel.data.model


import android.os.Parcelable
import androidx.compose.runtime.Immutable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Immutable
data class Url(
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("url")
    val url: String? = ""
) : Parcelable