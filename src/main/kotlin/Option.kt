import Option.*

sealed class Option<out A> {
    object None : Option<Nothing>() {
        override fun toString() = "None"
    }
    data class Some<out B>(val value: B) : Option<B>() {
        override fun toString() = "$value"
    }

    fun <B> map(f: (A) -> B) :Option<B> =
        when (this) {
            is None -> None
            is Some -> Some(f(value))
        }

    fun <B> flatMap(f: (A) -> Option<B>): Option<B> =
        when (this) {
            is None -> None
            is Some -> f(value)
    }
}

infix fun <S, T, U> ((T) -> Option<U>).kleisli(f: (S) -> Option<T>): (S) -> Option<U> {
    return {s:S -> Option.Some<S>(s).flatMap(f).flatMap(this)}
}

fun main(args: Array<String>) {
    val together = ::squared kleisli ::reciprocal kleisli ::squareRoot
    println(Some(-4.0).flatMap(together))
}