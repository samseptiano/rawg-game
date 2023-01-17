package com.example.rawg.domain.service


import com.example.rawg.base.data.BaseResponse
import com.example.rawg.data.model.GameResponse
import retrofit2.http.GET

/**
 * @author SamuelSep on 4/20/2021.
 */

interface SampleServices {
    @GET(SampleRoutes.GET_ROUTE)
    suspend fun getGameList(): BaseResponse<List<GameResponse>>
}