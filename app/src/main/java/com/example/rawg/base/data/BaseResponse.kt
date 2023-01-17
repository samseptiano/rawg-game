package com.example.rawg.base.data

import com.google.gson.annotations.SerializedName

class BaseResponse<T>(
    @field:SerializedName("count")
    var count: Int,
    @field:SerializedName("next")
    var next: String,
    @field:SerializedName("previous")
    var previous: String,
    @field:SerializedName("results")
    var results: T,
)