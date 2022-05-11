package com.sary.task.features.catalog.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sary.task.core.android.BaseFragment
import com.sary.task.core.extensions.observe
import com.sary.task.databinding.FragmentCatalogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogFragment : BaseFragment<FragmentCatalogBinding>(FragmentCatalogBinding::inflate) {

    private val viewModel by viewModels<CatalogViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.uiState) {
            showProgress(it.isLoading)
        }
    }




}