package com.example.rawg.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rawg.base.coroutine.AppDispatchers
import kotlinx.coroutines.cancel
import javax.inject.Inject

open class BaseViewModel : ViewModel() {
    @Inject
    lateinit var appDispatchers: AppDispatchers


    protected val _loading by lazy { MutableLiveData<Boolean>() }
    val loading: LiveData<Boolean> = _loading

    protected val coroutineScope by lazy { appDispatchers.getScope() }

    fun handleError(resCode: Int, message:String){

    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}