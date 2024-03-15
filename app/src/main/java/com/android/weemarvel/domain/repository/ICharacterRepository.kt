package com.android.weemarvel.domain.repository

import com.android.weemarvel.common.Resource
import com.android.weemarvel.data.model.CharacterMarvelResponse
import kotlinx.coroutines.flow.Flow

interface ICharacterRepository {
    suspend fun getCharacters(): Flow<Resource<CharacterMarvelResponse>>
    suspend fun getCharactersByName(): Flow<Resource<CharacterMarvelResponse>>
}