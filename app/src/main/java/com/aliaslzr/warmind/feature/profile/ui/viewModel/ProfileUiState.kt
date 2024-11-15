package com.aliaslzr.warmind.feature.profile.ui.viewModel

import com.aliaslzr.warmind.feature.profile.ui.model.Response

sealed class ProfileUiState {
    data object Loading : ProfileUiState()

    data class Success(
        val profile: Response,
    ) : ProfileUiState()
}