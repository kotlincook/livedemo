package de.kotlincook.monad

import de.kotlincook.monad.Option.Some
import de.kotlincook.reciprocal
import de.kotlincook.squareRoot

interface Monad<out T> {
    fun <S> flatMap(f: (T) -> Monad<S>): Monad<S>
}

sealed class Option<out T> : Monad<T> {
    object None : Option<Nothing>()
    data class Some<T>(val value: T) : Option<T>()

    override infix fun <S> flatMap(f: (T) -> Monad<S>): Option<S> {
        return when(this) {
            is Some -> f(value) as Option<S>
            is None -> None
        }
    }
}

fun main(args: Array<String>) {
    val some = Some(-4.0)
    val result = some flatMap reciprocal flatMap ::squareRoot
    println(result)
}
