val rnaToDna: Map<Char, Char> = hashMapOf(
    'C' to 'G',
    'G' to 'C',
    'T' to 'A',
    'A' to 'U'
)

fun transcribeToRna(dna: String): String {
	return dna.map { rnaToDna.get(it) } .joinToString(separator = "")
}
