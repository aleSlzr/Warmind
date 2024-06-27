package com.aliaslzr.warmind.core.di

import com.aliaslzr.warmind.core.database.WarmindDatabase
import com.aliaslzr.warmind.core.database.dao.ProfileInfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Provides DAOs for [WarmindDatabase]
 */
@Module
@InstallIn(SingletonComponent::class)
internal object DaosModule {
    /**
     * DAO for [ProfileInfoDao]
     */
    @Provides
    fun providesProfileInfoDao(
        warmindDatabase: WarmindDatabase
    ): ProfileInfoDao = warmindDatabase.profileInfoDao()

    /**
     * Add different DAOs here
     */
}