package com.aliaslzr.warmind.core.di

import com.aliaslzr.warmind.feature.profile.data.reposotory.ProfileRepositoryImpl
import com.aliaslzr.warmind.feature.profile.data.services.ProfileService
import com.aliaslzr.warmind.feature.profile.data.services.ProfileServiceImpl
import com.aliaslzr.warmind.feature.profile.domain.repository.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProfileModule {

    @Binds
    abstract fun bindProfileRepository(profileRepositoryImpl: ProfileRepositoryImpl): ProfileRepository

    @Binds
    abstract fun bindProfileService(profileServiceImpl: ProfileServiceImpl): ProfileService

}
