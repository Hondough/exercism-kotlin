
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun Int.isNotNaturalNumber(): Boolean = this < 1
fun Int.aliquotSum(): Int = (1 until this).filter { f -> this % f == 0 } .sum()

fun classify(naturalNumber: Int): Classification =
    when {
        naturalNumber.isNotNaturalNumber()         -> throw IllegalArgumentException()
        naturalNumber.aliquotSum() < naturalNumber -> Classification.DEFICIENT
        naturalNumber.aliquotSum() > naturalNumber -> Classification.ABUNDANT
        else                                       -> Classification.PERFECT
    }