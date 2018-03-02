object WordCount {
    fun phrase(sentence: String): Map<String, Int> = sentence
        .toLowerCase()
        .split("""\W'|'\W|[^\w']+""".toRegex())
        .filter { it.isNotEmpty() }
        .groupingBy { it }.eachCount()
}