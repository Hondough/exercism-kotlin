object PigLatin {

    val vowels = listOf('a', 'e', 'i', 'o', 'u')
    val twoCharVowels = listOf("yt", "xr")

    val twoCharConsonants = listOf("ch", "qu", "th", "rh")
    val threeCharConsonants = listOf("squ", "thr", "sch")

    val translate: (String) -> String = { it.split(' ').map(anslatetray).joinToString(" ")}
    val anslatetray: (String) -> String = { s ->
        when {
            vowels.any { it == s.first() } || twoCharVowels.any { it == s.substring(0,2) }  -> s
            s.length > 3 && threeCharConsonants.any { it == s.substring(0,3) } -> s.drop(3) + s.substring(0, 3)
            s.length > 2 && twoCharConsonants.any { it == s.substring(0,2) } -> s.drop(2) + s.substring(0, 2)
            else -> s.drop(1) + s.first()
        } + "ay"
    }
}