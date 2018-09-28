package de.kotlincook.quiz

fun String.saySomething() = {
    println(this + "Softwerkskammer")
}

fun main(args: Array<String>) {
    "I enjoy ".saySomething()
}