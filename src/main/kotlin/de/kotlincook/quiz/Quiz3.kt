package de.kotlincook.quiz

fun main(args: Array<String>) {
    val list1 = mutableListOf(1, 2, 3)
    val list2 = list1.add(4)
    print(list1 + list2)
}