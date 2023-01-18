package com.example.rawg.domain.usecase.sampleUseCase

import com.example.rawg.base.data.ResponseWrapper
import com.example.rawg.base.data.ResultState
import com.example.rawg.data.repository.datasource.SampleDataSource
import com.example.rawg.base.domain.usecase.BaseUseCase
import com.example.rawg.data.modelMapper.GameItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @author SamuelSep on 4/20/2021.
 */
class GameListUseCase @Inject constructor(private val repository: SampleDataSource) :
    BaseUseCase<ResultState<ResponseWrapper<List<GameItem?>?>>, GameListUseCase.Params>() {

    data class Params(val page: Int? = null, val pageSize: Int? = null, val querySearch: String? = null)

    override suspend fun run(params: Params): Flow<ResultState<ResponseWrapper<List<GameItem?>?>>> {
       return repository.getGameList(params.page, params.pageSize, params.querySearch)
    }

}