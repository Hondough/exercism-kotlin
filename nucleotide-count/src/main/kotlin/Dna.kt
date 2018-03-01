class Dna(string: String) {
    val nucleotideCounts: Map<Char, Int> = run {
        string.fold(mapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0))
            { acc, n -> acc + Pair(n, (acc[n]?: throw IllegalArgumentException()) + 1) }
    }
}