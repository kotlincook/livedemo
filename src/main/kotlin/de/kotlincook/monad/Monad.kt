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

infix fun <S, T, U> ((T) -> Monad<U>).kleisli(f: (S) -> Monad<T>): (S) -> Monad<U> {
    return {s: S -> Some(s).flatMap(f).flatMap(this)}
}

val reciprocal = {x:Double -> if (x == 0.0) Option.None else Some(1.0/x) }
val squareRoot = fun(x: Double) = if (x < 0.0) Option.None else Some(Math.sqrt(x))

fun main(args: Array<String>) {
    val some = Some(-4.0)
    val result1 = some flatMap reciprocal flatMap squareRoot
    val together = reciprocal kleisli squareRoot
    val result2 = some flatMap together
    println(result1)
    println(result2)
}
