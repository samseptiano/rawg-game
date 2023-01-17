package com.example.rawg.base.viewmodel

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.rawg.MainCoroutinesRule
import com.example.rawg.domain.usecase.sampleUseCase.SampleUseCase
import com.example.rawg.ui.viewmodel.GameListViewModel
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


/**
 * @author SamuelSep on 4/21/2021.
 */
@RunWith(JUnit4::class)
class GameListViewModelTest {

    // Subject under test
    private lateinit var viewModel: GameListViewModel

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesRule = MainCoroutinesRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var useCase : SampleUseCase


    @MockK
    lateinit var context: Context

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = GameListViewModel(context, useCase)
    }

    @After
    fun tearDown() {
    }
}