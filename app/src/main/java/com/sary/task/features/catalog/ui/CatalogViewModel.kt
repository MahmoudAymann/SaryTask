package com.sary.task.features.catalog.ui

import androidx.lifecycle.SavedStateHandle
import com.sary.task.R
import com.sary.task.core.android.BaseViewModel
import com.sary.task.features.catalog.domain.mapper.BannerMapper
import com.sary.task.features.catalog.domain.usecase.GetBannersUseCase
import com.sary.task.network.NetworkHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val getBannersUseCase: GetBannersUseCase,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel<CatalogUiState>() {

    private val compositeDisposable = CompositeDisposable()

    private fun checkForNetworkConnection() {
        if (!networkHandler.isNetworkAvailable()) {
            emit(CatalogUiState.Error(R.string.no_network_found))
            return
        }
    }

    fun loadBanners() {
        checkForNetworkConnection()
        emit(CatalogUiState.Loading(true))
        getBannersUseCase.execute(null).map {
            BannerMapper.mapListToUi(it.result)
        }.doFinally {
            emit(CatalogUiState.Loading(false))
        }.subscribe({ data ->
            emit(CatalogUiState.SetBanners(data))
        }, { throwable ->
            emit(CatalogUiState.Error(throwable.toString()))
        })
    }

    fun loadCategories() {
        checkForNetworkConnection()
        emit(CatalogUiState.Loading(true))
    }

    /*
    * a dummy key/value to just a pointer to save state of date when orientation changes
    * */
    //call this method when you want to auto refresh data
    fun removeSavedState() = savedStateHandle.remove<Int>("pos")

    //call this after first call
    fun setSavedStateValue(pos: Int) {
        savedStateHandle["pos"] = pos
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}