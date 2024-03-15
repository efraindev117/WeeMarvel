package com.android.weemarvel.domain.usescase

import com.android.weemarvel.common.Resource
import com.android.weemarvel.common.map
import com.android.weemarvel.domain.mapper.CharacterMapper
import com.android.weemarvel.domain.model.CharacterUiModel
import com.android.weemarvel.domain.repository.ICharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CharacterUsesCase @Inject constructor(
    private val characterRepository: ICharacterRepository,
    private val characterMapper: CharacterMapper
) {
    suspend fun getCharacters(): Flow<Resource<List<CharacterUiModel>?>> {
        return characterRepository.getCharacters().map { result ->
            result.map {
                characterMapper.mapFrom(it)
            }
        }
    }

    suspend fun getCharactersByName(): Flow<Resource<List<CharacterUiModel>?>> {
        return characterRepository.getCharactersByName().map { result ->
            result.map {
                characterMapper.mapFrom(it)
            }
        }
    }
}