package com.example.rawg.domain.usecase.sampleUseCase

import com.example.rawg.base.data.BaseResponse
import com.example.rawg.base.data.ResultState
import com.example.rawg.data.repository.datasource.SampleDataSource
import com.example.rawg.base.domain.usecase.BaseUseCase
import com.example.rawg.data.modelMapper.GameDetail
import com.example.rawg.data.modelMapper.GameItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @author SamuelSep on 4/20/2021.
 */
class GameDetailUseCase @Inject constructor(private val repository: SampleDataSource) :
    BaseUseCase<ResultState<BaseResponse<GameDetail>>, GameDetailUseCase.Params>() {

    data class Params(val id: Int)

    override suspend fun run(params: Params): Flow<ResultState<BaseResponse<GameDetail>>> = flow<ResultState<BaseResponse<GameDetail>>> {
        ResultState.success(repository.getGameDetail(params.id),"")
    }.catch {
        ResultState.error(null,"enexpected error")
    }

}