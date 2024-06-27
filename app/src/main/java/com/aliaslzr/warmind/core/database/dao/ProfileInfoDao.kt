package com.aliaslzr.warmind.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aliaslzr.warmind.core.database.model.ProfileEntity
import kotlinx.coroutines.flow.Flow

/**
 * DAO for [ProfileEntity]
 */
@Dao
interface ProfileInfoDao {

    /**
     * Returns [Flow] of [ProfileEntity] when [membershipId] is provided
     */
    @Query(value = """
        SELECT * FROM ProfileEntity
        WHERE membershipId = :membershipId
    """)
    fun getProfileInfo(membershipId: String): Flow<ProfileEntity>

    /**
     * Inserts or update [profileEntity] into the DB if they don't exist, and ignores those that do
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreUserProfile(profileEntity: ProfileEntity)

}