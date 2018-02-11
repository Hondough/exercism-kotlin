class Series(val series: String) {

    init {
        require(series.all(Char::isDigit))
    }
 
    fun getLargestProduct(n: Int): Int {
        require(n >= 0 && n <= series.length)

        return if (n == 0) 1 
        else series.map(Character::getNumericValue)
            .windowed(n)
            .map { it.reduce { acc, i -> acc * i } }
            .max() ?: 1
    }
}