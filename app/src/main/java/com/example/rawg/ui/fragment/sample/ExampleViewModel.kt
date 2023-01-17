package com.example.rawg.ui.fragment.sample

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rawg.base.viewmodel.BaseViewModel
import com.example.rawg.domain.usecase.sampleUseCase.SampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * @author SamuelSep on 4/20/2021.
 */

@HiltViewModel
class ExampleViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val useCase: SampleUseCase
) : BaseViewModel() {

    private val _error = MutableLiveData<String>("")
    val error: LiveData<String>
        get() = _error


}