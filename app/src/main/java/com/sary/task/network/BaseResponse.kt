package com.sary.task.network

import com.google.gson.annotations.SerializedName

data class BaseResponse<R, O>(
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: List<R>,
    @SerializedName("other")
    val other: O
)