package de.kotlincook.quicksort

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking

suspend fun <T: Comparable<T>> List<T>.quicksort(): List<T> {
    println(Thread.currentThread())
    return if (size <= 1) this
    else {
        val pivot = first()
        val (lower, higher) = drop(1).partition { it <= pivot }
        val lowFut = async { lower.quicksort() }
        val highFut = async { higher.quicksort() }
        lowFut.await() + pivot + highFut.await()
    }
}


fun <T> List<T>.freq():List<Int> {
    return groupBy { it }.map { it.value.size }
}

fun main(args: Array<String>) = runBlocking {
    val list = listOf(5, 2, 8, 5, 4, 7, 3, 5, 4, 6)
    println(list.sorted() == list.quicksort())
}