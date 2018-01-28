
fun Int.squared() = this * this
fun Int.cubed() = this * squared()
fun Int.sumOfSeries() = (this + squared()) / 2


class Squares(val n: Int) {
    fun squareOfSum() = n.sumOfSeries().squared()
    fun sumOfSquares() = (2 * n.cubed() + 3 * n.squared() + n) / 6
    fun difference() = squareOfSum() - sumOfSquares()
}