object Sieve {

    fun primesUpTo(n: Int): List<Int> {
        // Create your range, starting at two and continuing up to and including the given limit. (i.e. [2, limit])
        var primes = (2 .. n).toList()

        // - take the next available unmarked number in your list (it is prime)
        // - mark all the multiples of that number (they are not prime)
        // Repeat until you have processed each number in your range.
        // When the algorithm terminates, all the numbers in the list that have not
        // been marked are prime.
        // *** I assumed that crossing out a number (marking) is the same as removing it
        primes.forEach { primes -= ((it + it) .. n step it).toList() }
        return primes
    }
}