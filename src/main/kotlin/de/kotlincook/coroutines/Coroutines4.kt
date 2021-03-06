package de.kotlincook.coroutines4

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun timeConsuming1(): String {
    println("Start1")
    delay(1000)
    println("End1")
    return "I like"
}

suspend fun timeConsuming2(): String {
    println("Start2")
    delay(1000)
    println("End2")
    return "coroutines"
}


fun main(args: Array<String>) = runBlocking {
    val v1 = async(coroutineContext) { timeConsuming1() }
    val v2 = async(coroutineContext) { timeConsuming2() }
    println("${v1.await()} ${v2.await()}")
}