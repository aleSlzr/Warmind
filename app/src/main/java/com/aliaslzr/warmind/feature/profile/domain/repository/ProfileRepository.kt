package com.aliaslzr.warmind.feature.profile.domain.repository

import com.aliaslzr.warmind.feature.profile.ui.model.LinkedProfile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    fun getProfile(): Flow<LinkedProfile>

}
