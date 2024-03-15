package com.android.weemarvel.data.model


import android.os.Parcelable
import androidx.compose.runtime.Immutable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Immutable
data class CharacterMarvelResponse(
    @SerializedName("attributionHTML")
    val attributionHTML: String?,
    @SerializedName("attributionText")
    val attributionText: String?,
    @SerializedName("code")
    val code: Int?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("data")
    val data: Data?,
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("status")
    val status: String?
) : Parcelable {
    @Parcelize
    @Immutable
    data class Data(
        @SerializedName("count")
        val count: Int? = 0,
        @SerializedName("limit")
        val limit: Int? = 0,
        @SerializedName("offset")
        val offset: Int? = 0,
        @SerializedName("results")
        val results: List<Result>?,
        @SerializedName("total")
        val total: Int? = 0
    ) : Parcelable {
        @Parcelize
        @Immutable
        data class Result(
            @SerializedName("comics")
            val comics: Comics?,
            @SerializedName("description")
            val description: String? = "",
            @SerializedName("events")
            val events: Events?,
            @SerializedName("id")
            val id: Int? = 0,
            @SerializedName("modified")
            val modified: String? = "",
            @SerializedName("name")
            val name: String? = "",
            @SerializedName("resourceURI")
            val resourceURI: String? = "",
            @SerializedName("series")
            val series: Series?,
            @SerializedName("stories")
            val stories: Stories?,
            @SerializedName("thumbnail")
            val thumbnail: Thumbnail?,
            @SerializedName("urls")
            val urls: List<Url>? = emptyList()
        ) : Parcelable
    }
}