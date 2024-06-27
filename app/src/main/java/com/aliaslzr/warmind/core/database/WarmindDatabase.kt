package com.aliaslzr.warmind.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aliaslzr.warmind.core.database.dao.ProfileInfoDao
import com.aliaslzr.warmind.core.database.model.ProfileEntity

/**
 * Creates a database for Warmind App
 */
@Database(entities = [ProfileEntity::class], version = 1, exportSchema = false)
internal abstract class WarmindDatabase: RoomDatabase() {
    /**
     * Implementations of DAOs for [WarmindDatabase]
     */
    abstract fun profileInfoDao(): ProfileInfoDao
}
