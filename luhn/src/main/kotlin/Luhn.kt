fun Char.getDigit() = this.toInt() - 48

object Luhn {
    fun isValid(sin: String): Boolean {
        val cleanInput = sin.filterNot { it.isWhitespace() }
        val isValid = cleanInput.length > 1 && cleanInput.all { it.isDigit() }
        return isValid
            && cleanInput
            .reversed()
            .foldIndexed (0) { index, acc, c -> acc + if (index % 2 == 0) c.getDigit() else c.getDigit() * 2 + c.getDigit() / 5 } % 10 == 0
    }
}