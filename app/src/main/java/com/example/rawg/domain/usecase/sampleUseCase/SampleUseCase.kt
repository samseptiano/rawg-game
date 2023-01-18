package com.example.rawg.domain.usecase.sampleUseCase

import com.example.rawg.base.data.BaseResponse
import com.example.rawg.base.data.ResultState
import com.example.rawg.data.repository.datasource.SampleDataSource
import com.example.rawg.base.domain.usecase.BaseUseCase
import com.example.rawg.data.model.GameResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @author SamuelSep on 4/20/2021.
 */
class SampleUseCase @Inject constructor(private val repository: SampleDataSource) :
    BaseUseCase<ResultState<BaseResponse<List<GameResponse>>>, SampleUseCase.Params>() {

    data class Params(val page: Int? = null, val pageSize: Int? = null, val querySearch: String? = null)

    override suspend fun run(params: Params): Flow<ResultState<BaseResponse<List<GameResponse>>>> = flow<ResultState<BaseResponse<List<GameResponse>>>> {
        ResultState.success(repository.getGameList(),"")
    }.catch {
        ResultState.error(null,"enexpected error")
    }

}