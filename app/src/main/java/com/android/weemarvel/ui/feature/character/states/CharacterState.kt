package com.android.weemarvel.ui.feature.character.states

import com.android.weemarvel.domain.model.CharacterUiModel

data class CharacterState(
    val data: List<CharacterUiModel>? = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)