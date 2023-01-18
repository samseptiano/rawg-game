package com.example.rawg.data.repository

import com.example.rawg.base.apihandler.ApiHandler
import com.example.rawg.base.data.ResponseWrapper
import com.example.rawg.base.data.ResultState
import com.example.rawg.data.modelMapper.GameDetail
import com.example.rawg.data.modelMapper.GameItem
import com.example.rawg.domain.service.SampleServices
import com.example.rawg.data.repository.datasource.SampleDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @author SamuelSep on 4/20/2021.
 */
class SampleDataSourceImpl @Inject constructor(private val sampleServices: SampleServices) :
    SampleDataSource {

    override suspend fun getGameList(
        page: Int?,
        pageCount: Int?,
        search: String?
    ): Flow<ResultState<ResponseWrapper<List<GameItem?>?>>> = flow {
        ApiHandler.handleApi {
            sampleServices.getGameList(page = page, pageSize = pageCount, search = search)
        }.apply {
            emit(ResultState.success(ResponseWrapper(
                this?.count ?: 0,
                this?.next ?: "",
                this?.previous ?: "",
                this?.results?.map { it?.toGameItem() }
            )))
        }
    }.catch { e ->
        ResultState.error(null, e.toString())
    }


    override suspend fun getGameDetail(id: Int): Flow<ResultState<ResponseWrapper<GameDetail>>> =
        flow {
            ApiHandler.handleApi {
                sampleServices.getGameDetail(gameId = id)
            }.apply {
                emit(
                    ResultState.success(
                        ResponseWrapper(
                            this?.count ?: 0,
                            this?.next ?: "",
                            this?.previous ?: "",
                            this?.results!!.toGameDetail()
                        )
                    )
                )
            }

        }.catch { e ->
            ResultState.error(null, e.toString())
        }

}