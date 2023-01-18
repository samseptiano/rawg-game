package com.example.rawg.base.viewmodel.usecases

import com.example.rawg.data.repository.SampleRepository
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.After
import org.junit.Before
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