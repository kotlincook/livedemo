package de.kotlincook.companion

class MyClass {
    companion object {
        var aNumber = 0
        fun canBeCalledLikeStatic() {
            aNumber = 10
        }
    }

    fun methodOfMyClass() {
        println("has access to: " + aNumber)
    }
}