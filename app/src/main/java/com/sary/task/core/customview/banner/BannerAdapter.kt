package com.sary.task.core.customview.banner

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sary.task.core.android.BaseListAdapter
import com.sary.task.core.extensions.loadImage
import com.sary.task.databinding.ItemBannerViewBinding

class BannerAdapter : BaseListAdapter<ItemBannerViewBinding, BannerItem>() {
    override fun createBinding(parent: ViewGroup, viewType: Int): ItemBannerViewBinding =
        ItemBannerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    override fun bind(binding: ItemBannerViewBinding, position: Int) {
        binding.imgBanner.loadImage(getItem(position).image, progressBar = binding.pb)
    }
}