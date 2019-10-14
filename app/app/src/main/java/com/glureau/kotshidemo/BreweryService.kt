package com.glureau.kotshidemo

import com.glureau.kotshidemo.dto.*
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET

interface BreweryService {
    @GET("breweries")
    fun breweriesJava(): Single<List<BreweryJava>>
}