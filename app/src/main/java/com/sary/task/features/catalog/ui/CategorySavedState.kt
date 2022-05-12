package com.sary.task.features.catalog.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategorySavedState(
    val bannersLoaded: Boolean = false,
    val categoriesLoaded: Boolean = false
) : Parcelable
