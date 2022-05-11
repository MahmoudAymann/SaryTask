package com.sary.task.core.customview.banner

data class BannerItem(val id: Int, val image: Any) {
    companion object {
        fun dummyData() = listOf(
            BannerItem(1, "https://picsum.photos/100"),
            BannerItem(2, "https://picsum.photos/100"),
            BannerItem(3, "https://picsum.photos/100"),
            BannerItem(4, "https://picsum.photos/100")
        )
    }
}