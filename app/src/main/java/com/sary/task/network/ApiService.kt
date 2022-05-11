package com.sary.task.network

import com.sary.task.features.catalog.data.entity.BannerResponseItem
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val BANNERS = "baskets/325514/banners/"
    }

    @GET
    fun getBanners(): Single<BaseResponse<BannerResponseItem, Any>>

}