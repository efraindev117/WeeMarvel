package com.android.weemarvel.data.network

import com.android.weemarvel.common.contants.Constants.CHARACTER_PATH
import com.android.weemarvel.common.contants.Constants.ORDER_BY
import com.android.weemarvel.common.contants.Constants.ORDER_BY_VALUE
import com.android.weemarvel.data.model.CharacterMarvelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {

    @GET(CHARACTER_PATH)
    suspend fun getCharacters(): Response<CharacterMarvelResponse>

    @GET(CHARACTER_PATH)
    suspend fun getCharactersByName(
        @Query(ORDER_BY) orderBy: String = ORDER_BY_VALUE
    ): Response<CharacterMarvelResponse>
}