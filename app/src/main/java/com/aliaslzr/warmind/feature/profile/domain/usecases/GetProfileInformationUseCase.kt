package com.aliaslzr.warmind.feature.profile.domain.usecases

import com.aliaslzr.warmind.feature.profile.domain.repository.ProfileRepository
import javax.inject.Inject

class GetProfileInformationUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    operator fun invoke() = profileRepository.getProfile()
}