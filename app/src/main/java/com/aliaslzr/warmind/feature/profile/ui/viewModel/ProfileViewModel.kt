package com.aliaslzr.warmind.feature.profile.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliaslzr.warmind.feature.profile.domain.usecases.GetProfileInformationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileInformationUseCase: GetProfileInformationUseCase
) : ViewModel() {

    fun fetchUserProfile() {
        viewModelScope.launch {
            getProfileInformationUseCase.invoke()
                .catch {
                    Log.e("WarmindError", it.message.toString())
                }
                .collect { profile ->
                    Log.d("WarmindSuccess", profile.errorStatus.toString())
                }
        }
    }
}
