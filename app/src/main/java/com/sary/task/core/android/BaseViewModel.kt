package com.sary.task.core.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sary.task.core.arch.UiState

abstract class BaseViewModel<STATE : UiState>(initState: STATE) : ViewModel() {

    private val _uiState = MutableLiveData(initState)
    val uiState: LiveData<STATE> = _uiState

    open val currentUiState = _uiState.value
}