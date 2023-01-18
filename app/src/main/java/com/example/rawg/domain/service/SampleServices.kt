package com.example.rawg.domain.service


import com.example.rawg.base.data.BaseResponse
import com.example.rawg.data.model.GameResponse
import com.example.rawg.utils.CONSTANTS
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author SamuelSep on 4/20/2021.
 */

interface SampleServices {
    @GET(Routes.GET_LIST_GAMES)
    suspend fun getGameList(
        @Query("key") apikey: String = CONSTANTS.API_KEY,
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null,
        @Query("search") search: String? = null
    ): BaseResponse<List<GameResponse>>
}