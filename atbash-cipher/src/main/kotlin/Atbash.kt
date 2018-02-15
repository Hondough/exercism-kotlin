object Atbash {
    val dictionary = ('a' .. 'z').let { it.zip(it.reversed()) } .toMap()

    fun encode(pt: String) = transmorgify(pt, convertAndFormat(" "))

    fun decode(ct: String) = transmorgify(ct, convertAndFormat())

    private fun transmorgify(text: String, convertAndFormat: (Int, StringBuilder, Char) -> StringBuilder): String =
        text.asSequence()
        .filter { it.isLetterOrDigit() }
        .foldIndexed(StringBuilder(), convertAndFormat)
        .toString()

    private fun convertAndFormat(separator: String = ""): (Int, StringBuilder, Char) -> StringBuilder =
        { index: Int, acc: StringBuilder, c: Char ->
            acc.append((if (index % 5 == 0 && index != 0) separator else "") + dictionary.getOrDefault(c.toLowerCase(), c ).toString()) }
}