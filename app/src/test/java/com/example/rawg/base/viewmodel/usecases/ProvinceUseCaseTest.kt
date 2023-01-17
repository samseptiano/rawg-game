package com.example.rawg.base.viewmodel.usecases

import com.example.rawg.data.model.ProvinceResponseItem
import com.example.rawg.data.repository.SampleRepository
import com.example.rawg.domain.usecase.sampleUseCase.SampleUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * @author SamuelSep on 4/21/2021.
 */
@RunWith(JUnit4::class)
class ProvinceUseCaseTest {

    @MockK
    private lateinit var repository: SampleRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }


    @After
    fun tearDown() {
    }
}