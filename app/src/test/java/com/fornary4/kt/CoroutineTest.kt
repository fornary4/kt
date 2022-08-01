package com.fornary4.kt

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.sync.withPermit
import org.junit.Test
import java.util.concurrent.atomic.AtomicInteger

class CoroutineTest {

    fun simpleList(): List<Int> = listOf<Int>(1, 5, 3)

    suspend fun simpleFlow() = flow<Int> {
        println("Flow started ${Thread.currentThread().name}")
        for (i in 1..3) {
            delay(1000)
            emit(i)
        }
    }.flowOn(Dispatchers.IO)

    fun numbers() = flow<Int> {
        emit(1)
        emit(2)
        emit(3)
    }

    @Test
    fun test(): Unit = runBlocking {
        var count = 0
        val  result = count + List(1000) {
            GlobalScope.async {
                1
            }
        }.map {
            it.await()
        }.sum()
        println(result)
    }

}