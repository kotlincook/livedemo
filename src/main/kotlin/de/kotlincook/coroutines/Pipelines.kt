package de.kotlincook.coroutines

import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.produce
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

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