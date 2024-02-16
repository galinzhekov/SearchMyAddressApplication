package com.example.searchmyaddressapplication.searchAddress.helpers

import android.util.Log
import com.example.searchmyaddressapplication.model.GeoCodeResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface AddressApiService {
    @GET("search/")
    fun searchAddress(
        @Query("q") query: String,
        @Query("type") type: String = "housenumber"
    ): Call<GeoCodeResponse>
}




