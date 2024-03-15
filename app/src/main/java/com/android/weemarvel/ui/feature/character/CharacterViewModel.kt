package com.android.weemarvel.ui.feature.character

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.weemarvel.common.doOnFailure
import com.android.weemarvel.common.doOnLoading
import com.android.weemarvel.common.doOnSuccess
import com.android.weemarvel.data.model.CharacterMarvelResponse
import com.android.weemarvel.data.model.Comics
import com.android.weemarvel.domain.usescase.CharacterUsesCase
import com.android.weemarvel.ui.feature.character.states.CharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterUsesCase: CharacterUsesCase
) : ViewModel() {
    private val _characterResponse: MutableState<CharacterState> = mutableStateOf(CharacterState())
    val characterResponse: State<CharacterState> = _characterResponse

    private val _characterResponseByName: MutableState<CharacterState> =
        mutableStateOf(CharacterState())
    val characterResponseByName: State<CharacterState> = _characterResponseByName


    init {
        getCharacters()
        getCharactersByName()
    }

    private fun getCharacters() = viewModelScope.launch {
        characterUsesCase.getCharacters()
            .doOnSuccess {
                _characterResponse.value = CharacterState(it!!)
            }
            .doOnFailure {
                _characterResponse.value = CharacterState(error = it.toString())
            }
            .doOnLoading {
                _characterResponse.value = CharacterState(isLoading = true)
            }.collect()
    }

    private fun getCharactersByName() = viewModelScope.launch {
        characterUsesCase.getCharactersByName()
            .doOnSuccess {
                _characterResponseByName.value = CharacterState(it!!)
            }
            .doOnFailure {
                _characterResponseByName.value = CharacterState(error = it.toString())
            }
            .doOnLoading {
                _characterResponseByName.value = CharacterState(isLoading = true)
            }.collect()
    }
}