package com.sary.task.features.catalog.data.entity

import com.google.gson.annotations.SerializedName

data class BannerResponseItem(
	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("metadata")
	val metadata: Metadata? = null,

	@field:SerializedName("cities")
	val cities: List<Int?>? = null,

	@field:SerializedName("level")
	val level: String? = null,

	@field:SerializedName("expiry_date")
	val expiryDate: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("promo_code")
	val promoCode: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("priority")
	val priority: Int? = null,

	@field:SerializedName("branches")
	val branches: List<Any?>? = null,

	@field:SerializedName("is_available")
	val isAvailable: Boolean? = null,

	@field:SerializedName("expiry_status")
	val expiryStatus: Boolean? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("button_text")
	val buttonText: String? = null,

	@field:SerializedName("start_date")
	val startDate: String? = null
)

data class Metadata(

	@field:SerializedName("sub_title")
	val subTitle: Any? = null,

	@field:SerializedName("consumable_display")
	val consumableDisplay: Any? = null,

	@field:SerializedName("title")
	val title: String? = null
)
