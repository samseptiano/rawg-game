package com.example.rawg.data.repository

import com.example.rawg.domain.service.SampleServices
import com.example.rawg.data.model.ProvinceResponseItem
import com.example.rawg.data.repository.datasource.SampleDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * @author SamuelSep on 4/20/2021.
 */
class SampleRepository @Inject constructor(private val sampleServices: SampleServices) : SampleDataSource {

    override suspend fun getAllProvinces(): Flow<List<ProvinceResponseItem>> {
        return callbackFlow {
            send(
                sampleServices.getProvinceList()
            )
            awaitClose { this.cancel() }
        }.flowOn(Dispatchers.IO).catch {
            this.emit(listOf())
        }
    }


}