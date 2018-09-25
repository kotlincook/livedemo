package de.kotlincook.dsl

class Scenario(val descr: String,
               val context: MutableMap<String, Any> = HashMap(),
               block: Scenario.() -> Unit) {
    init {
        block()
    }
    inner class Given(val context: MutableMap<String, Any> = this@Scenario.context)
    fun given(block: Given.() -> Unit) {
        Given().block()
    }
}

fun Scenario.Given.`Nutzer meldet sich an`(user: String) {
    context["User"] = user
}

val Scenario.Given.`Nutzer reget sich auf`: Unit
    get() {
        println("Der Nutzer ist ${context["User"]}")
    }

fun main(args: Array<String>) {
    Scenario("Dies wird ein toller Test") {
        given {
            `Nutzer meldet sich an`("Vollmer")
            `Nutzer reget sich auf`
        }
    }
}

