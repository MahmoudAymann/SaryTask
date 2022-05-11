package com.sary.task.features.catalog.domain.usecase

import com.sary.task.core.arch.BaseUseCase
import com.sary.task.features.catalog.data.entity.BannerResponseItem
import com.sary.task.features.catalog.domain.repo.CatalogRepo
import com.sary.task.network.BaseResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GetBannersUseCase @Inject constructor(private val catalogRepo: CatalogRepo) :
    BaseUseCase<Any, Single<BaseResponse<BannerResponseItem, Any>>>() {

    override fun execute(input: Any?): Single<BaseResponse<BannerResponseItem, Any>> {
        return catalogRepo.getBanners()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


}