package com.aliaslzr.warmind.feature.profile.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliaslzr.warmind.feature.profile.domain.usecases.GetProfileInformationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class ProfileViewModel @Inject constructor(
    getProfileInformationUseCase: GetProfileInformationUseCase
) : ViewModel() {

    val profileUiState: StateFlow<ProfileUiState> = getProfileInformationUseCase()
        .map { profile ->
            ProfileUiState.Success(profile.response)
        }.onCompletion {
            Log.i("WarmindLog", "ProfileViewModel: Done.")
        }.stateIn(
            scope = viewModelScope,
            initialValue = ProfileUiState.Loading,
            started = SharingStarted.WhileSubscribed(5.seconds.inWholeMilliseconds)
        )
}
