package com.example.rawg.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rawg.base.viewmodel.BaseViewModel
import com.example.rawg.data.modelMapper.GameDetail
import com.example.rawg.data.modelMapper.GameItem
import com.example.rawg.domain.usecase.sampleUseCase.GameDetailUseCase
import com.example.rawg.domain.usecase.sampleUseCase.GameListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

/**
 * @author SamuelSep on 4/20/2021.
 */

@HiltViewModel
class GameDetailViewModel @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val useCase: GameDetailUseCase
) : BaseViewModel() {
    private val _gameDetail = MutableLiveData<GameDetail?>()
    internal val gameDetail: LiveData<GameDetail?>
        get() = _gameDetail


    internal suspend fun getDetailGame(id: Int) {
        val param = GameDetailUseCase.Params(id)
        useCase.run(param).collectLatest {
            _gameDetail.value = it.data?.results
        }
    }
}