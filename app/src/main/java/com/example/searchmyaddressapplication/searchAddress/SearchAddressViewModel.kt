package com.example.searchmyaddressapplication.searchAddress

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.searchmyaddressapplication.common.logic.BaseViewModel
import com.example.searchmyaddressapplication.searchAddress.helpers.AddressApiService
import com.example.searchmyaddressapplication.model.GeoCodeResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class SearchAddressViewModel : BaseViewModel<SearchAddressData>(
    SearchAddressData()
) {

    init {
        // Simulate data loading
        viewModelScope.launch {
            delay(1000) // Simulate network delay


        }
    }

    fun searchAddress(query: String) {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api-adresse.data.gouv.fr/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val service = retrofit.create(AddressApiService::class.java)
        val call = service.searchAddress(query)

        call.enqueue(object : retrofit2.Callback<GeoCodeResponse> {
            override fun onResponse(
                call: Call<GeoCodeResponse>,
                response: retrofit2.Response<GeoCodeResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()
                    val addresses = response.body()?.features?.take(5)?.map { feature ->
                        "${feature.properties.housenumber}, ${feature.properties.street}, ${feature.properties.postcode} ${feature.properties.city}"
                    } ?: emptyList()
                    Log.d("SearchAddress", "Response successful: $addresses")

//                    onResult(addresses)
                    updateUiState {
                        it.copy(
                            searchResults = addresses
                        )
                    }
                } else {
                    Log.e("SearchAddress", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<GeoCodeResponse>, t: Throwable) {
                Log.e("SearchAddress", "Network failure: ${t.message}", t)
            }
        })
    }


}