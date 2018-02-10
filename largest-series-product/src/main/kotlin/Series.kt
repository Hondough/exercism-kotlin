class Series(val series: String) {

    init {
        require(series.all(Char::isDigit))
    }
 
    fun getLargestProduct(n: Int): Int {
        require(n >= 0 && n <= series.length)

        return (0 .. series.length - n)
            .map { series.subSequence(it, it + n)
                .map(Character::getNumericValue)
                .fold (1) { acc, i -> acc * i } }
            .max() ?: -1
    }
}