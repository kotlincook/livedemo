package de.kotlincook.functional

typealias Int2Int = (Int) -> Int

val f: Int2Int = { n -> n+3}
val g: Int2Int = { n -> n*n}

val h = f o g

//infix fun Int2Int.o(g: Int2Int): Int2Int {
//    return {n -> this(g(n))}
//}

infix fun <A,B,C> ((B) -> C).o(g: (A) -> B): (A) -> C {
    return {n -> this(g(n))}
}

fun main(args: Array<String>) {
    println(h(4))
}

