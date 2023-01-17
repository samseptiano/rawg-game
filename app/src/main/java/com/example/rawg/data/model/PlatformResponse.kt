package com.example.rawg.data.model

import com.google.gson.annotations.SerializedName

data class PlatformResponse(
    @field:SerializedName("platform")
    var platform: PlatformItemResponse,
    @field:SerializedName("release_at")
    var releaseAt: String,
    @field:SerializedName("requirements")
    var requirements: PlatformRequirementResponse,
)

data class PlatformItemResponse(
    @field:SerializedName("id")
    var id: Int,
    @field:SerializedName("name")
    var name: String
)

data class PlatformRequirementResponse(
    @field:SerializedName("minimum")
    var minimum: String,
    @field:SerializedName("recommended")
    var recommended: String
)
