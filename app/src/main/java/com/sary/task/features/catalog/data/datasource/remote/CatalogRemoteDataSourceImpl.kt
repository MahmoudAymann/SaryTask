package com.sary.task.features.catalog.data.datasource.remote

import com.sary.task.features.catalog.data.entity.BannerResponseItem
import com.sary.task.features.catalog.data.entity.CategoriesOtherResponse
import com.sary.task.features.catalog.data.entity.CategoryItemMainResponse
import com.sary.task.network.ApiService
import com.sary.task.network.BaseResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CatalogRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    CatalogRemoteDataSource {
    override fun getBanners(): Single<BaseResponse<BannerResponseItem, Any>> =
        apiService.getBanners()

    override fun getCategories(): Single<BaseResponse<CategoryItemMainResponse, CategoriesOtherResponse>> {
        return apiService.getCategories()
    }
}