package com.sary.task.features.catalog.domain.usecase


import com.sary.task.core.arch.BaseUseCase
import com.sary.task.features.catalog.data.entity.CategoriesOtherResponse
import com.sary.task.features.catalog.data.entity.CategoryMainItemResponse
import com.sary.task.features.catalog.domain.repo.CatalogRepo
import com.sary.task.network.BaseResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val repo: CatalogRepo) :
    BaseUseCase<Any, Single<BaseResponse<CategoryMainItemResponse, CategoriesOtherResponse>>>() {
    override fun execute(input: Any?): Single<BaseResponse<CategoryMainItemResponse, CategoriesOtherResponse>> {
        return repo.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}