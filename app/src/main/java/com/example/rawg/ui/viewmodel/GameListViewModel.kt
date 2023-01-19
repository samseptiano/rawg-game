package com.example.rawg.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rawg.base.viewmodel.BaseViewModel
import com.example.rawg.data.modelMapper.GameItem
import com.example.rawg.domain.usecase.sampleUseCase.GameListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * @author SamuelSep on 4/20/2021.
 */

@HiltViewModel
class GameListViewModel @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val useCase: GameListUseCase
) : BaseViewModel() {
    private val _gameList = MutableLiveData<List<GameItem?>?>()
    internal val gameList: LiveData<List<GameItem?>?>
        get() = _gameList


    internal suspend fun getListGame(page: Int? = null, pageSize: Int? = null, search: String? = null) {
        val param = GameListUseCase.Params(page, pageSize, search)
        useCase.run(param).apply {
            onSuccess {
                _gameList.value = it.results

            }
        }
    }
}