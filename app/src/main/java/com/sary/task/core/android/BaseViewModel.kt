package com.sary.task.core.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sary.task.core.arch.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel<STATE : UiState>(initState: STATE) : ViewModel() {

    private val _uiState = MutableStateFlow(initState)
    val uiState: StateFlow<STATE> = _uiState.asStateFlow()

    open val currentUiState = _uiState.value

    fun emit(uiState: STATE) {
        viewModelScope.launch {
            _uiState.update {
                uiState
            }
        }
    }
}