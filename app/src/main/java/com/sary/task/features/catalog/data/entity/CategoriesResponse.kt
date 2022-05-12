package com.sary.task.features.catalog.data.entity

import com.google.gson.annotations.SerializedName

data class CategoriesOtherResponse(

    @field:SerializedName("show_vat")
    val showVat: Boolean? = null,

    @field:SerializedName("business_status")
    val businessStatus: BusinessStatus? = null,

    @field:SerializedName("show_special_order_view")
    val showSpecialOrderView: Boolean? = null,

    @field:SerializedName("header")
    val header: Header? = null,

    @field:SerializedName("uncompleted_profile_settings")
    val uncompletedProfileSettings: UncompletedProfileSettings? = null
)

//class holder for all views
data class CategoryItemMainResponse(

    @field:SerializedName("metadata")
    val metadata: CategoriesMetadata? = null,

    @field:SerializedName("ui_type")
    val uiType: String? = null,

    @field:SerializedName("data")
    val data: List<CategoryItemResponse?>? = null,

    @field:SerializedName("show_title")
    val showTitle: Boolean? = null,

    @field:SerializedName("show_more_enabled")
    val showMoreEnabled: Boolean? = null,

    @field:SerializedName("subtitle")
    val subtitle: String? = null,

    @field:SerializedName("excluded_business_segments")
    val excludedBusinessSegments: List<Int?>? = null,

    @field:SerializedName("data_type")
    val dataType: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("row_count")
    val rowCount: Int? = null,

    @field:SerializedName("items_count")
    val itemsCount: Int? = null,

    @field:SerializedName("group_id")
    val groupId: Int? = null
)

data class CategoryItemResponse(

    @field:SerializedName("cover")
    val cover: Any? = null,

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("metadata")
    val metadata: Metadata? = null,

    @field:SerializedName("group_id")
    val groupId: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("header")
    val header: Any? = null,

    @field:SerializedName("group_type")
    val groupType: Any? = null,

    @field:SerializedName("deep_link")
    val deepLink: String? = null
)

data class Header(

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("type")
    val type: String? = null
)

data class CategoriesMetadata(

    @field:SerializedName("sub_title")
    val subTitle: String? = null,

    @field:SerializedName("consumable_display")
    val consumableDisplay: Any? = null,

    @field:SerializedName("title")
    val title: String? = null
)

data class UncompletedProfileSettings(

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("is_completed_profile")
    val isCompletedProfile: Boolean? = null,

    @field:SerializedName("show_tag")
    val showTag: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null
)

data class BusinessStatus(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null
)

