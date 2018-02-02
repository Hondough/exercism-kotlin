object SumOfMultiples {
    fun sum(multiples: Set<Int>, limit: Int): Int =
        multiples.flatMap { ( it until limit step it) }
            .distinct()
            .sum()
}