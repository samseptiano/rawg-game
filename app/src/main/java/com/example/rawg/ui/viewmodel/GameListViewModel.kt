package com.example.rawg.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rawg.base.data.BaseResponse
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
    @ApplicationContext private val context: Context,
    private val useCase: SampleUseCase
) : BaseViewModel() {
    private val _gameList = MutableLiveData<List<GameResponse?>?>()
    internal val gameList: LiveData<List<GameResponse?>?>
        get() = _gameList


    internal suspend fun getListGame(page: Int) {
//        val param = SampleUseCase.Params(1)
//        useCase.run(param).collect {
//            _gameList.value = it.data?.results
//        }
        val aaa = ArrayList<GameResponse>()

        aaa.add(GameResponse(1, "", "aaa", "1111/11/11", ""))
        aaa.add(GameResponse(2, "", "bbb", "2222/22/22", ""))
        aaa.add(GameResponse(3, "", "ccc", "3333/33/33", ""))
        aaa.add(GameResponse(4, "", "ccc", "3333/33/33", ""))
        aaa.add(GameResponse(5, "", "ccc", "3333/33/33", ""))
        aaa.add(GameResponse(6, "", "ccc", "3333/33/33", ""))
        aaa.add(GameResponse(7, "", "ccc", "3333/33/33", ""))
        aaa.add(GameResponse(8, "", "ccc", "3333/33/33", ""))
        aaa.add(GameResponse(9, "", "ccc", "3333/33/33", ""))
        aaa.add(GameResponse(10, "", "ccc", "3333/33/33", ""))

        _gameList.value = aaa
    }
}