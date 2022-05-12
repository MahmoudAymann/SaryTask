package com.sary.task.features.catalog.ui

import com.sary.task.core.arch.UiState
import com.sary.task.core.customview.banner.BannerItem
import com.sary.task.features.catalog.data.entity.CategoryMainItem

sealed class CatalogUiState : UiState {
    data class SetBanners(val list: List<BannerItem>) : CatalogUiState()
    data class Loading(val isLoading: Boolean) : CatalogUiState()
    data class Error(val message: Any) : CatalogUiState()
    data class SetCategories(val list: List<CategoryMainItem>) : CatalogUiState()
}