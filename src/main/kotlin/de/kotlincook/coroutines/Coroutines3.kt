package de.kotlincook.coroutines3

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking


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
    val v1 = async(coroutineContext) { timeConsuming1() }
    val v2 = async(coroutineContext) { timeConsuming2() }
    println("${v1.await()} ${v2.await()}")
}