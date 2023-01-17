package com.example.rawg.domain.service


import com.example.rawg.data.model.ProvinceResponseItem
import retrofit2.http.GET

/**
 * @author SamuelSep on 4/20/2021.
 */

interface SampleServices {
    @GET(SampleRoutes.GET_ROUTE)
    suspend fun getProvinceList(
    ): List<ProvinceResponseItem>

}