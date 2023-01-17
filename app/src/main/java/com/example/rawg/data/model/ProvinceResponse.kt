package com.example.rawg.data.model

import com.google.gson.annotations.SerializedName

data class ProvinceResponse(

    @field:SerializedName("ProvinceResponse")
    var provinceResponse: List<ProvinceResponseItem?>? = null
)

data class ProvinceResponseItem(

    @field:SerializedName("nama")
    var nama: String? = null,

    @field:SerializedName("id")
    var id: String? = null
)
