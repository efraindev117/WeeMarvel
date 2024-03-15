package com.android.weemarvel.data.repository_impl

import com.android.weemarvel.common.Resource
import com.android.weemarvel.common.base.BaseRepository
import com.android.weemarvel.data.model.CharacterMarvelResponse
import com.android.weemarvel.data.network.IApiService
import com.android.weemarvel.domain.repository.ICharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepositoryImp @Inject constructor(
    private val apiService: IApiService
) : BaseRepository(), ICharacterRepository {
    override suspend fun getCharacters(): Flow<Resource<CharacterMarvelResponse>> = safeApiCall {
        apiService.getCharacters()
    }

    override suspend fun getCharactersByName(): Flow<Resource<CharacterMarvelResponse>> = safeApiCall {
        apiService.getCharactersByName()
    }
}