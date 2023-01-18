package com.example.rawg.data.repository.datasource

import com.example.rawg.base.data.BaseResponse
import com.example.rawg.data.model.GameResponse
import com.example.rawg.data.modelMapper.GameDetail
import com.example.rawg.data.modelMapper.GameItem
import kotlinx.coroutines.flow.Flow

/**
 * @author SamuelSep on 4/20/2021.
 */
interface SampleDataSource {
    suspend fun getGameList(page: Int?, pageCount: Int?, search: String?): BaseResponse<List<GameItem>>
    suspend fun getGameDetail(id: Int): BaseResponse<GameDetail>
}