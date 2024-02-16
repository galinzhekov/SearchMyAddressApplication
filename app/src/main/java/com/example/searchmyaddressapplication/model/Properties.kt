package com.example.searchmyaddressapplication.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Properties(
    val housenumber: String,
    val postcode: String,
    val city: String,
    val street: String
)