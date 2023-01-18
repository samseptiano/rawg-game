package com.example.rawg.base.repository

import com.example.rawg.data.model.ProvinceResponseItem
import com.example.rawg.data.repository.SampleDataSourceImpl
import com.example.rawg.domain.service.SampleServices
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)

 class ProvinceRepositoryTest{
    lateinit var provinceRepository: SampleDataSourceImpl
    @MockK
    lateinit var sampleServices: SampleServices


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        provinceRepository = SampleDataSourceImpl(sampleServices)
    }

    @Test
    fun `test getAllProvinces() returns list of provinces`() = runBlocking {
        // Given
        val result = mockk<List<ProvinceResponseItem>>(relaxed = true)

        // When
        coEvery { sampleServices.getProvinceList() }
            .returns(result)

        // Invoke
        provinceRepository.getAllProvinces()


        // Then
        Assert.assertNotNull(provinceRepository.getAllProvinces())

    }
}