package com.aliaslzr.warmind.feature.profile.data.services

import com.aliaslzr.warmind.feature.profile.data.network.ProfileClient
import com.aliaslzr.warmind.feature.profile.data.network.model.LinkedProfileResponseEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProfileServiceImpl @Inject constructor(
    private val profileClient: ProfileClient
) : ProfileService {
    override fun getProfile(): Flow<LinkedProfileResponseEntity> = flow {
        val response = profileClient.getLinkedProfile()
        response.body()?.let { emit(it) }
    }
}
