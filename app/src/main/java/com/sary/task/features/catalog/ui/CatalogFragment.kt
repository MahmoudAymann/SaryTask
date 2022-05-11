package com.sary.task.features.catalog.ui

import android.os.Bundle
import android.view.View
import com.sary.task.core.android.BaseFragment
import com.sary.task.core.customview.banner.BannerAdapter
import com.sary.task.core.customview.banner.BannerItem
import com.sary.task.databinding.FragmentCatalogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogFragment : BaseFragment<FragmentCatalogBinding>(FragmentCatalogBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bannerView.setupBanner(BannerAdapter().apply {
            submitList(
                BannerItem.dummyData()
            )
        })
    }


}