package com.sary.task.features.catalog.domain.mapper

import com.sary.task.core.customview.banner.BannerItem
import com.sary.task.features.catalog.data.entity.BannerResponseItem

object BannerMapper {

    fun mapListToUi(responseList: List<BannerResponseItem>): List<BannerItem> =
        responseList.map { mapItem(it) }

    private fun mapItem(item: BannerResponseItem): BannerItem =
        BannerItem(id = item.id ?: 0, image = item.image.orEmpty())

}