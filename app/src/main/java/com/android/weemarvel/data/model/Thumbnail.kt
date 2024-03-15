package com.android.weemarvel.data.model


import android.os.Parcelable
import androidx.compose.runtime.Immutable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Immutable
data class Thumbnail(
    @SerializedName("extension")
    val extension: String? = "",
    @SerializedName("path")
    val path: String? = ""
):Parcelable {
    fun marvelImage(): String {
        // Verificar si la URL comienza con "http://"
        return if (path?.startsWith("http://") == true) {
            // Reemplazar "http://" con "https://"
            path.replace("http://", "https://") + "." + extension?.trim()
        } else {
            // Si la URL ya comienza con "https://", no se hace ningún cambio
            path + "." + extension?.trim()
        }
    }
}