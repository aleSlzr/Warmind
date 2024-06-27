package com.aliaslzr.warmind.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProfileEntity(
    @PrimaryKey
    val membershipId: String,
    val profileName: String,
    val fullProfileName: String,
    val imageUrl: String,
)
