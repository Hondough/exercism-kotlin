class DiamondPrinter {

    val alphabet = ('A' .. 'Z')

    // val blend: (ReversableAndDropable) -> ReversableAndDropable = { half -> half + half.reversed().drop(1) }

    fun printToList(char: Char): List<String> {
        val chars = ('A' .. char)
        val len = chars.count()

        val formatLine: (Int, Char) -> String = { i, c ->
            val half = " ".repeat(len - (i + 1)) + c + " ".repeat(i)
            half + half.reversed().drop(1)
        }

        val half = chars.mapIndexed(formatLine)
        return half + half.reversed().drop(1)
    }
}
