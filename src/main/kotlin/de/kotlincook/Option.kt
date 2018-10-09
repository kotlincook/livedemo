package de.kotlincook

interface Monad<out A> {
    fun <B> flatMap(f: (A) -> Monad<B>): Monad<B>
}