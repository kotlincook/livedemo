infix fun <S, T, U> ((T) -> U).o(f: (S) -> T): (S) -> U {
    return { n -> this(f(n)) }
}

fun( (Int, Int) -> Int).curryInt(): (Int) -> (Int) -> Int {
    return {a -> {b -> this(a,b)}}
}

fun <A, B, C> ( (A, B) -> C).curry(): (A) -> (B) -> C {
    return {a -> {b -> this(a,b)}}
}


fun main(args: Array<String>) {
    (outputter o inc o doubler)(4.0)
    println({a: Int, b: Int -> a+b}.curry()(2)(5))
}

