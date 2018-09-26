package de.kotlincook.dsl

@DslMarker
annotation class BDDMarker

@BDDMarker
class Scenario(val descr: String,
               val context: MutableMap<String, Any> = HashMap(),
               block: Scenario.() -> Unit) {
    init {
        block()
    }

    @BDDMarker
    inner class Given(val context: MutableMap<String, Any> = this@Scenario.context)
    fun given(block: Given.() -> Unit) {
        Given().block()
    }

    @BDDMarker
    inner class Then(val context: MutableMap<String, Any> = this@Scenario.context)
    fun then(block: Then.() -> Unit) {
        Then().block()
    }
}

fun Scenario.Given.`Nutzer meldet sich an`(user: String) {
    context["User"] = user
}

val Scenario.Then.`Nutzer reget sich auf`: Unit
    get() {
        println("Der verärgerte Nutzer ist ${context["User"]}")
    }

fun main(args: Array<String>) {
    Scenario("Dies wird ein toller Test") {
        given {
            `Nutzer meldet sich an`("Vollmer")
        }
        then {
            `Nutzer reget sich auf`
        }
    }
}