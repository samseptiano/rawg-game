package com.example.rawg.data.model

import com.google.gson.annotations.SerializedName

data class GameResponse(
    @field:SerializedName("id")
    var id: Int,
    @field:SerializedName("slug")
    var slug: String,
    @field:SerializedName("name")
    var name: String,
    @field:SerializedName("released")
    var released: String,
    @field:SerializedName("background_image")
    var background_image: String,
    @field:SerializedName("platforms")
    var platforms: PlatformResponse? = null,
)
