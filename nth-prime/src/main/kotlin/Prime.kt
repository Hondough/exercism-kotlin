import kotlin.math.ln
import kotlin.coroutines.experimental.buildSequence

object Prime {

    fun Int.sqrt() = Math.sqrt(this.toDouble()).toInt()

    fun nth(n: Int): Int {
        require(n > 0) { "There is no zeroth prime." }
        return primes().elementAt(n - 1)
    }

    fun primes(): Sequence<Int> = buildSequence {
        yield(2)
        yieldAll(generateSequence(3, { it + 2 })
            .filterNot { value -> (primes().takeWhile { it <= value.sqrt() }).any { value % it == 0 } } )
    }
}