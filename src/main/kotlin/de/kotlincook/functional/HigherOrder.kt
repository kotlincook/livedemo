package de.kotlincook.functional

import de.kotlincook.functions.thread
import java.io.Closeable
import java.io.StringReader

fun execute1To10(lamda: (Double) -> Double) {
    for (i in 1..10) println(lamda(i.toDouble()))
}

fun using(cl: Closeable, block: () -> Unit) {
    try {
        block()
    }
    finally {
        cl.close()
    }
}

fun stopWatch(block: () -> Unit): Long {
    val start = System.currentTimeMillis()
    block()
    return System.currentTimeMillis() - start
}

fun main(args: Array<String>) {
    val reader = StringReader("Hallo" + Thread.currentThread())
    thread {

        val period = stopWatch {
            using(reader) {
                println(reader.readText())
            }
        }
        println("$period ms" + Thread.currentThread())
    }
}