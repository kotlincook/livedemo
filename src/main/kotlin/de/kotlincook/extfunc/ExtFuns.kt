package de.kotlincook.extfuns

import java.math.BigDecimal
import java.text.SimpleDateFormat

enum class Currency {
    EURO
}
data class Amount(val value: BigDecimal, val currency: Currency)

val Double.bd: BigDecimal
    get() {
        return BigDecimal(this)
    }

val BigDecimal.euro: Amount
    get() = Amount(this, Currency.EURO)


fun String.toDate(pattern: String = "yyyy-MM-dd") =
        SimpleDateFormat(pattern).parse(this)

fun Int.isEven() = this % 2 == 0

infix fun Int.divides(n: Int) = n % this == 0

object MoreMath {
    fun sqrt(n : Int) = Math.ceil(Math.sqrt(n.toDouble())).toInt()
}

fun Int.isPrime() = when {
    this in 0..1 -> false
    this == 2 -> true
    this.isEven() -> false
    else -> (3..MoreMath.sqrt(this)).any { it divides this }.not()
}

fun main(args: Array<String>) {
    println("2018-08-23".toDate())

    val zahl = 123
    println(zahl.isEven())
    println(MoreMath.sqrt(121))
    println(100.00.bd.euro)
}

