package de.kotlincook.nullsafety

fun main(args: Array<String>) {
    val wort : String? = "Zug"

    println(wort?.length ?: 0)

    if (wort != null) {
        println(wort.length)
    }

    when (wort) {
        null -> println("null")
        else -> println(wort.length)
    }

}

