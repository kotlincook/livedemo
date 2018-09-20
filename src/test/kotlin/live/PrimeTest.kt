package live

import io.kotlintest.inspectors.forAll
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec


class PrimeTest : StringSpec({

    val primes = listOf(2, 3, 5)
    val nonPrimes = listOf(0, 1)

    "test primes" {
        primes.forAll { it.isPrime() shouldBe true }
    }

    "test non-primes" {
        nonPrimes.forAll { it.isPrime() shouldBe false }
    }

})