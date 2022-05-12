package com.sary.task.features.catalog.domain.repo

import com.sary.task.features.catalog.data.entity.BannerResponseItem
import com.sary.task.features.catalog.data.entity.CategoriesOtherResponse
import com.sary.task.features.catalog.data.entity.CategoryMainItemResponse
import com.sary.task.network.BaseResponse
import io.reactivex.rxjava3.core.Single

interface CatalogRepo {
    fun getBanners(): Single<BaseResponse<BannerResponseItem, Any>>
    fun getCategories(): Single<BaseResponse<CategoryMainItemResponse, CategoriesOtherResponse>>
}