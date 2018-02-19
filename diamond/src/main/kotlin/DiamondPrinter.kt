class DiamondPrinter {

    val alphabet = ('A' .. 'Z')

    fun <T>blend(half: Collection<T>) = half + half.reversed().drop(1) 

    fun printToList(char: Char): List<String> {
        val chars = ('A' .. char)
        val len = chars.count()

        val formatLine: (Int, Char) -> String = { i, c ->
            val half = " ".repeat(len - (i + 1)) + c + " ".repeat(i)
            blend(half.toList().joinToString("")
        }

        val half = chars.mapIndexed(formatLine)
        return blend(half)
    }
}
