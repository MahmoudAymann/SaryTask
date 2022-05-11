package com.sary.task.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class SaryInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val requestBuilder: Request.Builder = request.newBuilder().apply {
            /*
             * this could be got from shared pref but i make them static for simplicity
             * */
            addHeader("Device-Type", "android")
            addHeader("App-Version", "5.5.0.0.0")
            addHeader("Accept-Language", "ar")
            addHeader("Platform", "FLAGSHIP")
            addHeader(
                "Authorization",
                "token eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MjgxNTEyLCJ1c2VyX3Bob25lIjoiOTY2NTkxMTIyMzM0In0.phRQP0e5yQrCVfZiN4YlkI8NhXRyqa1fGRx5rvrEv0o"
            )
        }
        return chain.proceed(requestBuilder.build())
    }
}