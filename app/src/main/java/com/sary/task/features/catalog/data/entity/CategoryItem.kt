package com.sary.task.features.catalog.data.entity

data class CategoryMainItem(
    val type: CategoryUIType,
    val rows: Int,
    val data: List<CategoryItem>,
    val header: String,
    val subHeader: String,
)

data class CategoryItem(
    val dataType: CategoryDataType,
    val image: Any = "",
    val title: String
) {
    companion object {
        fun dummyData(): List<CategoryMainItem> = listOf(
            CategoryMainItem( //Smart
                type = CategoryUIType.GRID,
                rows = 4,
                header = "Smart",
                subHeader = "sub",
                data = listOf(
                    CategoryItem(
                        dataType = CategoryDataType.SMART,
                        title = "Test1",
                        image = "https://picsum.photos/100"
                    ),

                    CategoryItem(
                        dataType = CategoryDataType.SMART,
                        title = "Test1",
                        image = "https://picsum.photos/100"
                    ),
                    CategoryItem(
                        dataType = CategoryDataType.SMART,
                        title = "Test1",
                        image = "https://picsum.photos/100"
                    ),
                    CategoryItem(
                        dataType = CategoryDataType.SMART,
                        title = "Test1",
                        image = "https://picsum.photos/100"
                    )
                )
            ),
            CategoryMainItem( //Group
                type = CategoryUIType.GRID,
                rows = 5,
                header = "GRids",
                subHeader = "",
                data = listOf(
                    CategoryItem(
                        dataType = CategoryDataType.GROUP,
                        title = "Test1",
                        image = "https://picsum.photos/100"
                    ),

                    CategoryItem(
                        dataType = CategoryDataType.GROUP,

                        title = "Test1",
                        image = "https://picsum.photos/100"
                    ),
                    CategoryItem(
                        dataType = CategoryDataType.GROUP,
                        title = "Test1",
                        image = "https://picsum.photos/100"
                    ),
                    CategoryItem(
                        dataType = CategoryDataType.GROUP,
                        title = "Test1",
                        image = "https://picsum.photos/100"
                    ),
                    CategoryItem(
                        dataType = CategoryDataType.GROUP,
                        title = "Test1",
                        image = "https://picsum.photos/100"
                    ),
                    CategoryItem(
                        dataType = CategoryDataType.GROUP,
                        title = "Test1",
                        image = "https://picsum.photos/100"
                    ),
                    CategoryItem(
                        dataType = CategoryDataType.GROUP,
                        title = "Test1",
                        image = "https://picsum.photos/100"
                    ),
                    CategoryItem(
                        dataType = CategoryDataType.GROUP,
                        title = "Test1",
                        image = "https://picsum.photos/100"
                    ),

                    )
            ),
        )
    }
}

/*
*

            CategoryMainItem(//Linear
                type = CategoryUIType.LINEAR,
                rows = 1, //if type Linear and rows is 1  so its horizontal else vertical
                header = "2Categs",
                subHeader = "",
                data = listOf(
                    CategoryItem(
                        dataType = CategoryDataType.BANNER,
                        title = "Test1",
                        image = "https://picsum.photos/100"
                    ),

                    CategoryItem(
                        dataType = CategoryDataType.BANNER,
                        title = "Test1",
                        image = "https://picsum.photos/100"
                    ),
                    CategoryItem(
                        dataType = CategoryDataType.BANNER,
                        title = "Test1",
                        image = "https://picsum.photos/100"
                    ),
                    CategoryItem(
                        dataType = CategoryDataType.BANNER,
                        title = "Test1",
                        image = "https://picsum.photos/100"
                    )
                ))*/

enum class CategoryUIType {
    GRID, LINEAR, SLIDER
}

enum class CategoryDataType(val id: Int) {
    SMART(0), GROUP(1), BANNER(2), HEADER(3)
}
