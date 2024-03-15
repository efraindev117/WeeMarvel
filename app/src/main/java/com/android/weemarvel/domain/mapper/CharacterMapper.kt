package com.android.weemarvel.domain.mapper

import com.android.weemarvel.common.base.Mapper
import com.android.weemarvel.data.model.CharacterMarvelResponse
import com.android.weemarvel.domain.model.CharacterUiModel
import javax.inject.Inject

class CharacterMapper @Inject constructor() :
    Mapper<CharacterMarvelResponse, List<CharacterUiModel>?> {
    override fun mapFrom(from: CharacterMarvelResponse): List<CharacterUiModel>? {
        return from?.data?.results?.map {
            CharacterUiModel(
                CharacterMarvelResponse.Data.Result(
                    comics = it?.comics,
                    description = it?.description,
                    events = it?.events,
                    id = it?.id,
                    modified = it?.modified,
                    name = it.name,
                    resourceURI = it?.resourceURI,
                    series = it?.series,
                    stories = it?.stories,
                    thumbnail = it?.thumbnail,
                    urls = it?.urls
                )
            )
        }
    }
}