package functions

import java.io.Closeable
import java.io.StringReader

val squared = {x: Double -> x*x}

val reciprocal = fun (x: Double) = 1.0 / x

val doubler = fun (n: Double) = 2 * n

//fun doubler(x: Int) = 2 * x


fun executeOneToTen(n: Int, lambda: (Int) -> Int) {
    for (i in 1..10) lambda(i)
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

fun parallel(block: () -> Unit) {
    val thread =  object : Thread() {
        override fun run() {
            block()
        }
    }
    thread.start()
}




fun main(args: Array<String>) {
    executeOneToTen(4) {n -> 2 * n}
    val reader = StringReader("Hallo")
    using(reader) {
        println(reader.read())
    }
    parallel {
        println("Hello")
    }
    val period = stopwatch {
        for (i in 0..100000) i
    }
    println(period)

    doubler(reciprocal(4.0))

//    val comp = {x:Double -> doubler(reciprocal(x))}

}
