package com.aliaslzr.warmind.core.di

import android.content.Context
import androidx.room.Room
import com.aliaslzr.warmind.core.database.WarmindDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Provides [WarmindDatabase]
 */
@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    /**
     * Instance of [WarmindDatabase]
     */
    @Provides
    @Singleton
    fun providesWarmindDatabase(
        @ApplicationContext context: Context
    ): WarmindDatabase = Room
        .databaseBuilder(
            context = context,
            klass = WarmindDatabase::class.java,
            name = "warmind_database",
        ).build()
}