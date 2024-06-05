package com.aliaslzr.warmind.feature.profile.data.network

import com.aliaslzr.warmind.feature.profile.data.network.model.LinkedProfileResponseEntity
import com.aliaslzr.warmind.utils.BUNGIE_BASE_URL_API_LINKED_PROFILE
import retrofit2.Response
import retrofit2.http.GET

interface ProfileClient {

    @GET(BUNGIE_BASE_URL_API_LINKED_PROFILE)
    suspend fun getLinkedProfile(): Response<LinkedProfileResponseEntity>

    //@GET(BUNGIE_BASE_URL_API_PROFILE_CHARACTER)
    //suspend fun getProfileCharacter(): Response<ProfileCharacterResponse>

}
