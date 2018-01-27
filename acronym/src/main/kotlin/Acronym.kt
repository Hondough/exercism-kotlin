class Acronym {
    companion object {
        fun generate(phrase: String) =
            phrase.split(' ', '-').map {it.first().toUpperCase()} .joinToString("")
    }
}