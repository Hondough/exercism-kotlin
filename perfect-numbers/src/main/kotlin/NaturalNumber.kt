
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun Int.isNaturalNumber(): Boolean = this > 0
fun Int.aliquotSum(): Int = (1 .. this / 2).filter { f -> this % f == 0 } .sum()

fun classify(naturalNumber: Int): Classification {
    require(naturalNumber.isNaturalNumber())
    return when(naturalNumber.aliquotSum().compareTo(naturalNumber)) {
        -1   -> Classification.DEFICIENT
        1    -> Classification.ABUNDANT
        else -> Classification.PERFECT
    }
}