package com.sary.task.core.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sary.task.core.arch.UiState

abstract class BaseViewModel<STATE : UiState> : ViewModel() {

    private val _uiState = MutableLiveData<STATE>()
    val uiState: LiveData<STATE> = _uiState

    fun emit(value: STATE) {
        _uiState.value = value
    }
}