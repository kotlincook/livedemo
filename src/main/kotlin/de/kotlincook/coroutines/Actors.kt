package de.kotlincook.coroutines.acotors

import de.kotlincook.coroutines.acotors.CounterMessage.GetCounter
import de.kotlincook.coroutines.acotors.CounterMessage.IncCounter
import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.runBlocking

sealed class CounterMessage {
    object IncCounter: CounterMessage()
    class GetCounter(val response: CompletableDeferred<Int>): CounterMessage()
}


fun counterActor() = actor<CounterMessage> {
    var counter = 0
    for (msg in channel) {
        when (msg) {
            is IncCounter -> counter++
            is GetCounter -> msg.response.complete(counter)
        }
    }
}



fun main(args: Array<String>) = runBlocking {
    val counter = counterActor()
    repeat(1000) {
        counter.send(IncCounter)
    }
    val response = CompletableDeferred<Int>()
    counter.send(GetCounter(response))
    println(response.await())
    // counter.close()
}
