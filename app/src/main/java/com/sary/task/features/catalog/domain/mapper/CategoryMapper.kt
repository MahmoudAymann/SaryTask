package com.sary.task.features.catalog.domain.mapper

import com.sary.task.features.catalog.data.entity.*

object CategoryMapper {

    fun mapMainList(list: List<CategoryMainItemResponse?>?): List<CategoryMainItem> = list?.map {
        mapMainItem(it)
    } ?: listOf()


    private fun mapMainItem(item: CategoryMainItemResponse?): CategoryMainItem =
        CategoryMainItem(
            type = getUiType(item?.uiType),
            rows = item?.rowCount ?: 0,
            data = mapItemList(item?.data, item?.dataType),
            header = item?.title.orEmpty(),
            subHeader = item?.subtitle.orEmpty()
        )

    private fun mapItemList(
        list: List<CategoryItemResponse?>?,
        dataType: String?
    ): List<CategoryItem> =
        list?.map { mapItem(it, dataType) } ?: listOf()

    private fun mapItem(item: CategoryItemResponse?, dataType: String?): CategoryItem =
        CategoryItem(
            dataType = getDataType(dataType),
            image = item?.image.orEmpty(),
            title = item?.name.orEmpty()
        )


    private fun getUiType(type: String?): CategoryUIType = when (type) {
        "linear" -> CategoryUIType.LINEAR
        "slider" -> CategoryUIType.SLIDER
        "grid" -> CategoryUIType.GRID
        else -> CategoryUIType.UNKNOWN
    }

    private fun getDataType(type: String?): CategoryDataType = when (type) {
        "smart" -> CategoryDataType.SMART
        "group" -> CategoryDataType.GROUP
        "banner" -> CategoryDataType.BANNER
        else -> CategoryDataType.UNKNOWN
    }

}