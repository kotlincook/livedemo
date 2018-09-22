package de.kotlincook.coroutines2

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.coroutineContext

fun timeConsuming1(): String {
    println("Start1")
    Thread.sleep(1000)
    println("End1")
    return "I like"
}

fun timeConsuming2(): String {
    println("Start2")
    Thread.sleep(1000)
    println("End2")
    return "coroutines"
}


fun main(args: Array<String>) = runBlocking {
    val v1 = async { timeConsuming1() }
    val v2 = async { timeConsuming2() }
    println("${v1.await()} ${v2.await()}")
}