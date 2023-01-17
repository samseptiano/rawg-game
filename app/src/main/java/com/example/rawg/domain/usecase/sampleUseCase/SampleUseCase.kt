package com.example.rawg.domain.usecase.sampleUseCase

import com.example.rawg.data.repository.datasource.SampleDataSource
import com.example.rawg.base.domain.usecase.BaseUseCase
import com.example.rawg.data.model.ProvinceResponseItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author SamuelSep on 4/20/2021.
 */
class SampleUseCase @Inject constructor(private val repository: SampleDataSource) :
    BaseUseCase<List<ProvinceResponseItem>, SampleUseCase.Params>() {

    data class Params(val page: Int = 1)

    override suspend fun run(params: Params): Flow<List<ProvinceResponseItem>> {
        return  repository.getAllProvinces()
    }

}