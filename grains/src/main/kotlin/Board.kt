import java.math.BigInteger

object Board {

    val lastSquare = 64

    fun getGrainCountForSquare(sq: Int): BigInteger {
        require(sq in 1 .. lastSquare) { "Only integers between 1 and $lastSquare (inclusive) are allowed" }
        return grainCount(sq - 1)
    }

    fun getTotalGrainCount() = grainCount(lastSquare).dec()

    private val grainCount: (Int) -> BigInteger = { p -> 2.toBigInteger().pow(p) }
}