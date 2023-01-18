package com.example.rawg.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rawg.base.viewmodel.BaseViewModel
import com.example.rawg.data.model.GameResponse
import com.example.rawg.domain.usecase.sampleUseCase.SampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

/**
 * @author SamuelSep on 4/20/2021.
 */

@HiltViewModel
class GameListViewModel @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val useCase: SampleUseCase
) : BaseViewModel() {
    private val _gameList = MutableLiveData<List<GameResponse?>?>()
    internal val gameList: LiveData<List<GameResponse?>?>
        get() = _gameList


    internal suspend fun getListGame(page: Int? = null, pageSize: Int? = null, search: String? = null) {
        val param = SampleUseCase.Params(page, pageSize, search)
        useCase.run(param).collect {
            _gameList.value = it.data?.results
        }
    }
}