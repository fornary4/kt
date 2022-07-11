package com.fornary4.kt.http

import java.lang.Exception

interface HttpCallbackListener {
    fun onFinish(response: String)
    fun onError(e: Exception)

}