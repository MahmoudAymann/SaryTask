package com.sary.task.core.customview.headerstatus

sealed class HeaderStatusType(val message: String) {
    data class Start(val startMessage: String) : HeaderStatusType(startMessage)
    data class End(val endMessage: String) : HeaderStatusType(endMessage)
}
