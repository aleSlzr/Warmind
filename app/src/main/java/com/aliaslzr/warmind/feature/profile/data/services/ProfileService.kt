package com.aliaslzr.warmind.feature.profile.data.services

import com.aliaslzr.warmind.feature.profile.data.network.model.LinkedProfileResponseEntity
import kotlinx.coroutines.flow.Flow

interface ProfileService {

    fun getProfile(): Flow<LinkedProfileResponseEntity>

}
