package de.kotlincook.applylet

class MyClass {
    fun test() {
        val str: String = "..."

        val result = str.let {
            print(this) // Receiver
            print(it) // Argument
            42 // Block return value
        }
    }
}

fun main(args: Array<String>) {
    MyClass().test()
}