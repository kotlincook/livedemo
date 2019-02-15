package de.kotlincook.coroutines

import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun producePipeline() = produce {
    var counter = 0;
    while(true) send(counter++)
}

fun consumePipeline(numbers: ReceiveChannel<Int>) = produce {
    for (num in numbers) send(num * num)
}

fun main(args: Array<String>) = runBlocking {
    val numbers = producePipeline()
    val squares = consumePipeline(numbers)
    for (i in 1..50) {
        println(squares.receive())
        delay(100)
    }
}