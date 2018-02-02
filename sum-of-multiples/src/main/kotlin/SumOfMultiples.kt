object SumOfMultiples {
    fun sum(multiples: Set<Int>, limit: Int): Int =
      ((multiples.min() ?: limit) until limit)
          .filter { i -> multiples.any { i % it == 0 } }
          .sum()
}