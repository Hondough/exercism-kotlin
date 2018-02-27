class DiamondPrinter {

    val alphabet = ('A' .. 'Z')

    fun <T>blend(half: Collection<T>) = half + half.reversed().drop(1) 

    fun printToList(char: Char): List<String> {
        val chars = ('A' .. char)
        val len = chars.count()

        val formatLine: (Int, Char) -> String = { i, c ->
            val left = " ".repeat(len - (i + 1)) + c + " ".repeat(i)
            blend(left.toList()).joinToString("")
        }

        val top = chars.mapIndexed(formatLine)
        return blend(top)
    }
}
