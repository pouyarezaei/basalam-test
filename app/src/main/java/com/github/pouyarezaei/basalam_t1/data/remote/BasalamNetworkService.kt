package com.github.pouyarezaei.basalam_t1.data.remote

import com.github.pouyarezaei.basalam_t1.data.dto.InformationDto
import retrofit2.http.GET
import retrofit2.http.Query

interface BasalamNetworkService {
    @GET("intern.android/")
    suspend fun getInformation(@Query("kind") query: String): InformationDto
}