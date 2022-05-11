package com.sary.task.features.catalog.data.repo

import com.sary.task.features.catalog.data.datasource.remote.CatalogRemoteDataSource
import com.sary.task.features.catalog.data.entity.BannerResponseItem
import com.sary.task.features.catalog.domain.repo.CatalogRepo
import com.sary.task.network.BaseResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CatalogRepoImpl @Inject constructor(private val catalogRemoteDataSource: CatalogRemoteDataSource) :
    CatalogRepo {
    override fun getBanners(): Single<BaseResponse<BannerResponseItem, Any>> =
        catalogRemoteDataSource.getBanners()
}