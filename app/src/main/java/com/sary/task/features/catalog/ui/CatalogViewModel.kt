package com.sary.task.features.catalog.ui

import com.sary.task.core.android.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(): BaseViewModel<CatalogUiState>(CatalogUiState()){


}