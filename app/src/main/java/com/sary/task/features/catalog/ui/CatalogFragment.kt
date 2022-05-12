package com.sary.task.features.catalog.ui

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.updateLayoutParams
import androidx.core.view.updateMargins
import androidx.core.view.updatePadding
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.sary.task.R
import com.sary.task.core.android.BaseFragment
import com.sary.task.core.customview.banner.BannerAdapter
import com.sary.task.core.customview.headerstatus.HeaderStatusType
import com.sary.task.core.extensions.*
import com.sary.task.databinding.FragmentCatalogBinding
import com.sary.task.databinding.ItemCategoryHeaderViewBinding
import com.sary.task.features.catalog.data.entity.CategoryItem
import com.sary.task.features.catalog.data.entity.CategoryMainItem
import com.sary.task.helper.RvUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogFragment : BaseFragment<FragmentCatalogBinding>(FragmentCatalogBinding::inflate) {

    private val viewModel by viewModels<CatalogViewModel>()
    private val bannerAdapter by lazy { BannerAdapter() }
    private val rvUtil by lazy { RvUtil(requireContext()) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observe(viewModel.uiState) {
            when (it) {
                is CatalogUiState.Error -> handleError(it.message)
                is CatalogUiState.Loading -> showProgress(it.isLoading)
                is CatalogUiState.SetBanners -> {
                    viewModel.updateSavedStateValue(viewModel.categorySavedState.copy(bannersLoaded = true))
                    binding.bannerView.setList(it.list)
                }
                is CatalogUiState.SetCategories -> setupCategoryRV(it.list)
            }
        }
        viewModel.loadBanners()
        viewModel.loadCategories()
    }

    private fun initUI() {
        //Header Status View
        binding.headerStatusView.let {
            it.setHeader(R.string.account_auth_status.localize(requireContext()))
            it.setStatus(HeaderStatusType.Start(R.string.in_review.localize(requireContext())))
        }
        //Banner
        binding.bannerView.setupBanner(bannerAdapter)
    }

    private fun setupCategoryRV(list: List<CategoryMainItem>) {
        list.forEach {
            if (it.data.isNotEmpty()) {
                handleHeaderView(it)
                handleRecyclerView(it)
            }
        }
        viewModel.updateSavedStateValue(viewModel.categorySavedState.copy(categoriesLoaded = true))
    }

    private fun handleRecyclerView(it: CategoryMainItem) {
        val layoutManager = rvUtil.getCategoryLayoutManager(it) ?: return
        val adapter = CategoriesAdapter(::onItemClick).apply { submitList(it.data) }
        val rv = RecyclerView(requireContext()).setup(adapter, layoutManager)
        binding.lineaLayoutItems.addView(rv)
        rv.updateLayoutParams<LinearLayout.LayoutParams> {
            width = LinearLayout.LayoutParams.MATCH_PARENT
            updateMargins(bottom = 8)
        }
    }

    private fun onItemClick(item: CategoryItem) {
        handleError(item.toString())
    }

    private fun handleHeaderView(it: CategoryMainItem) {
        if (it.header.isNotBlank()) {
            val header =
                binding.lineaLayoutItems.viewBinding(ItemCategoryHeaderViewBinding::inflate, false)
                    .apply {
                        tvHeader.text = it.header
                        if (it.subHeader.isNotBlank()) {
                            tvSubHead.visible()
                            tvSubHead.text = it.subHeader
                        }
                    }.root.apply {
                        updatePadding(bottom = 8)
                    }
            binding.lineaLayoutItems.addView(header)
        }
    }


    private fun handleError(message: Any) {
        Toast.makeText(requireContext(), message.localize(requireContext()), Toast.LENGTH_SHORT)
            .show()
    }


}