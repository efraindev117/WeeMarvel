package com.android.weemarvel.domain.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import com.android.weemarvel.data.model.CharacterMarvelResponse
import kotlinx.parcelize.Parcelize

@Parcelize
@Immutable
data class CharacterUiModel(
    val resutls: CharacterMarvelResponse.Data.Result
) : Parcelable