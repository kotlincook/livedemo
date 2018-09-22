package de.kotlincook.monad

import de.kotlincook.monad.Option.Some

interface Monad<out T> {
    infix fun <S> flatMap(f: (T) -> Monad<S>): Monad<S>
}

sealed class Option<T> : Monad<T> {
    object None : Option<Nothing>()
    data class Some<T>(val value: T) : Option<T>()

    override infix fun <S> flatMap(f: (T) -> Monad<S>): Monad<S> {
        return when(this) {
            is Some -> f(value)
            is None -> None
        }
    }
}

val reciprocal = {x:Double -> if (x == 0.0) Option.None else Option.Some(1.0/x) }
val squareRoot = fun(x: Double) = if (x < 0.0) Option.None else Option.Some(Math.sqrt(x))

fun main(args: Array<String>) {
    val some = Some(-4.0)
    val result = some flatMap reciprocal flatMap squareRoot
    println(result)
}
