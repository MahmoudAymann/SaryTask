package com.sary.task.helper

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sary.task.features.catalog.data.entity.CategoryMainItem
import com.sary.task.features.catalog.data.entity.CategoryUIType

class RvUtil(val context: Context) {

    fun getCategoryLayoutManager(it: CategoryMainItem): RecyclerView.LayoutManager? =
        when (it.type) {
            CategoryUIType.GRID -> {
                GridLayoutManager(context, it.rows)
            }
            CategoryUIType.LINEAR -> {
                LinearLayoutManager(
                    context,
                    RecyclerView.HORIZONTAL,
                    false
                )
            }
            CategoryUIType.SLIDER -> {
                LinearLayoutManager(
                    context, RecyclerView.HORIZONTAL,
                    false
                )
            }
            CategoryUIType.UNKNOWN -> null
        }

}