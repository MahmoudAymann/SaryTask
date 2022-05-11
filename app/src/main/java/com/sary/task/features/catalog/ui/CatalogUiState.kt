package com.sary.task.features.catalog.ui

import com.sary.task.core.arch.UiState
import com.sary.task.core.customview.banner.BannerItem

sealed class CatalogUiState : UiState {
    data class SetBanners(val list: List<BannerItem>) : CatalogUiState()
    data class Loading(val isLoading: Boolean) : CatalogUiState()
    data class Error(val message: Any) : CatalogUiState()
}