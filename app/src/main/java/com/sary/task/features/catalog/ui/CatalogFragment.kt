package com.sary.task.features.catalog.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.sary.task.R
import com.sary.task.core.android.BaseFragment
import com.sary.task.core.customview.banner.BannerAdapter
import com.sary.task.core.customview.headerstatus.HeaderStatusType
import com.sary.task.core.extensions.localize
import com.sary.task.core.extensions.observe
import com.sary.task.databinding.FragmentCatalogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogFragment : BaseFragment<FragmentCatalogBinding>(FragmentCatalogBinding::inflate) {

    private val viewModel by viewModels<CatalogViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observe(viewModel.uiState) {
            when (it) {
                is CatalogUiState.Error -> handleError(it.message)
                is CatalogUiState.Loading -> showProgress(it.isLoading)
                is CatalogUiState.SetBanners -> {
                    binding.bannerView.setList(it.list)
                }
            }
        }
        viewModel.loadBanners()
    }

    private fun initUI() {
        binding.bannerView.setupBanner(bannerAdapter)
        binding.headerStatusView.let {
            it.setHeader(R.string.account_auth_status.localize(requireContext()))
            it.setStatus(HeaderStatusType.Start(R.string.in_review.localize(requireContext())))
        }
    }

    private val bannerAdapter by lazy { BannerAdapter() }

    private fun handleError(message: Any) {
        Toast.makeText(requireContext(), message.localize(requireContext()), Toast.LENGTH_SHORT)
            .show()
    }


}