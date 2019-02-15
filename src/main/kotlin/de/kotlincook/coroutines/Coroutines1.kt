package de.kotlincook.coroutines1
fun timeConsuming1(): String {
    println("Start1")
    Thread.sleep(1000)
    println("End1")
    return "I like"
}

fun timeConsuming2(): String {
    println("Start2")
    Thread.sleep(1000)
    println("End2")
    return "coroutines"
}


fun main(args: Array<String>) {
    val v1 = timeConsuming1()
    val v2 = timeConsuming2()
    println("${v1} ${v2}")
}