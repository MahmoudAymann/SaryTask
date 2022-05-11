package com.sary.task.features.catalog.data.di

import com.sary.task.features.catalog.data.datasource.remote.CatalogRemoteDataSource
import com.sary.task.features.catalog.data.datasource.remote.CatalogRemoteDataSourceImpl
import com.sary.task.features.catalog.data.repo.CatalogRepoImpl
import com.sary.task.features.catalog.domain.repo.CatalogRepo
import com.sary.task.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
class CatalogModule {

    @Provides
    fun provideCatalogRepo(catalogRemoteDataSource: CatalogRemoteDataSource): CatalogRepo =
        CatalogRepoImpl(catalogRemoteDataSource)

    @Provides
    fun provideCatalogRemoteDataSource(apiService: ApiService):
            CatalogRemoteDataSource = CatalogRemoteDataSourceImpl(apiService)


}