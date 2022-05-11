package com.sary.task.features.catalog.ui

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
    private val getBannersUseCase: GetBannersUseCase
) :
    BaseViewModel<CatalogUiState>() {

    private val compositeDisposable = CompositeDisposable()

    fun loadBanners() {
        if (!networkHandler.isNetworkAvailable()) {
            emit(CatalogUiState.Error(R.string.no_network_found))
            return
        }
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


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}