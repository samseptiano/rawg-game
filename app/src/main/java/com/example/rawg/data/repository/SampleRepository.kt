package com.example.rawg.data.repository

import com.example.rawg.base.data.BaseResponse
import com.example.rawg.data.model.GameResponse
import com.example.rawg.data.modelMapper.GameDetail
import com.example.rawg.data.modelMapper.GameItem
import com.example.rawg.domain.service.SampleServices
import com.example.rawg.data.repository.datasource.SampleDataSource
import javax.inject.Inject

/**
 * @author SamuelSep on 4/20/2021.
 */
class SampleRepository @Inject constructor(private val sampleServices: SampleServices) : SampleDataSource {

    override suspend fun getGameList(page: Int?, pageCount: Int?, search: String?): BaseResponse<List<GameItem>> {
        val gameList = sampleServices.getGameList(page = page, pageSize = pageCount, search = search)

        return BaseResponse(
            gameList.count,
            gameList.next,
            gameList.previous,
            gameList.results.map { it.toGameItem() }
        )
    }

    override suspend fun getGameDetail(id: Int): BaseResponse<GameDetail> {
        val gameDetail = sampleServices.getGameDetail(gameId = id)

        return BaseResponse(
            gameDetail.count,
            gameDetail.next,
            gameDetail.previous,
            gameDetail.results.toGameDetail()
        )
    }

}