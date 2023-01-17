package com.example.rawg.data.repository.datasource

import com.example.rawg.base.data.BaseResponse
import com.example.rawg.data.model.GameResponse
import kotlinx.coroutines.flow.Flow

/**
 * @author SamuelSep on 4/20/2021.
 */
interface SampleDataSource {
    suspend fun getGameList(): BaseResponse<List<GameResponse>>
}