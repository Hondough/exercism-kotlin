object CollatzCalculator {
    tailrec fun computeStepCount(n: Int, acc: Int = 0): Int {
        require (n.isNaturalNumber()) { "Only natural numbers are allowed" }

        return when {
            n == 1 -> acc
            n.isOdd() -> computeStepCount(3 * n + 1, acc + 1)
            else -> computeStepCount(n / 2, acc + 1)
        }
    }
    fun Int.isNaturalNumber(): Boolean = this > 0
    fun Int.isOdd(): Boolean = this and 1 == 1
}