package com.example.searchmyaddressapplication.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Feature(
    val properties: Properties
)