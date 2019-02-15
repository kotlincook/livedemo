package de.kotlincook

class Table(block: Table.() -> Any) {
    var list: MutableList<Any?> = mutableListOf()
    init {
        block()
    }
    infix fun Any?.I(value: Any?): List<Any?> {
        list = mutableListOf(this, value)
        return list
    }
    infix fun List<Any?>.I(value: Any?): List<Any?> {
        list.add(value)
        return list
    }
}

fun main(args: Array<String>) {
    val zahl: Int
    val str = Table {
        null      I null     I null
        "Krappe"  I "Studdi" I "Fritenbock"
    }
    println()


}








