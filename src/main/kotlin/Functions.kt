import Option.*

fun squared(a: Double) = Some(a * a)

fun reciprocal(a: Double) =
        if (a == 0.0) None else Some(1.0 / a)

fun squareRoot(a: Double) =
        when {
            a < 0.0 -> None
            else -> Some(Math.sqrt(a))
        }

val doubler = fun (n: Number) = 2 * n.toInt()

val inc = { n : Number -> n.toInt() + 1 }

val outputter: (Int) -> String = { "Result: $it" }