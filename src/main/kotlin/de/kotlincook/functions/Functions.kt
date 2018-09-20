package de.kotlincook.functions

fun doubler1(x: Double): Double {
    return 2 * x
}

fun doubler2(x: Double) = 2 * x

var doubler1 = fun (x: Double): Double {
    return 2 * x
}

var doubler2 = fun (x: Double) = 2 * x

var doubler3: (Double) -> Double = {x -> 2 * x}

var doubler4 =  {x: Double -> 2 * x}

// TODO : Unterschied Annonym Funktion und Lamda

val squared = {x: Double -> x*x}

val reciprocal = fun (x: Double) = 1.0 / x

val doubler = fun (x: Double) = 2 * x


fun main(args: Array<String>) {
    val comp = {x:Double -> doubler(reciprocal(x))}
}
