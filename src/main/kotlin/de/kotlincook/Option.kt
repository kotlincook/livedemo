package de.kotlincook

interface Monad<out T> {
    fun <S> flatMap(f: (T) -> Monad<S>): Monad<S>
}