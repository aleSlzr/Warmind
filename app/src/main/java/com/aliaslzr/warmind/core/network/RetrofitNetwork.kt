package com.aliaslzr.warmind.core.network

import com.aliaslzr.warmind.utils.BUNGIE_BASE_URL_API_PLATFORM
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class RetrofitNetwork @Inject constructor(
    client: OkHttpClient,
    gson: Gson
) {
    val providesRetrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl(BUNGIE_BASE_URL_API_PLATFORM)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()

}
