class Pangram {

    companion object {
        fun isPangram(input: String) =
             (('a'..'z') - (input.toLowerCase()).toSet()).isEmpty()
    }
}