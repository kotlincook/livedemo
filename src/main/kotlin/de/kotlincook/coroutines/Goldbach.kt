package de.kotlincook.coroutines

import de.kotlincook.extfuns.isPrime
import kotlin.coroutines.experimental.buildSequence

val primes = buildSequence {
    for (counter in 0..Int.MAX_VALUE) {
        if (counter.isPrime()) yield(counter)
    }
}

fun goldbach(n: Int) = primes.take(n/2)
        .filter { it < n/2 }
        .filter { (n -it).isPrime() }
        .map { Pair(it, n-it) }
        .toList()

fun main(args: Array<String>) {
    println(goldbach(20))
}