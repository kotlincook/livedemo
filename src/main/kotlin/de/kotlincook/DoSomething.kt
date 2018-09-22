package de.kotlincook
fun <T> itDoesSomething(elements: List<T>): Map<T, Int> {
    return elements.groupBy { it }.mapValues { it.value.count() }
}

fun main(args: Array<String>) {
    val list = listOf(1, 5, 3, 5, 7, 8, 7, 5, 3, 24, 5, 6, 3, 2, 5, 6)
    println(itDoesSomething(list))
}