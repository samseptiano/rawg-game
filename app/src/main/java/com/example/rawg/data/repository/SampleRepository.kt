package com.example.rawg.data.repository

import com.example.rawg.base.data.BaseResponse
import com.example.rawg.data.model.GameResponse
import com.example.rawg.domain.service.SampleServices
import com.example.rawg.data.repository.datasource.SampleDataSource
import javax.inject.Inject

/**
 * @author SamuelSep on 4/20/2021.
 */
class SampleRepository @Inject constructor(private val sampleServices: SampleServices) : SampleDataSource {

    override suspend fun getGameList(): BaseResponse<List<GameResponse>> {
        return sampleServices.getGameList()
    }


}