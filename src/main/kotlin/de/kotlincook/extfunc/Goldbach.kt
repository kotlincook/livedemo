package de.kotlincook.extfunc

import de.kotlincook.extfuns.isPrime

val primes2 = generateSequence(2, {it + 1}).filter { it.isPrime() }


val primes = sequence {
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
    println(goldbach(30 ))
}