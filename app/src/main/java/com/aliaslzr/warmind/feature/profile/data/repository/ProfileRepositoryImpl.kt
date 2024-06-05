package com.aliaslzr.warmind.feature.profile.data.repository

import com.aliaslzr.warmind.feature.profile.data.services.ProfileService
import com.aliaslzr.warmind.feature.profile.domain.mapper.ProfileEntityMapper
import com.aliaslzr.warmind.feature.profile.domain.repository.ProfileRepository
import com.aliaslzr.warmind.feature.profile.ui.model.LinkedProfile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileService: ProfileService
) : ProfileRepository {
    override fun getProfile(): Flow<LinkedProfile> {
        return profileService.getProfile().map {
            ProfileEntityMapper().transform(it)
        }
    }
}