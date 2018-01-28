class Drop(val factor: Int, val sound: String) {
    fun sound(n: Int):String = if (n % factor == 0) sound else ""
}

val drops: List<Drop> = listOf(Drop(3, "Pling"), Drop(5, "Plang"), Drop(7, "Plong"))

class Raindrops {
    companion object {
        fun convert(value: Int) =
            drops.joinToString("") { it.sound(value) } .takeIf { it.isNotEmpty() } ?: value.toString()
        }
    }
}