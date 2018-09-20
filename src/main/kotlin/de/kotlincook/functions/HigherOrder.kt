package de.kotlincook.functions

import java.io.Closeable
import java.io.StringReader


fun executeOneToTen(lambda: (Double) -> Double) {
    for (i in 1..10) println(lambda(i.toDouble()))
}

fun using(obj: Closeable, block: () -> Unit) {
    try {
        block()
    } finally {
        obj.close()
    }
}

fun stopwatch(function: () -> Unit): Long {
    val start = System.currentTimeMillis()
    function()
    return System.currentTimeMillis() - start

}

fun thread(block: () -> Unit) {
    val thread =  object : Thread() {
        override fun run() {
            block()
        }
    }
    thread.start()
}

fun main(args: Array<String>) {
    executeOneToTen(doubler)


    val reader = StringReader("Hallo")
    using(reader) {
        println(reader.read())
    }
    thread {
        println("Hello")
    }
    val period = stopwatch {
        for (i in 0..100000) i
    }
    println(period)

}