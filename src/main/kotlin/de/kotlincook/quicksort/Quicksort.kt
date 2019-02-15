package de.kotlincook.quicksort

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import java.util.concurrent.CompletableFuture

//suspend fun <T: Comparable<T>> List<T>.coroutSort(): List<T> {
//    println(Thread.currentThread())
//    return if (size <= 1) this
//    else {
//        val pivot = first()
//        val (lower, higher) = drop(1).partition { it <= pivot }
//        val lowFut = async { lower.coroutSort() }
//        val highFut = async { higher.coroutSort() }
//        lowFut.await() + pivot + highFut.await()
//    }
//}

suspend fun <T: Comparable<T>> List<T>.quicksort(): List<T> = coroutineScope {
    if (size <= 1) this@quicksort
    else {
        val pivot = first()
        val (left, right) = drop(1).partition { it < pivot }
        val deferredLeft = async { left.quicksort() }
        val deferredRight = async { right.quicksort() }
        deferredLeft.await() + pivot + deferredRight.await()
    }
}


fun <T> List<T>.freq():List<Int> {
    return groupBy { it }.map { it.value.size }
}


fun <T: Comparable<T>> List<T>.completeSort(): List<T> {
    return if (size <= 1) this
    else {
        val pivot = first()
        val (left, right) = drop(1).partition { it < pivot }
        val future1 = CompletableFuture.supplyAsync { left.completeSort() }
        val future2 = CompletableFuture.supplyAsync { right.completeSort() }
        future1.thenCombine(future2){f1, f2 -> f1 + pivot + f2}.get()
    }
}

fun main(args: Array<String>) = runBlocking {
    val list = listOf(5, 2, 8, 5, 4, 7, 3, 5, 4, 6)
    println(list.sorted() == list.quicksort())
}