package com.sary.task.core.extensions

import android.content.Context
import android.net.ConnectivityManager
import com.google.gson.Gson
import com.sary.task.core.arch.HashMapParams
import org.json.JSONObject
import timber.log.Timber

fun Any.localize(context: Context): String =
    if (this is Int) context.getString(this) else this.toString()

val Context.connectivityManager: ConnectivityManager
    get() =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


fun HashMapParams?.toHashMapParams(): HashMap<String, String?>? {
    if (this == null) return null
    val params by lazy<HashMap<String, String?>> { HashMap() }
    try {
        JSONObject(Gson().toJson(dataClass())).let {
            if (it.names() != null)
                for (i in 0 until it.names()!!.length()) {
                    params[it.names()!!.getString(i)] =
                        it[it.names()!!.getString(i)].toString() + ""
                }
        }
    } catch (e: Exception) {
        Timber.e(e)
    }
    return if (params.isEmpty()) null else params
}