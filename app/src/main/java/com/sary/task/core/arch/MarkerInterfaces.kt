package com.sary.task.core.arch

import javax.inject.Qualifier


interface UiState

/*
* Marker interface for query classes
* */
interface HashMapParams {
    fun dataClass(): Any
}
