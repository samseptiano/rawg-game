package com.example.rawg.data.repository.datasource

import com.example.rawg.data.model.ProvinceResponseItem
import kotlinx.coroutines.flow.Flow

/**
 * @author SamuelSep on 4/20/2021.
 */
interface SampleDataSource {
    suspend fun getAllProvinces(): Flow<List<ProvinceResponseItem>>
}