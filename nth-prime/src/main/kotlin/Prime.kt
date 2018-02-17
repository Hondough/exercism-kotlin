import kotlin.math.ln

object Prime {

    fun Int.max(that: Int) = if (this > that) this else that

    fun nth(n: Int): Int {
        require(n > 0) { "There is no zeroth prime." }

        val nd = n.toDouble()
        val limit = 11.max((nd * (ln(nd) + ln(ln(nd)))).toInt())
        var primes = (2 .. limit).toList()

        primes.forEach { primes -= ((it + it) .. limit step it).toList() }

        return primes.get(n - 1)
    }



    // fun primes() = buildSequence {
    //     var terms = Pair(2, 3)

    //     // this sequence is infinite
    //     while(true) {
    //         val fac = (terms.first - 1) * terms.second
    //         if ((fac + 1) % terms.first == 0) yield(terms.first)
    //         terms = Pair(terms.first + 1, fac)
    //     }
    // }
}