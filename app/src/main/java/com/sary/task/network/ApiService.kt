package com.sary.task.network

import com.sary.task.features.catalog.data.entity.BannerResponseItem
import com.sary.task.features.catalog.data.entity.CategoriesOtherResponse
import com.sary.task.features.catalog.data.entity.CategoryItemMainResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val BANNERS = "baskets/325514/banners"
        const val CATEGORIES = "baskets/325514/catalog"
    }

    @GET(BANNERS)
    fun getBanners(): Single<BaseResponse<BannerResponseItem, Any>>

    @GET(CATEGORIES)
    fun getCategories(): Single<BaseResponse<CategoryItemMainResponse, CategoriesOtherResponse>>

}