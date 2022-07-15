package com.fornary4.kt

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(countReserved: Int) : ViewModel() {
    val counter = MutableLiveData<Int>()

    init {
        counter.value = countReserved
    }

    fun plusOne() {
        val count = counter.value ?: 0
        counter.value = count + 1
    }

    fun clear() {
        counter.value = 0
    }
}