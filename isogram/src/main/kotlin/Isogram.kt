object Isogram {
    fun isIsogram(input: String): Boolean =
        input.filter { it.isLetter() } .toLowerCase()
            .let { it.length == it.toSet().size }
}