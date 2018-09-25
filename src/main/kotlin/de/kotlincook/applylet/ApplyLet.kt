package de.kotlincook.applylet

class MyClass {
    fun test() {
        val str: String = "Wert"

        val dummy0 = str.let {
            println("Mark1: " + this) // Receiver
            println("Mark2: " + it) // Argument
            42
        }
        println("Dummy0: " + dummy0)

        val dummy1 = with(str) {
            println("Mark3: " + this)
            42
        }
        println("Dummy1: " + dummy1)

        val dummy2 = str.apply {
            println("Mark4: " + this)
        }
        println("Dummy2: " + dummy2)
    }
}

fun main(args: Array<String>) {
    MyClass().test()
}