package com.android.weemarvel.data.di

import com.android.weemarvel.data.repository_impl.CharacterRepositoryImp
import com.android.weemarvel.domain.repository.ICharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun providesCharacterRepository(
        impl: CharacterRepositoryImp
    ): ICharacterRepository

}