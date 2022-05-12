package com.sary.task.features.catalog.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.sary.task.core.android.BaseListAdapter
import com.sary.task.core.extensions.loadImage
import com.sary.task.databinding.ItemCategoryBannerViewBinding
import com.sary.task.databinding.ItemCategoryGroupViewBinding
import com.sary.task.databinding.ItemCategorySmartViewBinding
import com.sary.task.features.catalog.data.entity.CategoryDataType
import com.sary.task.features.catalog.data.entity.CategoryItem

class CategoriesAdapter(onCellClick: (CategoryItem) -> Unit) :
    BaseListAdapter<ViewBinding, CategoryItem>(onCellClick) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewBinding {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            CategoryDataType.SMART.id -> ItemCategorySmartViewBinding.inflate(
                inflater,
                parent,
                false
            )
            CategoryDataType.BANNER.id -> ItemCategoryBannerViewBinding.inflate(
                inflater,
                parent,
                false
            )
            else -> ItemCategoryGroupViewBinding.inflate(
                inflater,
                parent,
                false
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).dataType.id
    }

    override fun bind(binding: ViewBinding, position: Int) {
        val item = getItem(position)
        when (binding) {
            is ItemCategorySmartViewBinding -> {
                binding.fab.loadImage(item.image)
                binding.tvName.text = item.title
            }
            is ItemCategoryBannerViewBinding -> {
                binding.imgView.loadImage(item.image)
            }
            is ItemCategoryGroupViewBinding -> {
                binding.imgView.loadImage(item.image)
                binding.tvName.text = item.title
            }
        }
    }

}